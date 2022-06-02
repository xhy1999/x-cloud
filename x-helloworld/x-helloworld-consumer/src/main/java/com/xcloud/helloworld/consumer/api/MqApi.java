package com.xcloud.helloworld.consumer.api;

import com.xcloud.helloworld.common.dubbo.DubboMqService;
import com.xcloud.util.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * @author xuehy
 * @since 2022/6/2
 */
@Slf4j
@Validated
@RestController
public class MqApi {

    @DubboReference
    private DubboMqService dubboMqService;

    @PostMapping("/rocketMQTest")
    public Result rocketMQTest(@RequestParam(value = "message", required = false) @NotBlank(message="消息[message]不能为空") String message) {
        return dubboMqService.rocketMQTest(message);
    }

}
