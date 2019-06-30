package com.kuake.springcloud.service;

import com.kuake.springcloud.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author hao
 * @create 2019-06-28 ${TIM}
 */
@FeignClient(value = "PROVIDER" ,fallbackFactory=DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @GetMapping("/dept/list")
    List<Dept> list();

    @GetMapping("/dept/{id}")
    Dept get(@PathVariable(value = "id") Long id);

    @PostMapping("/dept")
    boolean add(@RequestBody Dept dept);

}
