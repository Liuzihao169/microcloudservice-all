package com.kuake.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author hao
 * @create 2019-06-28 ${TIM}
 */
@EnableHystrixDashboard
@SpringBootApplication
public class MicroCloudServiceConsumerHystrixdashboradApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroCloudServiceConsumerHystrixdashboradApplication.class,args);
    }
}
