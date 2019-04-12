package com.lyd.springMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    //匹配请求可以省去action
    @RequestMapping("/first.action")
    public ModelAndView show(){

        ModelAndView modelAndView = new ModelAndView();
        //请求过来后，跳转到另一个界面   往别一个界面当中传一些数据
        modelAndView.addObject("name","lyddd");
        //modelAndView.setViewName("lll");
        modelAndView.setViewName("/result.jsp");
        return modelAndView;
    }


    @RequestMapping("/second.action")
    public String show2(){

        //重定向
        return "redirect:/result.jsp";
    }


}
