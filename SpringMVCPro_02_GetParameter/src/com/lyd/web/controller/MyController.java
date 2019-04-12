package com.lyd.web.controller;

import com.lyd.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
public class MyController {
    /*使用传统request对象接收参数*/
    @RequestMapping("/first")
    public String myform(HttpServletRequest request){
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        System.out.println(name);
        System.out.println(id);
        return "/second.jsp";
    }

    /*不使用request接收简单类型参数*/
    @RequestMapping("/second")
    //默认值:required = true
    public String myform2(@RequestParam(value = "id",required = false,defaultValue = "100") Integer idd, String name){
        System.out.println(idd);
        System.out.println(name);
        return "/second.jsp";
    }

    /*以javaBean对象接收参数*/
    @RequestMapping("/myform")
    public String myform3(User user){
        System.out.println(user);
        return "/second.jsp";
    }

    /*以数组接收参数*/
    @RequestMapping("/myform2")
    public String myform4(User user){
        System.out.println(user);
        return "/second.jsp";
    }

    /*以包装类接收参数*/
    @RequestMapping("/myform3")
    public String myform5(User user){
        System.out.println("jjjjjjj"+user);
        return "/second.jsp";
    }
}
