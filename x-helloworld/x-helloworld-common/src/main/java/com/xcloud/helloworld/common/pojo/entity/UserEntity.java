package com.xcloud.helloworld.common.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("user")
public class UserEntity {

    /**
     * 用户id
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 手机号
     */
    private String mobilePhone;
    /**
     * 余额
     */
    private BigDecimal balance;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 是否删除: 0.未删除 1.已删除
     */
    @TableLogic
    private String isDel;

}