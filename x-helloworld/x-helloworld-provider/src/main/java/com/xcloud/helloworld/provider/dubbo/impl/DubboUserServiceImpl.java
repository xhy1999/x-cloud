package com.xcloud.helloworld.provider.dubbo.impl;

import com.xcloud.helloworld.common.dubbo.DubboUserService;
import com.xcloud.helloworld.common.pojo.entity.UserEntity;
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
public class DubboUserServiceImpl implements DubboUserService {

    @Resource
    private UserService userService;

    @Override
    public UserEntity getUserInfo(String userId) {
        return userService.getUserInfo(userId);
    }

    @Override
    public void updateUserInfo(UserEntity userEntity) {
        userService.updateUserInfo(userEntity);
    }

}
