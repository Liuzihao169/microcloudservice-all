package com.kuake.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hao
 * @create 2019-06-29 ${TIM}
 */
@RestController
public class ConfigController {

    @Value("${server.port}")
    private String port;

    @Value("spring.profiles")
    private  String profiles;

    @Value("${eureka.client.service-url.defaultZone}")
    private String  eureka;

    @GetMapping("/config")
    public String config(){
        return "port===>"+port+"====="+"profiles=====>"+profiles+"=========>eureka"+eureka;
    }
}
