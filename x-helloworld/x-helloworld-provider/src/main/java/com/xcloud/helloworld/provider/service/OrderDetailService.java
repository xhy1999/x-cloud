package com.xcloud.helloworld.provider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xcloud.helloworld.common.pojo.entity.OrderDetailEntity;

/**
 * @author xuehy
 * @since 2022/7/12
 */
public interface OrderDetailService extends IService<OrderDetailEntity> {

    void saveOrderDetail(OrderDetailEntity orderDetailEntity);

}
