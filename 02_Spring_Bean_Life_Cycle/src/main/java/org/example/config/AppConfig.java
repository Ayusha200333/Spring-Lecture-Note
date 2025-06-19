package org.example.config;

import org.example.bean.TestBean1;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackageClasses = TestBean1.class)
public class AppConfig {

}
