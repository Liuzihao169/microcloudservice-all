package com.kuake.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author hao
 * @create 2019-06-27 ${TIM}
 */
@SpringBootApplication
@EnableEurekaServer
public class MicroCloudServiceEureka7002 {
    public static void main(String[] args) {
        SpringApplication.run(MicroCloudServiceEureka7002.class,args);
    }
}
