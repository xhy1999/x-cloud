package com.xcloud.helloworld.provider.config;

import com.alibaba.csp.sentinel.init.InitFunc;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Sentinel规则
 * @author xuehy
 * @since 2022/5/31
 */
@Slf4j
@Configuration
public class SentinelRuleConfig implements InitFunc {

    @Override
    @Bean
    public void init() {
        log.info("开始加载Sentinel规则...");
        loadFlowRule();
        log.info("Sentinel规则加载完成");
    }

    //TODO 这里需要根据实际情况配置
    private static void loadFlowRule() {
        List<FlowRule> flowRules = new ArrayList<>();
        List<DegradeRule> degradeRules = new ArrayList<>();
        FlowRule flowRule = new FlowRule();
        DegradeRule degradeRule = new DegradeRule();

        //限流规则
        FlowRuleManager.loadRules(flowRules);
        //熔断规则
        DegradeRuleManager.loadRules(degradeRules);
        //系统保护规则
        //SystemRuleManager.loadRules();
    }

}
