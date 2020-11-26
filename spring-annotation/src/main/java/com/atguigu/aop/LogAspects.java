package com.atguigu.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.junit.jupiter.api.AfterAll;

import java.util.Arrays;
import java.util.jar.JarEntry;


/**
 * AOP 主要把握3部
 *      1. 将业务逻辑组件和切面类都加入到容器中，高速spring 哪个是切面类（Aspect）
 *      2. 在切面雷伤的每一个通知方法上标注通知注解，高速spring何时何地运行（切入点表达式）
 *      3. 开启基于注解的aop模式：@EnableAspectAutoProxy
 *
 */
@Aspect
public class LogAspects {

    @Pointcut(value = "execution(public int com.atguigu.aop.MathCalculator.*(..))")
    public void pointCut(){};

    @Before(value = "pointCut()")
    public void logStart(JoinPoint joinPoint){

        System.out.println("前置通知----除法开始----参数表是：{" + Arrays.asList(joinPoint.getArgs()) +"} -----方法名是："+joinPoint.getSignature().getName() );
    }

    @After("pointCut()")
    public void logEnd(){
        System.out.println("后置通知----除法结束");
    }

    // 注解中的returning指定参数谁来封装返回值。此处指定result接受
    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(Object result){
        System.out.println("正常返回通知----除法正常返回, 运行结果是: " + result);
    }
    // 注解中的throwing指定参数谁来封装异常值。此处指定exception接受
    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(JoinPoint joinpoint, Exception exception){
        System.out.println("方法异常通知----方法名：" + joinpoint.getSignature().getName() + "  除法异常 : " + exception);
    }

    @Around(value = "pointCut()")
    public Object around(ProceedingJoinPoint joinpoint) throws Throwable {
        System.out.println("环绕前通知----");
        Object proceed = joinpoint.proceed();
        System.out.println("环绕后通知----");
        return proceed;
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

