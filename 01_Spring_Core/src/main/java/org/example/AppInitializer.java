package org.example;

import org.example.bean.MyConnection;
import org.example.bean.SpringBean;
import org.example.bean.TestBean1;
import org.example.bean.TestBean2;
import org.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        //class name
//        SpringBean springBean = context.getBean(SpringBean.class);
//        System.out.println(springBean);
//        //beanid
//        SpringBean springBean1=(SpringBean) context.getBean("springBean");
//        System.out.println(springBean1);
//        //beanid and class name
//        TestBean1 testBean1 = (TestBean1) context.getBean("testBean1");
//        System.out.println(testBean1);
//        TestBean2 testBean2 = (TestBean2) context.getBean("ayusha", TestBean2.class);
//        System.out.println(testBean2);

        MyConnection myConnection = context.getBean(MyConnection.class);
        System.out.println(myConnection);

        //beanid -> bean method name
        MyConnection myConnection2 = (MyConnection) context.getBean("ayusha");
        System.out.println(myConnection2);

        //beanid+class name
        MyConnection myConnection3 = (MyConnection) context.getBean("ayusha",MyConnection.class);
        System.out.println(myConnection3);

//        SpringBean springBean1 = context.getBean(SpringBean.class);
//        System.out.println(springBean1);
//        TestBean1 testBean1 = context.getBean(TestBean1.class);
//        System.out.println(testBean1);

//        Runtime.getRuntime().addShutdownHook(new Thread() {
//            public void run() {
//                context.close();
//            }
//        });

        context.registerShutdownHook();

//        TestBean2 testBean2 = context.getBean(TestBean2.class);
//        System.out.println(testBean2);

    }
}