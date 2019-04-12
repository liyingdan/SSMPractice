package com.lyd.test;

import com.lyd.domain.Customer;
import com.lyd.mapper.CustomerMapper;
import com.lyd.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;

public class Mytest {
    private SqlSession sqlSession = MybatisUtil.openSession();

    @Test
    public void test(){
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);

        Customer customer = new Customer();
        customer.setCust_id(2);
        customer.setCust_name("李白");
        Customer customer1 = mapper.getCustomerById(customer);

        System.out.println(customer1);
        sqlSession.close();
    }















}
