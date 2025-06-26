package org.example.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringBeanTwo implements BeanNameAware, BeanFactoryAware , InitializingBean, DisposableBean , ApplicationContextAware {
    public SpringBeanTwo() {
        System.out.println("SpringBeanTwo constructor");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("SpringBeanTwo setBeanFactory");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("SpringBeanTwo setBeanName");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("SpringBeanTwo destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("SpringBeanTwo afterPropertiesSet");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("SpringBeanTwo setApplicationContext");
    }
}
