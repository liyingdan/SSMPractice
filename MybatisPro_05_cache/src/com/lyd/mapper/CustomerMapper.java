package com.lyd.mapper;

import com.lyd.domain.Customer;
import java.util.List;

public interface CustomerMapper {
    int deleteByPrimaryKey(Integer custId);

    int insert(Customer record);

    Customer selectByPrimaryKey(Integer custId);

    List<Customer> selectAll();

    int updateByPrimaryKey(Customer record);
}