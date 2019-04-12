package com.lyd.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MyController2 {
    @RequestMapping("convert")
    public ModelAndView testconvert(Integer age, Date date, String name){
        System.out.println("年龄："+age);
        System.out.println(new SimpleDateFormat("yyyy-mm-dd").format(date));
        System.out.println(name);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/second.jsp");
        return modelAndView;
    }
}
