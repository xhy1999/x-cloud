package com.xcloud.helloworld.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xcloud.helloworld.provider.mapper.GoodsInfoMapper;
import com.xcloud.helloworld.common.pojo.entity.GoodsInfoEntity;
import com.xcloud.helloworld.provider.service.GoodsInfoService;
import org.springframework.stereotype.Service;

/**
 * @author xuehy
 * @since 2022/7/12
 */
@Service
public class GoodsInfoServiceImpl extends ServiceImpl<GoodsInfoMapper, GoodsInfoEntity> implements GoodsInfoService {


    @Override
    public GoodsInfoEntity getGoodsInfo(Integer goodsId) {
        return this.baseMapper.selectById(goodsId);
    }

}
