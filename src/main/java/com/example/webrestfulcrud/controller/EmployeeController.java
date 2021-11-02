package com.example.webrestfulcrud.controller;

import com.example.webrestfulcrud.dao.DepartmentDao;
import com.example.webrestfulcrud.dao.EmployeeDao;
import com.example.webrestfulcrud.entities.Department;
import com.example.webrestfulcrud.entities.Employee;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
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
    //springMVC自动将请求参数与入参对象的属性进行绑定
    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("deps", departments);
        return "emp/add";
    }

    //员工添加
    @PostMapping("/emp")
    public String addEmp(Employee employee){
//        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    //来到修改页面，查出当前员工并在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);

        //回到修改页面
        return "emp/add";
    }
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

}
