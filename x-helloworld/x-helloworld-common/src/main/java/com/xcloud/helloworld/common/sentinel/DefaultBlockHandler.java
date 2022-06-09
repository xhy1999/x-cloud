package com.xcloud.helloworld.common.sentinel;

import com.xcloud.util.result.Result;
import lombok.extern.slf4j.Slf4j;

/**
 * 限流/降级/系统保护时调用
 * @author xuehy
 * @since 2022/6/9
 */
@Slf4j
public class DefaultBlockHandler {

    //默认方法
    public static Result defaultSentinelBlock() {
        return Result.busy();
    }

}
