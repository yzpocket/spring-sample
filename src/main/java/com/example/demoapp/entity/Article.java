package com.example.demoapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Article {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @Column
    private String contents;

    public Article(Long id, String title, String contents){
        this.id = id;
        this.title = title;
        this.contents = contents;

    }

    public Article() {

    }

    @Override
    public String toString(){
        return "ArticleForm{"+
                "id='"+id+'\''+
                "title='"+title+'\'' +
                ", contents='"+contents+'\''+
                '}';
    }
}
