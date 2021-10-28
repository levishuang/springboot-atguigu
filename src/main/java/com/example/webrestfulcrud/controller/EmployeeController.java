package com.example.webrestfulcrud.controller;

import com.example.webrestfulcrud.dao.EmployeeDao;
import com.example.webrestfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @GetMapping("/emps")
    //查询所有的员工列表
    //  Model 在 MVC 框架的角色是：有很多字段组成的数据。这些数据可以是：类，对象，字典，集合，这些数据准备在 Controller 里被操作(即增删改查)，最后在 View 呈现出来。
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps", employees);
        //查询员工的所有列表
        return "emp/list";
    }
    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(){

        return "emp/add";
    }

}
