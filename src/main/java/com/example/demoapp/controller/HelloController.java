package com.example.demoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String Hello(Model model){
        model.addAttribute("data", "user1");
        return "hello";
    }

    @GetMapping("hello-mvc") // Http 요청시 ?name={value} 쿼리스트링필요
    public String helloMvc(@RequestParam(name = "name") String name, Model model){
        //쿼리스트링으로 담겨온 데이터를 name변수에 담기고
        //Model의 name이란 key값에 value에 위 값이 할당되어 뷰엔진으로 전달.
        model.addAttribute("name", name);
        //뷰엔진이 위 상태를 담아서 hello-template.html에 데이터를 담아서 반환
        return "hello-template";
    }

    // @ResponseBody어노테이션을 보고 부트는 HttpMessageConverter중에서 고름 그중 문자or객체로 구분
    @GetMapping("hello-string")
    @ResponseBody // 문자가 받아져서 StringConverter가 동작해서 문자 데이터 반환
    public String helloString(@RequestParam("name") String name){
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody // 객체가 받아져서 JsonConverter가 동작하여 Json 형식 데이터 반환
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }
}
