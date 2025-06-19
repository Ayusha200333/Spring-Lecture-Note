package org.example.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyConnection implements DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean {
    //Instantiation
    public MyConnection() {
        System.out.println("MyConnection Constructor");
    }


    //Bean name Aware -> set bean id
    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName is called");
    }


    //Bean Factory Aware -> add DI to bean
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory is called");
    }

    //Application context Aware -> AOP and DP
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext is called");
    }

    //Bean Initialization
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("AfterPropertiesSet is called");
    }

    //Disposable Bean
    @Override
    public void destroy() throws Exception {
        System.out.println("MyConnection destroy");
    }
}
