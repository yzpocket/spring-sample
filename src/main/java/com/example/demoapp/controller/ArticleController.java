package com.example.demoapp.controller;

import com.example.demoapp.dto.ArticleRequestDto;
import com.example.demoapp.entity.Article;
import com.example.demoapp.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    @Autowired //boot가 미리 생성해놓은 객체를 가져다 자동 연결
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/form";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleRequestDto articleRequestDto){
        System.out.println(articleRequestDto.toString());
        // 1. dto -> entity
        Article article = articleRequestDto.toEntity();
        System.out.println(article.toString());

        // 2. entity -> save() -> repository
        Article savedArticle = articleRepository.save(article);
        System.out.println(savedArticle.toString());
        return "";
    }
}
