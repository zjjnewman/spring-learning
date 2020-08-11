package com.atguigu.crud.controller;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {


    @Autowired
    EmployeeService employeeService;


    @ResponseBody
    @RequestMapping("/emps")
    public Employee getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
                            Model model){

        Employee emps = employeeService.getOne();
        return emps;
    }

//    @RequestMapping("/emps")
//    @ResponseBody
//    public PageInfo getEmpsWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn){
//
//        PageHelper.startPage(pn, 5);
//
//        return new PageInfo();
//    }

}
