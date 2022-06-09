package com.xcloud.helloworld.provider.controller;

import com.xcloud.helloworld.provider.service.SentinelTestService;
import com.xcloud.util.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xuehy
 * @since 2022/6/9
 */
@Slf4j
@RestController
public class SentinelTestController {

    @Resource
    private SentinelTestService sentinelTestService;

    //限流/降级/系统保护测试接口
    @PostMapping("/blockTest")
    public Result blockTest() {
        return sentinelTestService.blockTest();
    }

}
