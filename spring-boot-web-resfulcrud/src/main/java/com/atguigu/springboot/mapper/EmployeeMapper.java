package com.atguigu.springboot.mapper;

import com.atguigu.springboot.bean.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeMapper {

    @Select("select * from tbl_emp where `emp_id`=#{id}")
    public Employee getEmpById(Integer id);

    // ?&empName=张三&gender=M&email=zhangsan@qq.com&dId=1
    @Insert("insert into tbl_emp(emp_name, gender, email, d_id) values(#{empName}, #{gender}, #{email}, #{dId})")
    public int insertEmp(Employee employee);

    @Update("update tbl_emp set emp_name=#{empName}, gender=#{gender}, email=#{email}, d_id=#{dId} where emp_id=#{empId}")
    public int updateEmp(Employee employee);

    @Delete("delete from tbl_emp where emp_id = #{id}")
    public int deleteEmpById(Integer id);

    @Select("select * from tbl_emp")
    public List<Employee> getAllEmp();
}
