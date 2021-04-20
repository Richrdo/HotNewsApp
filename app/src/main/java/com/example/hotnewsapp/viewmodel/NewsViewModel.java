package com.example.hotnewsapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.hotnewsapp.model.NewsModel;

public class NewsViewModel extends AndroidViewModel {

    
    private MutableLiveData<NewsModel> newsData=null;

    public NewsViewModel(@NonNull Application application) {
        super(application);
    }

}
