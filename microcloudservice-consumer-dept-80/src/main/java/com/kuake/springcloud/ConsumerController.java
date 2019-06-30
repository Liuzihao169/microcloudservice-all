package com.kuake.springcloud;

import com.kuake.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author hao
 * @create 2019-06-22 ${TIM}
 */
@RestController
public class ConsumerController {

    private  static  final String REST_URL_PREFIX = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/dept/list")
    public List<Dept> list(){
        /* return restTemplate.getForObject("http://localhost:8001/dept/list",List.class); */
        return restTemplate.getForObject("http://PROVIDER/dept/list",List.class);
    }

    @GetMapping("/consumer/dept/{id}")
    public Dept get(@PathVariable  Long id){
        return restTemplate.getForObject("http://PROVIDER/dept/"+id,Dept.class);
    }

    @RequestMapping("/consumer/dept")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept",dept,Boolean.class);
    }
}
