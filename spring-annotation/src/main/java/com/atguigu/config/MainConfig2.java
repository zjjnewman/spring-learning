package com.atguigu.config;

import com.atguigu.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(value = "com.atguigu")
public class MainConfig2 {

    //给容器注册一个bean，类型是返回值的类型，id默认是方法名为id
    @Bean
    @Scope("SCOPE_PROTOTYPE")
    public Person person(){
        return new Person("张三", 25);
    }

}
