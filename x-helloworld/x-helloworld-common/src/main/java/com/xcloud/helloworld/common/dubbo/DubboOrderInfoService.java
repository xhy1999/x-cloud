package com.xcloud.helloworld.common.dubbo;

import com.xcloud.helloworld.common.pojo.entity.OrderDetailEntity;
import com.xcloud.helloworld.common.pojo.entity.OrderInfoEntity;
import org.apache.dubbo.common.constants.LoadbalanceRules;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author xuehy
 * @since 2022/7/12
 */
@DubboService(loadbalance = LoadbalanceRules.ROUND_ROBIN)
public interface DubboOrderInfoService {

    //保存订单
    void saveOrderInfo(OrderInfoEntity orderInfoEntity);

}
