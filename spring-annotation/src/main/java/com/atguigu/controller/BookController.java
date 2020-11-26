package com.atguigu.controller;

import com.atguigu.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class BookController {

    @Autowired(required = false)
    @Qualifier("person")
    Person person;




}
