package com.lyd.mapper;

import com.lyd.domain.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface CustomerMapper {
    public Customer getCustomerById(@Param("myid") Integer id, @Param("myname") String name);

    public Customer getCustomerById(Map<String,Object> map);

    public Customer getCustomerById(Customer customer);


}
