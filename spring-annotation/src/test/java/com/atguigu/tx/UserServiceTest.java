package com.atguigu.tx;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void addUser() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService bean = applicationContext.getBean(UserService.class);
        bean.addUser("李四", "lisi@qq.com");
    }
}