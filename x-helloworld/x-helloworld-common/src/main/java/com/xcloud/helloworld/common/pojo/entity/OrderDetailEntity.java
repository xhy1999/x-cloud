package com.xcloud.helloworld.common.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("order_detail")
public class OrderDetailEntity {

    /**
     * 编号
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 商品编号
     */
    private Integer goodsId;
    /**
     * 商品数量
     */
    private Integer goodsNum;
    /**
     * 商品单价
     */
    private BigDecimal unitPrice;
    /**
     * 商品总价
     */
    private BigDecimal totalPrice;
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