package com.xcloud.helloworld.provider.mq;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSONObject;
import com.xcloud.helloworld.provider.constant.RocketMQConst;
import com.xcloud.helloworld.provider.mq.listener.PublicRocketMQListener;
import com.xcloud.helloworld.provider.pojo.RocketMessageEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

/**
 * @author xuehy
 * @since 2022/6/2
 */
@Slf4j
@Component
public class RocketMQUtil {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    //默认回调
    private SendCallback defaultCallback = new SendCallback() {
        @Override
        public void onSuccess(SendResult sendResult) {
            log.info("消息:{}回调成功", sendResult.getMsgId());
        }
        @Override
        public void onException(Throwable e) {
            log.error("消息回调异常:");
            e.printStackTrace();
        }
    };

    //发送广播消息
    public void sendPublicMessage(String type, Object data) {
        this.sendPublicMessage(type, data, defaultCallback);
    }

    public void sendPublicMessage(String type, Object data, SendCallback sendCallback) {
        RocketMessageEntity messageEntity = new RocketMessageEntity();
        messageEntity.setId(IdUtil.simpleUUID());
        messageEntity.setSource(RocketMQConst.TOPIC_PALM_SERVICE);
        messageEntity.setType(type);
        if (data instanceof String) {
            messageEntity.setJsonData((String) data);
        } else {
            messageEntity.setJsonData(JSONObject.toJSONString(data));
        }
        PublicRocketMQListener.SELF_MESSAGE_ID_SET.add(messageEntity.getId());
        //异步,按顺序发送消息
        rocketMQTemplate.asyncSendOrderly(RocketMQConst.TOPIC_PUBLIC, JSONObject.toJSONString(messageEntity).getBytes(StandardCharsets.UTF_8), RocketMQConst.HASH_KEY_PUBLIC, sendCallback);
    }

}
