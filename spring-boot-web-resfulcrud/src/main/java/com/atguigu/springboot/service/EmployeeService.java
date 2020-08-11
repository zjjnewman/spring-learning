package com.atguigu.springboot.service;

import com.atguigu.springboot.bean.Employee;
import com.atguigu.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "emp")
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Cacheable(
//            cacheNames = "emp",
            key = "#id",
//            key = "root.methodName + '[' + #id + ']'",
//            keyGenerator = "myGenerator",
            condition = "#id > 1", unless = "#result == null"
    )
    public Employee getEmpById(Integer id){
        return employeeMapper.getEmpById(id);
    }


    @CachePut(
//            cacheNames = "emp",
//            keyGenerator = "myGenerator"
            key = "#employee.empId"
    )
    public Employee updateEmp(Employee employee){
        employeeMapper.updateEmp(employee);
        return employee;
    }

    public int addEmp(Employee employee){
        System.out.println(employee);
        return employeeMapper.insertEmp(employee);
    }

    @CacheEvict(
//            cacheNames = "emp",
            key = "#id",
            beforeInvocation = true
    )
    public int deleteEmpById(Integer id){
        System.out.println(id);
        return employeeMapper.deleteEmpById(id);
    }

    public List<Employee> getAllEmp(){
        return employeeMapper.getAllEmp();
    }

}
