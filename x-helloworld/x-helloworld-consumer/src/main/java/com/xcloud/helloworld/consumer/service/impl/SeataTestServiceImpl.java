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
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author xuehy
 * @since 2022/7/12
 */
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
    public Result submitOrder() {
        //获取用户信息
        UserEntity user = dubboUserService.getUserInfo("10001");
        //获取商品信息
        GoodsInfoEntity goodsInfo1 = dubboGoodsInfoService.getGoodsInfo(1);
        int goodsNum1 = 2;
        GoodsInfoEntity goodsInfo2 = dubboGoodsInfoService.getGoodsInfo(2);
        int goodsNum2 = 6;
        //进行一些判断...
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

        dubboOrderInfoService.saveOrderInfo(orderInfoEntity);

        user.setBalance(userBalance);
        dubboUserService.updateUserInfo(user);

        return Result.success();
    }

}
