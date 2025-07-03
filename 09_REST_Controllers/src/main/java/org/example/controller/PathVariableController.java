package org.example.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("path")
public class PathVariableController {
    //path/12
    @GetMapping(path = "{id}")
    public String hello4(@PathVariable("id") String name) {
        return name;
    }

    //path/ayu/22
    @GetMapping(path = "{name}/{age}")
    public String hello5(@PathVariable("name") String name , @PathVariable("age") int age) {
        return "Name: " + name + " Age: " + age;
    }

    //path/customer/I997
    @GetMapping("customer/{id:[I][0-9]{3}}")
    public String hello6(@PathVariable("id") String id) {
        return "ID: " + id;
    }

    //path/item/002/branch/galle
    @GetMapping(path = "item/{code}/branch/{city}")
    public String hello7(@PathVariable("code") String code, @PathVariable("city") String city) {
        return "Code: " + code + " City: " + city;
    }

    //path/item/I003/branch/galle
    @GetMapping(path = "items/{code:[I][0-9]{3}}/branch/{city}")
    public String hello8(@PathVariable("code") String code, @PathVariable("city") String city) {
        return "Code: " + code + " City: " + city;
    }

}
