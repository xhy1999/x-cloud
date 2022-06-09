package com.xcloud.helloworld.common.sentinel;

import com.xcloud.util.result.Result;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xuehy
 * @since 2022/6/9
 */
@Slf4j
public class SentinelTestFallBackHandler {

    public static Result blockTest(Throwable e) {
        return DefaultFallBackHandler.defaultFallBack(e);
    }

}
