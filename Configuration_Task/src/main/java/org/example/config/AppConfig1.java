package org.example.config;

import org.example.bean.A;
import org.example.bean.B;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig1 {
    @Bean
    public A a() {
        return new A();
    }
    @Bean
    public B b() {
        return new B();
    }
}
