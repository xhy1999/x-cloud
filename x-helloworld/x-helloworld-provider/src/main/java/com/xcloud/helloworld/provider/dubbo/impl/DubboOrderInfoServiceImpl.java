package com.xcloud.helloworld.provider.dubbo.impl;

import com.xcloud.helloworld.common.dubbo.DubboOrderDetailService;
import com.xcloud.helloworld.common.dubbo.DubboOrderInfoService;
import com.xcloud.helloworld.common.pojo.entity.OrderDetailEntity;
import com.xcloud.helloworld.common.pojo.entity.OrderInfoEntity;
import com.xcloud.helloworld.provider.service.OrderDetailService;
import com.xcloud.helloworld.provider.service.OrderInfoService;
import org.apache.dubbo.common.constants.LoadbalanceRules;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * 对外暴露的接口(轮询)
 * @author xuehy
 * @since 2022/6/1
 */
@DubboService(loadbalance = LoadbalanceRules.ROUND_ROBIN)
public class DubboOrderInfoServiceImpl implements DubboOrderInfoService {

    @Resource
    private OrderInfoService orderInfoService;

    @Override
    public void saveOrderInfo(OrderInfoEntity orderInfoEntity) {
        orderInfoService.saveOrderInfo(orderInfoEntity);
    }

}
