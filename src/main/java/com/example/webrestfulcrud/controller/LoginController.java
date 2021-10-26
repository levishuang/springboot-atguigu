package com.example.webrestfulcrud.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @PostMapping("/usr/login")
//    @RequestMapping(value = "/usr/login", method = RequestMethod.POST)
    public String login(String usename, String password){
        return "dashboard";
    }

}
