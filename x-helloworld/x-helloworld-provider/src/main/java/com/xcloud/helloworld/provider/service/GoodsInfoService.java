package com.xcloud.helloworld.provider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xcloud.helloworld.common.pojo.entity.GoodsInfoEntity;

/**
 * @author xuehy
 * @since 2022/7/12
 */
public interface GoodsInfoService extends IService<GoodsInfoEntity> {

    GoodsInfoEntity getGoodsInfo(Integer goodsId);

}
