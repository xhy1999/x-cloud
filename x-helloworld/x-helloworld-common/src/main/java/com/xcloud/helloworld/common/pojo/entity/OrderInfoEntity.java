package com.xcloud.helloworld.common.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("order_info")
public class OrderInfoEntity implements Serializable {

    /**
     * 订单编号
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 总价
     */
    private BigDecimal totalPrice;
    /**
     * 订单状态 0.创建完成 1.付款完成 2.取消订单(未付款) 3.取消订单(已付款) 4.退款成功 5.退款失败 6.已取消 7.已完成
     */
    private Integer status;
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