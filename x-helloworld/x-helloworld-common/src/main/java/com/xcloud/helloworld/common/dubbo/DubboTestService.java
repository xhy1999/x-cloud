package com.xcloud.helloworld.common.dubbo;

import com.xcloud.util.result.Result;

/**
 * 需要Dubbo暴露的服务
 * @author xuehy
 * @since 2022/6/1
 */
public interface DubboTestService {

    //项目地址测试
    Result lbTest();

}
