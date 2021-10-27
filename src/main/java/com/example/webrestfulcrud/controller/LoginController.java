package com.example.webrestfulcrud.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @PostMapping("/user/login")
//    @RequestMapping(value = "/usr/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String, Object> map, HttpSession session){
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
//            return "dashboard";
            session.setAttribute("loginuser", username);
//            对页面进行重定向操作
            return "redirect:/main.html";
        }else {
            map.put("msg", "用户名错误");
            return "index";
        }
    }

}
