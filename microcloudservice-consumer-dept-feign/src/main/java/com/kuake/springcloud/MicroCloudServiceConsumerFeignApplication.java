package com.kuake.springcloud;

import com.kuake.springcloud.service.DeptClientServiceFallbackFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author hao
 * @create 2019-06-22 ${TIM}
 */
@EnableDiscoveryClient //开启发现服务的功能
@SpringBootApplication
@EnableFeignClients(value = {"com.kuake.springcloud.service"})
public class MicroCloudServiceConsumerFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroCloudServiceConsumerFeignApplication.class,args);
    }

    @Bean
    public DeptClientServiceFallbackFactory deptClientServiceFallbackFactory(){
        return new DeptClientServiceFallbackFactory();
    }
}
