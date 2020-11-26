package com.atguigu.crud.test;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.dao.DepartmentMapper;
import com.atguigu.crud.dao.EmployeeMapper;
import com.atguigu.crud.service.EmployeeService;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import java.util.UUID;
@SpringJUnitWebConfig(locations = {"classpath:applicationContext.xml"})
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    SqlSession sqlSession;
    @Autowired
    EmployeeService employeeService;


    @Test
    public void testQueryOne(){
        Employee one = employeeService.getOne();
        System.out.println(one);
    }


    @Test
    public void testCRUD(){
        System.out.println(departmentMapper);
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        DepartmentMapper bean = applicationContext.getBean(DepartmentMapper.class);
//        System.out.println(bean);
//        Employee employee = new Employee(null, "李四", "M", "lisi@qq.com", 1);
//        employeeMapper.insertSelective(employee);

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        for (int i = 0; i < 100; i++) {
            String uid = UUID.randomUUID().toString().substring(0, 5);
            mapper.insertSelective(new Employee(null, uid, "M", uid + "@qq.com", 1));
        }
    }
}
