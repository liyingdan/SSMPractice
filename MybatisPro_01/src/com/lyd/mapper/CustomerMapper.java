package com.lyd.mapper;

import com.lyd.domain.Customer;

import java.util.List;

public interface CustomerMapper {
    /*根据cust_id查询客户*/
    public Customer queryCustomerById(Integer id);

    /*查询所有*/
    public List<Customer> queryAllCustomers();

    /*根据用户名迷糊查询客户*/
    public List<Customer> queryCustomerByName(String name);

    /*添加*/
    public void insertCustomer(Customer customer);

    /*根据id更新用户名*/
    public void updateCustomerById(Customer customer);

    /*删除客户*/
    public void deleteCustomer(Customer customer);
}
