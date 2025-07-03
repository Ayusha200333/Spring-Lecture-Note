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

    @GetMapping(path = "get2")
    public String getMapping2() {
        return "GET-2";
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

    @PatchMapping
    public String patchMapping() {
        return "PATCH";
    }
}
