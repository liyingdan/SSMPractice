package com.lyd.service;

import com.lyd.domain.Customer;
import com.lyd.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("CustomerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public void saveCustomer(Customer customer) {
        System.out.println("来到了业务层 保存customer:"+customer);
        /*调用dao层*/
        customerMapper.insertCustomer(customer);
    }
}
