package org.example.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello")
public class HelloController {
    //Handler Mapping
    @GetMapping
    public String getMapping() {
        return "GET";
    }

    @PostMapping
    public String postMapping() {
        return "POST";
    }

    @DeleteMapping
    public String deleteMapping() {
        return "DELETE";
    }

    @PutMapping
    public String putMapping() {
        return "PUT";
    }
}
