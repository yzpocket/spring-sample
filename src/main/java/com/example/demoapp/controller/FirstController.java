package com.example.demoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    @GetMapping("/")
    public String hi(Model model){
        model.addAttribute("username", "Hello World!");
        return "hi";
    }

}
