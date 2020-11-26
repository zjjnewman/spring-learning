package com.atguigu.springboot.service;

import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定时任务注解
 */
public class ScheduleService {

    @Scheduled()
    public void hello(){
        System.out.println("hello");
    }
}
