package com.atguigu.aop;

public class MathCalculator {


    public int div(int i, int j){
        int a = i/j;
        System.out.println("除法结果是：" + a);
        return a;
    }
}
