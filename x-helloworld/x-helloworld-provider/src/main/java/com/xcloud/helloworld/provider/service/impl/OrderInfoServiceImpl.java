package com.xcloud.helloworld.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xcloud.helloworld.provider.mapper.OrderInfoMapper;
import com.xcloud.helloworld.common.pojo.entity.OrderInfoEntity;
import com.xcloud.helloworld.provider.service.OrderInfoService;
import org.springframework.stereotype.Service;

/**
 * @author xuehy
 * @since 2022/7/12
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfoEntity> implements OrderInfoService {


    @Override
    public void saveOrderInfo(OrderInfoEntity orderInfoEntity) {
        this.baseMapper.insert(orderInfoEntity);
    }

}
