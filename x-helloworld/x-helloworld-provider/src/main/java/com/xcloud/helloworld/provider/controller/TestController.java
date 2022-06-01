package com.xcloud.helloworld.provider.controller;

import com.xcloud.util.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuehy
 * @since 2022/6/1
 */
@Slf4j
@RestController
public class TestController {

    @Value("${project.host}")
    private String host;

    //项目地址测试接口
    @PostMapping("/lbTest")
    public Result lbTest() {
        return Result.success(host + ":大力出奇迹!");
    }

}
