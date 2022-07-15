package com.xcloud.helloworld.consumer.api;

import com.xcloud.helloworld.consumer.service.SeataTestService;
import com.xcloud.util.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xuehy
 * @since 2022/6/2
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/seata")
public class SeataApi {

    @Resource
    private SeataTestService seataTestService;

    @PostMapping("/submitOrder")
    public Result submitOrder() {
        return seataTestService.submitOrder();
    }

}
