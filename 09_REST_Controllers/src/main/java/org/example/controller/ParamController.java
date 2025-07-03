package org.example.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("param")
public class ParamController {
    @GetMapping(params = {"id"})
    public String param(@RequestParam("id") String id) {
        return id + "";
    }

    @GetMapping(params = {"id","name"})
    public String param2(@RequestParam("id") String id, @RequestParam("name") String name) {
        return id + ":" + name;
    }

    @GetMapping(path = {"code"} , params = {"id", "name"})
    public String param3(@PathVariable("code") String code ,@RequestParam("id") String id, @RequestParam("name") String name) {
        return code + ":" + id + ":" + name;
    }
}
