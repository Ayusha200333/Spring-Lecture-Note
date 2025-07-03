package org.example.controller;

import org.example.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("form")
public class FormURLController {
//    @PostMapping("save")
//    public String saveUser(@RequestParam Map<String, String> formData) {
//        for(Map.Entry<String, String> entry : formData.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
//        return "Saved";
//    }


    @PostMapping("save")
    public String saveUser(@ModelAttribute UserDTO userDTO) {
        System.out.println(userDTO);
        return "Saved";
    }
}



