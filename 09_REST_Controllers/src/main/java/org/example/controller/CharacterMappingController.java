package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("char")
public class CharacterMappingController {
    //char/item/I123
    //char/item/Iwww
    //char/item/I@@@
    //char/item/i666 - not worked
    //char/item/i666w - not worked
    @GetMapping("item/I???")
    public String sayHello() {
        return "Say Hello";
    }

    //char/1234/search
    //char/can apply 4 space/search
    //char/@@@@/search
    //char/12 4/search
    @GetMapping("????/search")
    public String hello() {
        return "Hello";
    }
}
