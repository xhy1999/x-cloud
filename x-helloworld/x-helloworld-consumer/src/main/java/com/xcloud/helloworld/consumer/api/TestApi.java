package com.xcloud.helloworld.consumer.api;

import com.xcloud.helloworld.common.dubbo.DubboTestService;
import com.xcloud.util.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuehy
 * @since 2022/6/1
 */
@Slf4j
@Validated
@RestController
public class TestApi {

    @DubboReference(timeout = 20000)
    private DubboTestService dubboUserService;

    @PostMapping("/lbTest")
    public Result lbTest() {
        return dubboUserService.lbTest();
    }

}
