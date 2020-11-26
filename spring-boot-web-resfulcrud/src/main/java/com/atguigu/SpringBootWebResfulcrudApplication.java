package com.atguigu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Collection;
import java.util.Collections;

/**
 * @EnableCaching 开启缓存
 * @@CacheEvict 缓存清除
 */
@MapperScan(value = "com.atguigu.springboot.mapper")
@SpringBootApplication
@EnableCaching
public class SpringBootWebResfulcrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebResfulcrudApplication.class, args);
    }

}
