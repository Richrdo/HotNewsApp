package com.example.hotnewsapp.model;

import com.example.hotnewsapp.entity.News;

import java.util.ArrayList;
import java.util.List;

public class NewsModel {

    private List<News> newsList=new ArrayList<>();

    public List<News> getNews(){
        return newsList;
    }

    public void setNewsList(List<News> newsList){
        this.newsList=newsList;
    }


    public interface OnCallBack{
        void onSuccess(News news);

        void onFailed(String errorInfo);
    }

}
