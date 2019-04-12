package com.lyd.test;

import com.lyd.domain.Customer;
import com.lyd.domain.Order;
import com.lyd.mapper.CustomerMapper;
import com.lyd.mapper.OrderMapper;
import com.lyd.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class Mytest {
    private SqlSession sqlSession = MybatisUtil.openSession();

    @Test
    public void test(){
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);

        /*Integer accountCustomer = mapper.getAccountCustomer();
        System.out.println(accountCustomer);*/

        /*Map<String, Object> customer = mapper.getAccountWithId(2);
        System.out.println(customer);*/

        Map<Integer, Customer> allAccount = mapper.getAllAccount();
        System.out.println(allAccount);

        sqlSession.close();
    }

    @Test
    public void test2(){
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> allOrders = mapper.getAllOrders();
        for (Order order : allOrders) {
            System.out.println(order);
        }
        sqlSession.close();
    }

    @Test
    /*分布查询*/
    public void test3(){
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        Order order = mapper.getOrderWithId(2);
        System.out.println(order);
        sqlSession.close();
    }

    @Test
    public void test4(){
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);

        Customer customer = new Customer();
        customer.setCust_name("孙悟空");
        customer.setCust_phone("158715145444");
        customer.setEmail("1384@163.com");
        customer.setCust_profession("打野");

        Order order = new Order();
        order.setOrder_name("新订单001");
        order.setOrder_num("2000001");
        order.setCustomer(customer);

        /*先添加客户 获取客户生成的id  再去添加订单*/
        customerMapper.insertCustomer(customer);
//        System.out.println(customer);
        /*保存订单*/
        orderMapper.insertOrder(order);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    /*一对多左连接查询*/
    public void test5(){
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> allCustomer = customerMapper.getAllCustomer();
        for (Customer customer : allCustomer) {
            System.out.println(customer);
        }
        sqlSession.close();
    }

    @Test
    public void test6(){
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        /*创建新客户*/
        Customer customer = new Customer();
        customer.setCust_name("伽罗");
        customer.setCust_phone("12664444");
        /*创建订单*/
        Order order1 = new Order();
        order1.setOrder_name("新订单1");
        Order order2 = new Order();
        order2.setOrder_name("新订单2");
        /*设置关系*/
        customer.getOrders().add(order1);
        customer.getOrders().add(order2);
        /*添加客户和订单*/
        customerMapper.insertCustomer(customer);
        orderMapper.insertOrder(order1);
        orderMapper.insertOrder(order2);
        /*更新关系*/
        for (Order order : customer.getOrders()) {
            orderMapper.updateOrderId(customer.getCust_id(),order.getOrder_id());
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
