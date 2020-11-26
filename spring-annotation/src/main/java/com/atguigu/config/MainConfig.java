package com.atguigu.config;

import com.atguigu.bean.Dog;
import com.atguigu.bean.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework. stereotype.Controller;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan(value = "com.atguigu.bean")
public class MainConfig {

    //给容器注册一个bean，类型是返回值的类型，id默认是方法名为id
    @Bean
    @Primary
    public Person person(){
        return new Person("lisi", 20);
    }

//    @Bean
//    public Dog dog(){
//        return new Dog();
//    }
}
