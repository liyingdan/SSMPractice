package com.lyd.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;

@Controller
public class Controller_upload {
    /*{filename:.+}：把扩展名也显示出来*/
    @RequestMapping("/download/{filename:.+}")
    public ResponseEntity download(@PathVariable String filename, HttpSession session) throws Exception {
        System.out.println(filename);
        //1.获取文件路径
        String realPath = session.getServletContext().getRealPath("/download/" + filename);
        //2.把文件读取程序当中
        FileInputStream io = new FileInputStream(realPath);
        byte[] body = new byte[io.available()];
        io.read(body);
        //3.创建响应头
        HttpHeaders httpHeaders = new HttpHeaders();
        filename = URLEncoder.encode(filename,"UTF-8");
        //告诉浏览器以附件形式下载文件
        httpHeaders.add("Content-Disposition","attachment;filename="+filename);
        //设置响应码：HttpStatus.OK
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(body, httpHeaders, HttpStatus.OK);

        return responseEntity;
    }


    @RequestMapping("/upload")
    public String upload(@RequestParam("file")CommonsMultipartFile file,HttpSession session) throws IOException {
        System.out.println(file.getContentType());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        System.out.println(file.getName());

        //确定上传路径
        String realPath = session.getServletContext().getRealPath("/upload");
        //变成程序中的路径
        File uploadPath = new File(realPath);
        if(!uploadPath.exists()){//如果路径不存在，创建一个新的
            uploadPath.mkdirs();
        }
        //确认最终的路径 /文件夹/文件名  工程的名称/uploas/java.jpg
        String filename = file.getOriginalFilename();
        uploadPath = new File(uploadPath+"/"+filename);

        //开始上传
        file.transferTo(uploadPath);

        return "success";
    }



    @RequestMapping("/local")
    public String local(){
        return "local";
    }
}
