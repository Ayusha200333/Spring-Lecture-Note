package org.example;

import org.example.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

//        //System Variables
        Map<String,String> env = System.getenv();
        for (Map.Entry<String,String> entry : env.entrySet()) {
//            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
//
//        System.out.println("=================================");
//
//
//        //Predefined Java Properties
//        System.getProperties().list(System.out);





        context.registerShutdownHook();
    }
}