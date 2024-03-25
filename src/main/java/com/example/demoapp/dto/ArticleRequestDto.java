package com.example.demoapp.dto;

import com.example.demoapp.entity.Article;

public class ArticleRequestDto {
    private String title;
    private String contents;

    public ArticleRequestDto(String title, String contents){
        this.title = title;
        this.contents = contents;
    }

    @Override
    public String toString(){
        return "ArticleForm{"+
                "title='"+title+'\'' +
                ", contents='"+contents+'\''+
                '}';
    }

    public Article toEntity() {
        return new Article(null,title,contents);
    }
}
