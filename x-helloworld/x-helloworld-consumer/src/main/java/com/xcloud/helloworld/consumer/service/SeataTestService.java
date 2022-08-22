package com.xcloud.helloworld.consumer.service;

import com.xcloud.util.result.Result;
import io.seata.core.exception.TransactionException;

/**
 * @author xuehy
 * @since 2022/7/12
 */
public interface SeataTestService {

    //模拟提交订单服务
    Result submitOrder() throws TransactionException;

}
