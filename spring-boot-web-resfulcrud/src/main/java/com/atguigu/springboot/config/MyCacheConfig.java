package com.atguigu.springboot.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 个人缓存key生成器配置
 */

@Configuration
public class MyCacheConfig {

    @Bean("myGenerator")
    public KeyGenerator keyGenerator(){
        return new KeyGenerator(){
            @Override
            public Object generate(Object target, Method method, Object... params) {
                Object keyName = method.getName() + Arrays.asList(params).toString();
                System.out.println("keyName:-----" + keyName.toString());
                return keyName;
            }
        };
    }
}
