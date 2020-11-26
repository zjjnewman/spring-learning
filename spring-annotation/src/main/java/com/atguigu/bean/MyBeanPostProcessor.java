package com.atguigu.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if("cat".equals(beanName)){

            System.out.println("初始化----"+ bean + "-----"+beanName);
            return bean;
        }
        return null;
    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if("cat".equals(beanName)){
            System.out.println("摧毁----" + bean + "-----"+beanName);
            return bean;
        }
        return null;
    }


}

