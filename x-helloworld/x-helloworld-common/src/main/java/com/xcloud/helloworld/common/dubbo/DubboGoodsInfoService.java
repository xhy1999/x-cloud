package com.xcloud.helloworld.common.dubbo;

import com.xcloud.helloworld.common.pojo.entity.GoodsInfoEntity;
import com.xcloud.helloworld.common.pojo.entity.UserEntity;
import org.apache.dubbo.common.constants.LoadbalanceRules;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author xuehy
 * @since 2022/7/12
 */
@DubboService(loadbalance = LoadbalanceRules.ROUND_ROBIN)
public interface DubboGoodsInfoService {

    //获取商品信息
    GoodsInfoEntity getGoodsInfo(Integer goodsId);

}
