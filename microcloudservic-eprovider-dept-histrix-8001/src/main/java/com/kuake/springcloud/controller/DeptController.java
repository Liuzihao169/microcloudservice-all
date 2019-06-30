package com.kuake.springcloud.controller;

import com.kuake.springcloud.entity.Dept;
import com.kuake.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hao
 * @create 2019-06-22 ${TIM}
 */
@RestController
public class DeptController {

   @Autowired
   private DiscoveryClient client;

    @Autowired
    private DeptService deptService;

    @GetMapping("/discovery/provider")
    public void getinfo(){
        List<String> services = client.getServices();
        List<ServiceInstance> instances = client.getInstances("microcloudservice-provide-rdept-8001");
        if (instances != null) {
            for (ServiceInstance instance : instances) {
                System.out.println(instance.getServiceId());
            }
        }
        List<ServiceInstance> instances2 = client.getInstances("PROVIDER");
        if (instances != null) {
            for (ServiceInstance instance : instances2) {
                System.out.println(instance.getServiceId()+"PROVIDER");
            }
        }
    }

    @GetMapping("/dept/list")
    public List<Dept> list(){
        return deptService.list();
    }

    @GetMapping("/dept/{id}")
    @HystrixCommand(fallbackMethod = "processHystrix")
    public Dept get(@PathVariable Long id){
        Dept dept = deptService.get(id);
        if (dept == null) {
          throw  new RuntimeException();
        }
        return dept;
    }

    @PostMapping("/dept")
    public boolean add(@RequestBody Dept dept){
     return  deptService.add(dept);
    }

    // 熔断服务 快速返回一个预期的 可备选的相应、
    public Dept processHystrix(@PathVariable Long id){
        return  new Dept().setDeptno(id).setDname("该ID："+id+"没有对应的信息==>null @HystrixCommand").setDb_source("NO INFO IN DATABASE");
    }
}
