package com.atguigu.config;

import com.atguigu.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework. stereotype.Controller;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan(value = "com.atguigu.bean")
public class MainConfig {

    //给容器注册一个bean，类型是返回值的类型，id默认是方法名为id
    @Bean
    public Person person(){
        return new Person("lisi", 20);
    }
}
