package org.example.config;

import org.example.bean.MyConnection;
import org.example.bean.TestBean2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "org.example.bean")
@ComponentScan(basePackageClasses = TestBean2.class)
public class AppConfig {
    @Bean("ayusha")
    public MyConnection getConnection() {
        return new MyConnection();
    }

}
