package com.xcloud.helloworld.provider.mq.listener;

import cn.hutool.core.collection.ConcurrentHashSet;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.xcloud.helloworld.provider.constant.RocketMQConst;
import com.xcloud.helloworld.provider.mq.event.MQTestEvent;
import com.xcloud.helloworld.provider.pojo.RocketMessageEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author xuehy
 * @since 2022/6/2
 */
@Slf4j
@Component
@RocketMQMessageListener(consumerGroup = RocketMQConst.GROUP_CONSUMER_PUBLIC, topic = RocketMQConst.TOPIC_PUBLIC, messageModel = MessageModel.BROADCASTING)
public class PublicRocketMQListener implements RocketMQListener<Message> {

    //用于判断是否是自己
    public static ConcurrentHashSet<String> SELF_MESSAGE_ID_SET = new ConcurrentHashSet<>(256);

    @Resource
    private MQTestEvent mqTestEvent;

    @Override
    public void onMessage(Message message) {
        String body = new String(message.getBody());
        RocketMessageEntity messageEntity = JSON.parseObject(body,
                new TypeReference<RocketMessageEntity>() {
        });
        if (SELF_MESSAGE_ID_SET.remove(messageEntity.getId())) {
            //排除自己的消息
            return;
        }
        log.info("收到消息Topic:{} Body:{}", message.getTopic(), body);
        switch (messageEntity.getType()) {
            case MQTestEvent.TYPE_TEST:
                mqTestEvent.testEvent(messageEntity.getJsonData());
                break;
        }
    }

}
