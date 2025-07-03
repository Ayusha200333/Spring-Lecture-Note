package org.example.controller;

import org.example.dto.CityDTO;
import org.example.dto.UserDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("json")
public class JSONController {

    @PostMapping(value = "save" ,consumes = MediaType.APPLICATION_JSON_VALUE)
    public String post(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO);
        return "saveUser";
    }

    @GetMapping("get")
    public UserDTO get() {
        CityDTO city = new CityDTO();
        city.setName("Colombo");
        city.setCode("10000");

        UserDTO user = new UserDTO();
        user.setuId("U001");
        user.setuName("Hiruna");
        user.setuAddress("Panadura");
        user.setuCity(city);

        return user;
    }
}


