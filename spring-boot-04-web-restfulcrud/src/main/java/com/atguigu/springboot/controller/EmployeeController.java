package com.atguigu.springboot.controller;

import com.atguigu.springboot.dao.EmployeeDao;
import com.atguigu.springboot.entities.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    EmployeeDao employeeDao;

    //查询所有员工返回页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",employees);

        return "emp/list";
    }
}
