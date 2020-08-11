package com.atguigu.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

//    @Transactional
    public void addUser(String name, String email){
        userDao.insert(name, email);
        System.out.println("插入成功");
        int a = 1/0;
    }
}
