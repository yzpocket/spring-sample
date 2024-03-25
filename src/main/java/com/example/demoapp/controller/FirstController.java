package com.example.demoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    @GetMapping("/hi")
    public String hi(Model model){
        model.addAttribute("username", "Hello World!");
        return "hi";
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("username", "Hello World!");
        return "index";
    }


}
