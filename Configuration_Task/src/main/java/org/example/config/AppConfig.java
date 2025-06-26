package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("org.example.bean")
@Import({AppConfig1.class,AppConfig2.class})
public class AppConfig {

}
