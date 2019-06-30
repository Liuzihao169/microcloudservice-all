package com.kuake.springclod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author hao
 * @create 2019-06-29 ${TIM}
 */
@SpringBootApplication
@EnableConfigServer
public class MicrocloudServiceConfig3344 {
    public static void main(String[] args) {
        SpringApplication.run(MicrocloudServiceConfig3344.class,args);
    }
}
