package com.kuake.springcloud.service;

import com.kuake.springcloud.entity.Dept;

import java.util.List;

/**
 * @author hao
 * @create 2019-06-22 ${TIM}
 * dept定义接口
 */

public interface DeptService {

    //根据id查询部门
    Dept get(Long id);

    //获得所有部门
    List<Dept> list();

    //添加部门
    boolean add(Dept dept);
}
