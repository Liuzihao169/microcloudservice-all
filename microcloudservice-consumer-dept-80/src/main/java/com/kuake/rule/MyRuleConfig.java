package com.kuake.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hao
 * @create 2019-06-27 ${TIM}
 */
@Configuration
public class MyRuleConfig {

    //配置使用随机获得的 负载均衡算法
    @Bean
    public IRule iRule(){
        return  new MyRule();
    }
}
