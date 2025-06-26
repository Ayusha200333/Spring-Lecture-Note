package org.example.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {
    public HelloController() {
        System.out.println("HelloController");
    }

    @GetMapping
    public String hello(){
        return "Hello World";
    }
    @GetMapping("one")
    public String test1() {
        return "Hello Test one";
    }

    @GetMapping("two")
    public String test2() {
        return "Hello Test two";
    }
}
