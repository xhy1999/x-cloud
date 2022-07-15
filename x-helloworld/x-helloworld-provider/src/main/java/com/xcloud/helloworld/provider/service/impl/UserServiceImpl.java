package com.xcloud.helloworld.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xcloud.helloworld.provider.mapper.UserMapper;
import com.xcloud.helloworld.common.pojo.entity.UserEntity;
import com.xcloud.helloworld.provider.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

/**
 * @author xuehy
 * @since 2022/7/12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Override
    public UserEntity getUserInfo(String userId) {
        return this.baseMapper.selectById(userId);
    }

    @Override
    public void updateUserInfo(UserEntity userEntity) {
        this.baseMapper.updateById(userEntity);
    }

}
