package com.example.hotnewsapp.model;

import com.example.hotnewsapp.entity.News;

import java.util.ArrayList;
import java.util.List;

public class NewsModel {

    private List<News> newsLis;

    public List<News> getNewsByType(String type){
        return HttpUtils.getNews(type);
    }

    public List<News> getNRandomNews(int n){
        return HttpUtils.getNRandomNews(n);
    }
}
