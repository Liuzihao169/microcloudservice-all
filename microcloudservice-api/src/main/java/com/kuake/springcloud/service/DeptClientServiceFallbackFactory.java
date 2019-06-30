package com.kuake.springcloud.service;

import com.kuake.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author hao
 * @create 2019-06-28 ${TIM}
 */
//添加到容器当中
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public Dept get(Long id) {
                return new Dept().setDeptno(id).setDname("没有信息，占时停止服务").setDb_source("NO INTO IN DATABASE");
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}
