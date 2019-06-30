package com.kuake.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author hao
 * @create 2019-06-22 ${TIM}
 * 这是一个配置类
 */
@Configuration
public class ConfigBean {

    @LoadBalanced //实现负载均衡
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    //配置使用随机获得的 负载均衡算法
  /*  @Bean
    public IRule iRule(){
        return  new RandomRule();
    }*/
}
