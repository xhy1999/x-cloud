package com.xcloud.helloworld.provider.service;

import com.xcloud.util.result.Result;

/**
 * @author xuehy
 * @since 2022/6/9
 */
public interface SentinelTestService {

    //限流/降级/系统保护测试
    Result blockTest();

}
