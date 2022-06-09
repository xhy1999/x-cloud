package com.xcloud.helloworld.provider.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.xcloud.helloworld.provider.service.SentinelTestService;
import com.xcloud.util.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author xuehy
 * @since 2022/6/9
 */
@Slf4j
@Service
public class SentinelTestServiceImpl implements SentinelTestService {

    @Override
    public Result blockTest() {
        //模拟一个耗时操作
        try {
            Thread.sleep(RandomUtil.randomInt(1000, 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Result.success();
    }

}
