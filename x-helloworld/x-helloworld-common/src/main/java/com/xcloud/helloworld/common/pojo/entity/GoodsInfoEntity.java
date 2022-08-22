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
@TableName("goods_info")
public class GoodsInfoEntity implements Serializable {

    /**
     * 商品id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品单价
     */
    private BigDecimal unitPrice;
    /**
     * 库存数量
     */
    private Integer inventoryNum;
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