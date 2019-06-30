package com.kuake.springcloud.dao;

import com.kuake.springcloud.entity.Dept;

import java.util.List;

/**
 * @author hao
 * @create 2019-06-22 ${TIM}
 */
public interface DeptMapper {

    boolean add(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();
}
