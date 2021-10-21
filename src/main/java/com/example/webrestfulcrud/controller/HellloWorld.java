package com.example.webrestfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

//使用@Controller 注解，在对应的方法上，视图解析器可以解析return 的jsp,html页面，并且跳转到相应页面
@Controller
//@RestController无法解析jsp,html页面
//@RestController
public class HellloWorld {
    @RequestMapping("/hello")
    public String helloWorld(){
        return "hello world";
    }
    @RequestMapping("/success")
    public String success(Map<String, Object> map){
        map.put("hello", "你好");
        map.put("users", Arrays.asList("zhangsan", "lisi", "wangwu"));
        return "success";
    }
//    @RequestMapping("/demo")
//    public String demo(){
//        return "index";
//    }



}
