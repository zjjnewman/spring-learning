package com.atguigu.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insert(String name, String email){


        String sql = "insert into customers(name, email) values (?,?)";
        int res = jdbcTemplate.update(sql, name, email);
        return res;
    }
}
