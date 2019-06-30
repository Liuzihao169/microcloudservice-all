package com.kuake.springcloud;

import com.kuake.springcloud.entity.Dept;
import com.kuake.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hao
 * @create 2019-06-22 ${TIM}
 */
@RestController
public class ConsumerController {

    @Autowired
    private  DeptClientService deptClientService;

    @GetMapping("/consumer/dept/list")
    public List<Dept> list(){
        return deptClientService.list();
        /* return restTemplate.getForObject("http://localhost:8001/dept/list",List.class); */
       /* return restTemplate.getForObject("http://PROVIDER/dept/list",List.class);*/
    }

    @GetMapping("/consumer/dept/{id}")
    public Dept get(@PathVariable  Long id){
        return deptClientService.get(id);
      /*  return restTemplate.getForObject("http://PROVIDER/dept/"+id,Dept.class);*/
    }

    @RequestMapping("/consumer/dept")
    public boolean add(Dept dept){
        return deptClientService.add(dept);
       /* return restTemplate.postForObject(REST_URL_PREFIX+"/dept",dept,Boolean.class);*/
    }
}
