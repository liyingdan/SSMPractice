package com.lyd.test;

import com.lyd.domain.Customer;
import com.lyd.domain.QueryVo;
import com.lyd.mapper.CustomerMapper;
import com.lyd.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Mytest {
    private SqlSession sqlSession = MybatisUtil.openSession();

    @Test
    public void test(){
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> customers = mapper.getCustomer("", "");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
        sqlSession.close();
    }

    @Test
    public void test2(){
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = new Customer();
        customer.setCust_id(9);
        customer.setCust_name("百里守约");
        customer.setCust_profession("刺客");
        mapper.updateCustomer(customer);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test3(){
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        QueryVo queryVo = new QueryVo();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(9);
        queryVo.setIdList(arrayList);
        List<Customer> customers = mapper.getCustomers(queryVo);
        for (Customer customer : customers) {
            System.out.println(customer);
        }
        sqlSession.close();
    }

    @Test
    public void test4(){
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customerWithId = mapper.getCustomerWithId(12);
        System.out.println(customerWithId);
        sqlSession.close();
    }



}
