package com.lyd.web;

import com.lyd.domain.Customer;
import com.lyd.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
    /*注入业务层*/
    @Autowired
    private CustomerService customerService;

    @RequestMapping("addCustomer")
    public String addCustomer(Customer customer){
        /*接收参数*/
        System.out.println(customer);

        /*调用业务层 保存到数据库中*/
        customerService.saveCustomer(customer);

        return "result";
    }
}
