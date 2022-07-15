package com.xcloud.helloworld.provider.dubbo.impl;

import com.xcloud.helloworld.common.dubbo.DubboGoodsInfoService;
import com.xcloud.helloworld.common.dubbo.DubboUserService;
import com.xcloud.helloworld.common.pojo.entity.GoodsInfoEntity;
import com.xcloud.helloworld.common.pojo.entity.UserEntity;
import com.xcloud.helloworld.provider.service.GoodsInfoService;
import com.xcloud.helloworld.provider.service.UserService;
import org.apache.dubbo.common.constants.LoadbalanceRules;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * 对外暴露的接口(轮询)
 * @author xuehy
 * @since 2022/6/1
 */
@DubboService(loadbalance = LoadbalanceRules.ROUND_ROBIN)
public class DubboGoodsInfoServiceImpl implements DubboGoodsInfoService {

    @Resource
    private GoodsInfoService goodsInfoService;

    @Override
    public GoodsInfoEntity getGoodsInfo(Integer goodsId) {
        return goodsInfoService.getGoodsInfo(goodsId);
    }
}
