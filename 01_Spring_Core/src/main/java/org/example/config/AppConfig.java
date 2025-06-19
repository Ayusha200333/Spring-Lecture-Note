package org.example.config;

import org.example.bean.MyConnection;
import org.example.bean.TestBean2;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
//@ComponentScan(basePackages = "org.example.bean")
@ComponentScan(basePackageClasses = TestBean2.class)
public class AppConfig {
    @Bean("ayusha")
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Scope("prototype")
    public MyConnection getConnection() {
        return new MyConnection();
    }

}
