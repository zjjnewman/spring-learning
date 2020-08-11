package com.atguigu.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.junit.jupiter.api.AfterAll;

import java.util.Arrays;
import java.util.jar.JarEntry;

@Aspect
public class LogAspects {

    @Pointcut(value = "execution(public int com.atguigu.aop.MathCalculator.*(..))")
    public void pointCut(){};

    @Before(value = "pointCut()")
    public void logStart(JoinPoint joinPoint){

        System.out.println(joinPoint.getSignature().getName() + "除法开始----参数表是：{" + Arrays.asList(joinPoint.getArgs()) +"}");
    }

    @After("pointCut()")
    public void logEnd(){
        System.out.println("除法结束");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(Object result){
        System.out.println("除法正常返回, 运行结果是: " + result);
    }

    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(JoinPoint joinpoint, Exception exception){
        System.out.println("方法名：" + joinpoint.getSignature().getName() + "  除法异常 : " + exception);

    }

//    @Around("pointCut()")
//    public int logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//
//        System.out.println("------环绕通知前------");
//
//        int a = (int) proceedingJoinPoint.proceed();
//
//        System.out.println("------环绕通知后------");
//        return a;
//    }
}

