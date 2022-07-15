package com.xcloud.helloworld.provider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xcloud.helloworld.common.pojo.entity.UserEntity;

/**
 * @author xuehy
 * @since 2022/7/12
 */
public interface UserService extends IService<UserEntity> {

    UserEntity getUserInfo(String userId);

    void updateUserInfo(UserEntity userEntity);

}
