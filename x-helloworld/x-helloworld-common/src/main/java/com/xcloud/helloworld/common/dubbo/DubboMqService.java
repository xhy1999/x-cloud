package com.xcloud.helloworld.common.dubbo;

import com.xcloud.util.result.Result;

/**
 * 需要Dubbo暴露的服务
 * @author xuehy
 * @since 2022/6/2
 */
public interface DubboMqService {

    //rocketMQ测试
    Result rocketMQTest(String message);

}
