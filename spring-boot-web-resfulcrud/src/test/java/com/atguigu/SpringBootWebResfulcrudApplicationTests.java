package com.atguigu;

import com.atguigu.springboot.bean.Employee;
import com.atguigu.springboot.bean.EmployeeExample;
import com.atguigu.springboot.mapper.EmployeeMapper;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.cache.CacheManager;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import io.lettuce.core.*;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class SpringBootWebResfulcrudApplicationTests {

    @Autowired
    DataSource dataSource;
    @Autowired
    EmployeeMapper mapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Test
    void contextLoads() throws SQLException {
        Employee emp01 = mapper.getEmpById(12);
        System.out.println(emp01);
        redisTemplate.opsForValue().set("emp", emp01);
        Object emp = redisTemplate.opsForValue().get("emp");
    }


    @Test
    public void lettuceTest(){
//        RedisClient redisClient = RedisClient.create("redis://password@localhost:6379/0");
        RedisClient redisClient = RedisClient.create("redis://remotehost1:6379/0");
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> syncCommands = connection.sync();

        syncCommands.set("key", "Hello, Redis!");
        System.out.println(syncCommands.get("key"));
        syncCommands.flushall();
        connection.close();
        redisClient.shutdown();
    }


    @Test
    public void redisTest(){

        // String
        stringRedisTemplate.opsForValue().append("msg", "hello");
        System.out.println(stringRedisTemplate.opsForValue().get("msg"));

        //
    }

    @Test
    public void JSRtest(){
        new EmployeeExample();
    }


}
