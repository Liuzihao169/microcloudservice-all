package com.kuake.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author hao
 * @create 2019-06-23 ${TIM}
 */
@EnableEurekaServer     //启动EurekaServer服务
@SpringBootApplication
public class MicroCloudServiceEureka7001 {
    public static void main(String[] args) {
        SpringApplication.run(MicroCloudServiceEureka7001.class,args);
    }
}
