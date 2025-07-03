package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wild")
public class WildCardMappingController {
    //wild/test/abc/hello
    //wild/test/abc122/hello
    //wild/test/ /hello

    //wild/test/abc122/de/hello - not worked
    @GetMapping("test/*/hello")
    public String sayHello() {
        return "Hello";
    }

    //wild/hello/qqq/www
    //wild/hello/1/1
    //wild/hello/1

    //wild/hello/123/123/ - not worked
    //wild/hello/123/123/sw - not worked
    @GetMapping("hello/*/*")
    public String sayHello2() {
        return "Hello2";
    }
}
