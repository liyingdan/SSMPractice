package com.lyd.text;

import com.lyd.domain.Customer;
import com.lyd.mapper.CustomerMapper;
import com.lyd.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest2 {
    private SqlSession sqlSession = MybatisUtil.openSession();

    @Test
    public void test(){
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = mapper.queryCustomerById(1);
        System.out.println(customer);

        List<Customer> customers = mapper.queryCustomerByName("%李%");
        for (Customer customer1 : customers) {
            System.out.println(customer1);
        }

        sqlSession.close();
    }
}
