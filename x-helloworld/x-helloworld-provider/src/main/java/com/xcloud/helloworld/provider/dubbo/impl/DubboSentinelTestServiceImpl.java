package com.xcloud.helloworld.provider.dubbo.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.xcloud.helloworld.common.dubbo.DubboSentinelTestService;
import com.xcloud.helloworld.common.sentinel.SentinelTestBlockHandler;
import com.xcloud.helloworld.common.sentinel.SentinelTestFallBackHandler;
import com.xcloud.helloworld.common.sentinel.constant.SentinelConst;
import com.xcloud.helloworld.provider.controller.MqController;
import com.xcloud.helloworld.provider.controller.SentinelTestController;
import com.xcloud.util.result.Result;
import org.apache.dubbo.common.constants.LoadbalanceRules;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author xuehy
 * @since 2022/6/9
 */
@DubboService(loadbalance = LoadbalanceRules.SHORTEST_RESPONSE)
public class DubboSentinelTestServiceImpl implements DubboSentinelTestService {

    @Resource
    private SentinelTestController sentinelTestController;

    @Override
    @SentinelResource(value = SentinelConst.SENTINEL_TEST_GROUP,
            blockHandler = "blockTest", blockHandlerClass = SentinelTestBlockHandler.class,
            fallback = "blockTest", fallbackClass = SentinelTestFallBackHandler.class)
    public Result blockTest() {
        return sentinelTestController.blockTest();
    }

}
