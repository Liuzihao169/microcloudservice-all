package com.kuake.springcloud.controller;

import com.kuake.springcloud.entity.Dept;
import com.kuake.springcloud.service.DeptService;
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
    public Dept get(@PathVariable Long id){
       return deptService.get(id);
    }

    @PostMapping("/dept")
    public boolean add(@RequestBody Dept dept){
     return  deptService.add(dept);
    }
}
