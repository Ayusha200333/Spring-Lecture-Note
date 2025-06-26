package org.example;

import org.example.bean.SpringBeanOne;
import org.example.bean.SpringBeanTwo;
import org.example.config.AppConfig1;
import org.example.config.AppConfig2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig1.class);
        context.register(AppConfig2.class);
        context.refresh();

        SpringBeanOne springBeanOne1 = context.getBean(SpringBeanOne.class);
        SpringBeanOne springBeanOne2 = context.getBean(SpringBeanOne.class);
        System.out.println(springBeanOne1);
        System.out.println(springBeanOne2);


        SpringBeanTwo springBeanTwo1 = context.getBean(SpringBeanTwo.class);
        SpringBeanTwo springBeanTwo2 = context.getBean(SpringBeanTwo.class);
        System.out.println(springBeanTwo1);
        System.out.println(springBeanTwo2);

        context.registerShutdownHook();

    }
}