package com.xcloud.helloworld.provider.mq.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author xuehy
 * @since 2022/6/2
 */
@Slf4j
@Component
public class MQTestEvent {

    //测试类型
    public static final String TYPE_TEST = "test";

    public void testEvent(String message) {
        log.info("收到测试消息:{}", message);
    }

}
