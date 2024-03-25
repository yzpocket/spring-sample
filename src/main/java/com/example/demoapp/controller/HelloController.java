package com.example.demoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String Hello(Model model){
        model.addAttribute("data", "user1");
        return "hello";
    }

    @GetMapping("/hello-mvc") // Http 요청시 ?name={value} 쿼리스트링필요
    public String helloMvc(@RequestParam(name = "name") String name, Model model){
        //쿼리스트링으로 담겨온 데이터를 name변수에 담기고
        //Model의 name이란 key값에 value에 위 값이 할당되어 뷰엔진으로 전달.
        model.addAttribute("name", name);
        //뷰엔진이 위 상태를 담아서 hello-template.html에 데이터를 담아서 반환
        return "hello-template";
    }
}