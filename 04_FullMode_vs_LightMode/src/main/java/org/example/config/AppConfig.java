package org.example.config;

import org.example.bean.SpringBeanOne;
import org.example.bean.SpringBeanTwo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.bean")
public class AppConfig {
    //---inter bean dependency satisfied
//    @Bean
//    public SpringBeanOne springBeanOne() {
//        SpringBeanTwo springBeanTwo1 = springBeanTwo();
//        SpringBeanTwo springBeanTwo2 = springBeanTwo();
//        System.out.println(springBeanTwo1);
//        System.out.println(springBeanTwo2);
//
//        return new SpringBeanOne();
//    }
//
//    @Bean
//    public SpringBeanTwo springBeanTwo() {
//        return new SpringBeanTwo();
//    }

}
