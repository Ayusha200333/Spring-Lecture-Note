package org.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("hello")
public class HelloController {
    public HelloController() {
        System.out.println("HelloController");
    }

    @GetMapping("index")
    public String hello(){
        return "index";
    }

    @GetMapping("customer")
    public String hello2(){
        return "customer";
    }
}
