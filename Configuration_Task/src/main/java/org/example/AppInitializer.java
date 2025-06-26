package org.example;

import org.example.bean.A;
import org.example.bean.B;
import org.example.bean.C;
import org.example.bean.D;
import org.example.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

//        SpringBean bean = context.getBean(SpringBean.class);
//        A a = context.getBean(A.class);
//        B b = context.getBean(B.class);
//        C c = context.getBean(C.class);
//        D d = context.getBean(D.class);
//
//        System.out.println(bean);
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//        System.out.println(d);

        context.registerShutdownHook();
    }
}