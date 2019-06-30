package com.kuake.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author hao
 * @create 2019-06-28 ${TIM}
 */
@EnableZuulProxy
@SpringBootApplication
public class MicroCloudServiceZuulGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroCloudServiceZuulGatewayApplication.class,args);
    }
}
