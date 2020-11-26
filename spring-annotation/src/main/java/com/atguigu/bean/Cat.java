package com.atguigu.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;



@Component

public class Cat implements InitializingBean, DisposableBean {

//    @Bean(initMethod = "init2", destroyMethod = "destroy2")


    @PostConstruct
    private void init2(){
        System.out.println("bean注解指定initialization 构造器之后，属性赋值完成，调用初始化");
    }

    @PreDestroy
    public void destroy2(){
        System.out.println("bean注解指定destroyMethod 移除之后调用");
    }

    @PostConstruct
    private void init1(){
        System.out.println("PostConstruct 构造器之后，属性赋值完成，调用初始化");
    }

    @PreDestroy
    public void destroy1(){
        System.out.println("PreDestroy 移除之后调用");
    }



    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(" 继承InitializingBean接口实现afterPropertiesSet 构造器之后，属性赋值完成，调用初始化");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("继承DisposableBean接口实现destroy 移除之后调用");
    }
}
