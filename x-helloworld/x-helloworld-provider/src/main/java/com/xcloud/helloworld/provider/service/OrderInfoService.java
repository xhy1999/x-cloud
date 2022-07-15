package com.xcloud.helloworld.provider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xcloud.helloworld.common.pojo.entity.OrderInfoEntity;

/**
 * @author xuehy
 * @since 2022/7/12
 */
public interface OrderInfoService extends IService<OrderInfoEntity> {

    void saveOrderInfo(OrderInfoEntity orderInfoEntity);

}
