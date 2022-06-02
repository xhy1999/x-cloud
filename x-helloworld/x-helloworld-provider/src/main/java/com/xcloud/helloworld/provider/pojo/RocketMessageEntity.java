package com.xcloud.helloworld.provider.pojo;

import lombok.Data;

/**
 * Redis 消息实体类
 * @author xuehy
 * @since 2022/6/2
 */
@Data
public class RocketMessageEntity {

    //用于判断是否是自己
    private String id;

    //消息源模块名称
    private String source;

    //消息类型
    private String type;

    //消息参数(json格式的字符串)
    private String jsonData;

}
