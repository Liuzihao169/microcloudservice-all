package com.kuake.springcloud.service.impl;

import com.kuake.springcloud.dao.DeptMapper;
import com.kuake.springcloud.entity.Dept;
import com.kuake.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hao
 * @create 2019-06-22 ${TIM}
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public Dept get(Long id) {
        return deptMapper.findById(id);
    }

    // cacheNames缓存区域的名字 里面可以存放多个k-v  key指定生成
    @Cacheable(cacheNames = "dep")
    @Override
    public List<Dept> list() {
        return deptMapper.findAll();
    }

    @Override
    public boolean add(Dept dept) {
        return deptMapper.add(dept);
    }
}
