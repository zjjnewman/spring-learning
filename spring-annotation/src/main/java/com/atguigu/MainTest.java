package com.atguigu;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    public static void main(String[] args) {
        // 配置文件方式
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);

        // 配置类方式
        AnnotationConfigApplicationContext applicationContext1 = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = applicationContext1.getBean(Person.class);
        System.out.println(bean);

        String[] beanNamesForType = applicationContext1.getBeanNamesForType(Person.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
    }
}
