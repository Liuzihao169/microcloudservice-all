package com.kuake.springcloud;

import com.kuake.rule.MyRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author hao
 * @create 2019-06-22 ${TIM}
 */
@RibbonClient(name = "PROVIDER" ,configuration = {MyRuleConfig.class})
@EnableDiscoveryClient //开启发现服务的功能
@SpringBootApplication
public class MicroCloudServiceConsumer80Application {
    public static void main(String[] args) {
        SpringApplication.run(MicroCloudServiceConsumer80Application.class,args);
    }
}
