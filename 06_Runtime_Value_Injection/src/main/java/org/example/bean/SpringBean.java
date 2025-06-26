package org.example.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean implements InitializingBean {
    @Value("Ayusha")
    private String name;

    public SpringBean() {
        System.out.println(name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(name);
    }


//    @Autowired(required=false)
//    public SpringBean(@Value("Ayusha") String name ,@Value("22") int age , @Value("true") boolean value,@Value("Galle") String address ,@Value("A001") int id) {
//        System.out.println("SpringBean Constructor : " + name);
//        System.out.println("SpringBean Constructor : " + age);
//        System.out.println("SpringBean Constructor : " + value);
//        System.out.println("SpringBean Constructor : " + address);
//        System.out.println("SpringBean Constructor : " + id);
//    }
//
//    @Autowired(required=false)
//    public SpringBean(@Value("John") String name ,@Value("32") int age) {
//        System.out.println("SpringBean Constructor : " + name);
//        System.out.println("SpringBean Constructor : " + age);
//    }
}
