package com.kuake.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author hao
 * @create 2019-06-22 ${TIM}
 */
@EnableEurekaClient //开启服务注册功能
@EnableCaching //开启缓存
@MapperScan(value = "com.kuake.springcloud.dao")
@SpringBootApplication
public class MicroCloudServiceProvideApplication8002 {
    public static void main(String[] args) {
        SpringApplication.run(MicroCloudServiceProvideApplication8002.class, args);
    }
}
