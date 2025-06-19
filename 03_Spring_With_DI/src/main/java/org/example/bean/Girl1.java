package org.example.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Girl1 implements Agreement{
    public Girl1(){
        System.out.println("Girl Constructor Called");
    }


    @Override
    public void chat() {
        System.out.println("Girl1 Chatting...");
    }
}
