package org.example.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test2 implements DiInterface{
    //Property Injection

    DI di;

    //    @Autowired
    //constructor injection
//    public Test2(DI di) {
//        this.di = di;
//    }

    //setter method injection
//    @Autowired
//    public void setterMethod(DI di) {
//        this.di = di;
//    }

    public void test(){
        di.sayHello();
    }

    //interface through injection
    @Autowired
    @Override
    public void injected(DI test1) {
        this.di = test1;
    }
}
