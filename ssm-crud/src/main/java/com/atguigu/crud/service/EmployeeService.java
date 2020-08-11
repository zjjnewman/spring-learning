package com.atguigu.crud.service;

import com.atguigu.crud.bean.Department;
import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    Department department;

    @Autowired
    EmployeeMapper employeeMapper;

    public Employee getOne() {
        return (Employee) employeeMapper.selectByPrimaryKey(12);
    }
}
