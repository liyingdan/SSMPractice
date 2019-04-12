package com.lyd.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
//把model当中key为name存到session
@SessionAttributes("name")
public class MyController {
    @RequestMapping("ModelAndView")
    public ModelAndView ModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        //把数据写到request域中
        modelAndView.addObject("name","李应丹");
        modelAndView.setViewName("result.jsp");
        return modelAndView;
    }

    @RequestMapping("Model")
    public String Model(Model model){
        model.addAttribute("name","itlike");

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("name","李应丹");
        hashMap.put("age","20000");
        model.addAllAttributes(hashMap);
        System.out.println("我是第一个："+hashMap);
        /*-------------------------------------------------*/
        ArrayList collection = new ArrayList<>();
        collection.add("itlike1");
        collection.add("itlike2");
        collection.add(1);
        model.addAllAttributes(collection);
        System.out.println("我是第二个："+model.asMap());
        return "result.jsp";
    }


    @RequestMapping("testSession")
    public String testSession(Model model){
        //把数据存到session中
        model.addAttribute("name","lydd001");


        return "result2.jsp";
    }

}
