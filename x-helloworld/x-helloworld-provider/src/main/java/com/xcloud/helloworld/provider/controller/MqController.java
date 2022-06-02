package com.xcloud.helloworld.provider.controller;

import com.xcloud.helloworld.provider.mq.RocketMQUtil;
import com.xcloud.helloworld.provider.mq.event.MQTestEvent;
import com.xcloud.util.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;

/**
 * @author xuehy
 * @since 2022/6/2
 */
@Slf4j
@Validated
@RestController
public class MqController {

    @Resource
    private RocketMQUtil rocketMQUtil;

    //rocketMQ测试
    @PostMapping("/rocketMQTest")
    public Result rocketMQTest(@RequestParam(value = "message", required = false) @NotBlank(message="消息[message]不能为空") String message) {
        //发送500条消息
        for (int i = 0; i < 300; i++) {
            rocketMQUtil.sendPublicMessage(MQTestEvent.TYPE_TEST, message + i);
        }
        return Result.success();
    }

}
