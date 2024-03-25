package com.example.demoapp.controller;

import com.example.demoapp.dto.ArticleRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/form";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleRequestDto articleRequestDto){
        System.out.println(articleRequestDto.toString());
        return "";
    }
}
