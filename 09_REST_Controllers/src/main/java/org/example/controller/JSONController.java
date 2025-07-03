package org.example.controller;

import org.example.dto.UserDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("json")
public class JSONController {

    @PostMapping(value = "save" ,consumes = MediaType.APPLICATION_JSON_VALUE)
    public String post(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO);
        return "saveUser";
    }
}

