package com.example.demoapp.dto;

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
}
