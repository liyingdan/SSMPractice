package com.lyd.mapper;

import com.lyd.domain.Customer;
import com.lyd.domain.QueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {
    /*根据客户名称和职业来查询*/
    public List<Customer> getCustomer(@Param("name") String name, @Param("profession") String profession);

    /*更新客户*/
    public void updateCustomer(Customer customer);

    /*根据id查询指定的客户 多个客户*/
    public List<Customer> getCustomers(QueryVo vo);

    public Customer getCustomerWithId(@Param("id") Integer id);

}
