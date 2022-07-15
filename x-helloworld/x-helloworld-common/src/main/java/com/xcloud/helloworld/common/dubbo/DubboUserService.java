package com.xcloud.helloworld.common.dubbo;

import com.xcloud.helloworld.common.pojo.entity.UserEntity;
import com.xcloud.util.result.Result;
import org.apache.dubbo.common.constants.LoadbalanceRules;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author xuehy
 * @since 2022/7/12
 */
@DubboService(loadbalance = LoadbalanceRules.ROUND_ROBIN)
public interface DubboUserService {

    //获取用户信息
    UserEntity getUserInfo(String userId);

    //更新用户信息
    void updateUserInfo(UserEntity userEntity);

}
