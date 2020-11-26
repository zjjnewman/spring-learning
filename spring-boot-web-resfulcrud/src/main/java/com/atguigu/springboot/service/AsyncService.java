package com.atguigu.springboot.service;

import org.springframework.scheduling.annotation.Async;

/**
 * 开启异步请求，在方法上注解
 * 需要在启动类加注解
 *
 */

public class AsyncService {
    @Async
    public void hello(){
        System.out.println("hello");
    }



}
