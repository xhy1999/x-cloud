package com.xcloud.helloworld.common.exception.sentinel;

import com.xcloud.util.result.Result;
import lombok.extern.slf4j.Slf4j;

/**
 * 出现未知异常时调用
 * @author xuehy
 * @since 2022/6/1
 */
@Slf4j
public class DefaultFallBackHandler {

    //默认方法
    public static Result defaultFallBack(Throwable e) {
        log.error("sentinel捕捉到异常");
        log.error(e.getMessage(), e);
        return Result.fail();
    }

}
