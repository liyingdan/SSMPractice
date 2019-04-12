package com.lyd.mapper;

import com.lyd.domain.Customer;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface CustomerMapper {
    /*查询总数*/
    public Integer getAccountCustomer();

    /*根据id查询*/
    public Map<String,Object> getAccountWithId(Integer id);

    /*查询全部*/
    @MapKey("cust_id")
    public Map<Integer,Customer> getAllAccount();

    public Customer getCustomerWithId(Integer id);

    /*保存用户*/
    public void insertCustomer(Customer customer);

    /*查询所有客户*/
    public List<Customer> getAllCustomer();
}
