package com.kuake.springcloud;

import com.kuake.springcloud.dao.DeptMapper;
import com.kuake.springcloud.entity.Dept;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * @author hao
 * @create 2019-06-22 ${TIM}
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MicroCloudServiceProvideApplicationTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    DeptMapper deptMapper;

    @Test
    public void test() throws SQLException {
        System.out.println(dataSource.getClass());
        System.out.println(dataSource);
        System.out.println(dataSource.getConnection());
        System.out.println(deptMapper);
        Dept byId = deptMapper.findById(1l);
        System.out.println(byId);
        List<Dept> all = deptMapper.findAll();
        System.out.println(all);
        deptMapper.add(new Dept().setDname("牛逼部"));
    }
}
