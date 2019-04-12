package com.lyd.web.controller;

import com.lyd.domain.Pet;
import com.lyd.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {
    @RequestMapping("update/{id}")
    public String update(@PathVariable Integer id, Model model){
        /*全部爱好*/
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add("篮球");
        arrayList.add("足球");
        arrayList.add("乒乓球");
        model.addAttribute("allhobby",arrayList);
        /*全部宠物*/
        ArrayList<Object> petList = new ArrayList<>();
        Pet pet1 = new Pet();
        pet1.setId(1);
        pet1.setName("狗");

        Pet pet2 = new Pet();
        pet2.setId(2);
        pet2.setName("猫咪");

        Pet pet3 = new Pet();
        pet3.setId(3);
        pet3.setName("老虎");

        petList.add(pet1);
        petList.add(pet2);
        petList.add(pet3);
        model.addAttribute("petList",petList);

        User user = new User();
        user.setUsername("李应丹");
        user.setAge(18);
        user.setGender(1);
        String[] hobby = new String[]{"篮球","足球"};
        user.setHobby(hobby);
        user.setPet(pet1);
        model.addAttribute("user",user);

        return "/result.jsp";
    }

    @RequestMapping("update2")
    public String update2(@Valid User user, BindingResult result,Model model){
        System.out.println(user);
        //判断有没有错误信息
        if(result.getErrorCount() != 0){
            //获取验证错误字段及错误信息
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                System.out.println(fieldError.getField()+":"+fieldError.getDefaultMessage());
            }
            /*全部爱好*/
            ArrayList<Object> arrayList = new ArrayList<>();
            arrayList.add("篮球");
            arrayList.add("足球");
            arrayList.add("乒乓球");
            model.addAttribute("allhobby",arrayList);
            /*全部宠物*/
            ArrayList<Object> petList = new ArrayList<>();
            Pet pet1 = new Pet();
            pet1.setId(1);
            pet1.setName("狗");

            Pet pet2 = new Pet();
            pet2.setId(2);
            pet2.setName("猫咪");

            Pet pet3 = new Pet();
            pet3.setId(3);
            pet3.setName("老虎");

            petList.add(pet1);
            petList.add(pet2);
            petList.add(pet3);
            model.addAttribute("petList",petList);

            //回到原来的页面
            return "result.jsp";
        }


        return "/result2.jsp";
    }


    @RequestMapping("getJson")
    //把返回的数据解析成Json
    @ResponseBody
    public User getJson(){
        User user = new User();
        user.setUsername("李应丹");
        user.setAge(18);
        return user;
    }

    @RequestMapping("formJson")
    //把返回的数据解析成Json
    @ResponseBody
    public String formJson(User user){
        System.out.println(user);
        return "success";
    }






}
