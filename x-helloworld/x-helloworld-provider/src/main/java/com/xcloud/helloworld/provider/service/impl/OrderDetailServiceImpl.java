package com.xcloud.helloworld.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xcloud.helloworld.common.pojo.entity.*;
import com.xcloud.helloworld.provider.mapper.OrderDetailMapper;
import com.xcloud.helloworld.provider.service.OrderDetailService;
import org.springframework.stereotype.Service;

/**
 * @author xuehy
 * @since 2022/7/12
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetailEntity> implements OrderDetailService {


    @Override
    public void saveOrderDetail(OrderDetailEntity orderDetailEntity) {
        this.baseMapper.insert(orderDetailEntity);
    }

}
