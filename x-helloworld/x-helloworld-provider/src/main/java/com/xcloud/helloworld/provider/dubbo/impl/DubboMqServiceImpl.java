package com.xcloud.helloworld.provider.dubbo.impl;

import com.xcloud.helloworld.common.dubbo.DubboMqService;
import com.xcloud.helloworld.common.dubbo.DubboTestService;
import com.xcloud.helloworld.provider.controller.MqController;
import com.xcloud.helloworld.provider.controller.TestController;
import com.xcloud.util.result.Result;
import org.apache.dubbo.common.constants.LoadbalanceRules;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * 对外暴露的接口(轮询)
 * @author xuehy
 * @since 2022/6/1
 */
@DubboService(loadbalance = LoadbalanceRules.ROUND_ROBIN)
public class DubboMqServiceImpl implements DubboMqService {

    @Resource
    private MqController mqController;

    @Override
    public Result rocketMQTest(String message) {
        return mqController.rocketMQTest(message);
    }

}
