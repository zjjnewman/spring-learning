package com.atguigu.springboot.controller;

import com.atguigu.springboot.bean.Employee;
import com.atguigu.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    @ResponseBody
    public Employee getEmpById(@PathVariable(value = "id") Integer id){

        Employee one = employeeService.getEmpById(id);
        if(one != null){

        }
        System.out.println(one.getdId());
        return one;
    }

    @PutMapping("/emp")
    @ResponseBody
    public Employee updateEmp(Employee employee){
        return employeeService.updateEmp(employee);
    }

    //?&empName=王五&gender=M&email=zhangsan@qq.com&dId=1
    @PostMapping("/emp")
    @ResponseBody
    public int addEmp(Employee employee){
        return employeeService.addEmp(employee);
    }

    @DeleteMapping("/emp/{id}")
    @ResponseBody
    public int deleteEmpById(@PathVariable(value = "id") Integer id){
        return employeeService.deleteEmpById(id);
    }

    @GetMapping("/empAll")
    @ResponseBody
    public List<Employee> getAllEmp(){
        return employeeService.getAllEmp();
    }
}
