package com.atguigu;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    static public final int a;
    static {
        a = 1;
    }

    public void t1(){
        final int b = 0;
        System.out.println(b);
    }

    public static void main(String[] args) {
        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();
        System.out.println(myClass1.i);
        System.out.println(myClass1.j);
        System.out.println(myClass2.i);
        System.out.println(myClass2.j);
    }
}
class MyClass {
    public final double i = Math.random();
    public static double j = Math.random();
}