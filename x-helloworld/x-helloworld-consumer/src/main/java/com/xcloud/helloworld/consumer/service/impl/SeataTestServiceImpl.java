package com.xcloud.helloworld.consumer.service.impl;

import com.xcloud.helloworld.common.constant.UUIDConst;
import com.xcloud.helloworld.common.dubbo.*;
import com.xcloud.helloworld.common.pojo.entity.GoodsInfoEntity;
import com.xcloud.helloworld.common.pojo.entity.OrderDetailEntity;
import com.xcloud.helloworld.common.pojo.entity.OrderInfoEntity;
import com.xcloud.helloworld.common.pojo.entity.UserEntity;
import com.xcloud.helloworld.consumer.service.SeataTestService;
import com.xcloud.util.UUIDUtil;
import com.xcloud.util.result.Result;
import com.xcloud.util.result.ResultCode;
import io.seata.core.context.RootContext;
import io.seata.core.exception.TransactionException;
import io.seata.spring.annotation.GlobalTransactional;
import io.seata.tm.api.GlobalTransactionContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author xuehy
 * @since 2022/7/12
 */
@Slf4j
@Service
public class SeataTestServiceImpl implements SeataTestService {

    @DubboReference(timeout = 2000)
    private DubboUserService dubboUserService;
    @DubboReference(timeout = 2000)
    private DubboGoodsInfoService dubboGoodsInfoService;
    @DubboReference(timeout = 2000)
    private DubboOrderInfoService dubboOrderInfoService;
    @DubboReference(timeout = 2000)
    private DubboOrderDetailService dubboOrderDetailService;

    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public Result submitOrder() throws TransactionException {
        log.info("开始全局事务:xid="+ RootContext.getXID());
        //获取用户信息
        UserEntity user = dubboUserService.getUserInfo("10001");
        //获取商品信息
        GoodsInfoEntity goodsInfo1 = dubboGoodsInfoService.getGoodsInfo(1);
        int goodsNum1 = 2;
        GoodsInfoEntity goodsInfo2 = dubboGoodsInfoService.getGoodsInfo(2);
        int goodsNum2 = 6;
        //进行一些判断...

        if (goodsInfo1.getInventoryNum() < goodsNum1) {
            return Result.fail(ResultCode.ERR_PARAM, "商品[" + goodsInfo1.getName() + "]库存不足");
        }
        if (goodsInfo2.getInventoryNum() < goodsNum2) {
            return Result.fail(ResultCode.ERR_PARAM, "商品[" + goodsInfo2.getName() + "]库存不足");
        }

        //开始生成订单
        OrderInfoEntity orderInfoEntity = new OrderInfoEntity();
        String orderId = UUIDUtil.getUUID(UUIDConst.ORDER_ID_HEAD, UUIDConst.ID_LENGTH);

        OrderDetailEntity detailEntity1 = new OrderDetailEntity();
        detailEntity1.setOrderId(orderId);
        detailEntity1.setGoodsId(goodsInfo1.getId());
        detailEntity1.setGoodsNum(goodsNum1);
        detailEntity1.setUnitPrice(goodsInfo1.getUnitPrice());
        detailEntity1.setTotalPrice(goodsInfo1.getUnitPrice().multiply(new BigDecimal(goodsNum1)));

        OrderDetailEntity detailEntity2 = new OrderDetailEntity();
        detailEntity2.setOrderId(orderId);
        detailEntity2.setGoodsId(goodsInfo2.getId());
        detailEntity2.setGoodsNum(goodsNum2);
        detailEntity2.setUnitPrice(goodsInfo2.getUnitPrice());
        detailEntity2.setTotalPrice(goodsInfo2.getUnitPrice().multiply(new BigDecimal(goodsNum2)));

        orderInfoEntity.setId(orderId);
        orderInfoEntity.setUserId(user.getId());
        orderInfoEntity.setTotalPrice(detailEntity1.getTotalPrice().add(detailEntity2.getTotalPrice()));

        BigDecimal userBalance = user.getBalance().subtract(orderInfoEntity.getTotalPrice());

        if (userBalance.compareTo(BigDecimal.ZERO) < 0) {
            return Result.fail(ResultCode.ERR_PARAM, "用户余额不足!");
        }

        //保存订单明细
        dubboOrderDetailService.saveOrderDetail(detailEntity1);
        dubboOrderDetailService.saveOrderDetail(detailEntity2);
        //手动回滚
        //System.out.println(RootContext.getXID() == null);
        //GlobalTransactionContext.reload(RootContext.getXID()).rollback();
        System.out.println(100 / (100 - 100));

        dubboOrderInfoService.saveOrderInfo(orderInfoEntity);

        user.setBalance(userBalance);
        dubboUserService.updateUserInfo(user);

        return Result.success();
    }

}
