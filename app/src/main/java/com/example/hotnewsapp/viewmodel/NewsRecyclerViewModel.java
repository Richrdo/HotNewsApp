package com.example.hotnewsapp.viewmodel;

import android.app.Application;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.AndroidViewModel;

import com.example.hotnewsapp.databinding.ActivityCollectBinding;
import com.example.hotnewsapp.databinding.FragmentDomesticBinding;
import com.example.hotnewsapp.databinding.FragmentInternationalBinding;
import com.example.hotnewsapp.databinding.FragmentSearchActionBinding;
import com.example.hotnewsapp.databinding.FragmentSocialBinding;
import com.example.hotnewsapp.model.HttpUtils;
import com.example.hotnewsapp.model.NewsModel;
import com.example.hotnewsapp.util.NewsRecycleViewAdapter;

import static com.example.hotnewsapp.model.HttpUtils.TAG;

public class NewsRecyclerViewModel extends AndroidViewModel {

    NewsModel newsModel=new NewsModel();

    public NewsRecyclerViewModel(@NonNull Application application) {
        super(application);
    }

//    以下算个构造方法，分别通过不同的DataBinding生成不同的适配器.
    public NewsRecyclerViewModel(@NonNull Application application,@NonNull FragmentInternationalBinding binding) {
        super(application);
        NewsRecycleViewAdapter adapter=(NewsRecycleViewAdapter)binding.newsRcyListInternational.getAdapter();
        assert adapter != null;
        adapter.putNewsList(newsModel.getNewsByType("international"),0);
    }

    public NewsRecyclerViewModel(@NonNull Application application, FragmentSocialBinding binding) {
        super(application);
        NewsRecycleViewAdapter adapter=(NewsRecycleViewAdapter)binding.newsListSocial.getAdapter();
        assert adapter != null;
        adapter.putNewsList(newsModel.getNewsByType("social"),0);
    }

    public NewsRecyclerViewModel(@NonNull Application application, FragmentDomesticBinding binding) {
        super(application);
        NewsRecycleViewAdapter adapter=(NewsRecycleViewAdapter)binding.newsListDomestic.getAdapter();
        assert adapter != null;
        adapter.putNewsList(newsModel.getNewsByType("domestic"),0);
    }

    public NewsRecyclerViewModel(@NonNull Application application, FragmentSearchActionBinding binding) {
        super(application);
        NewsRecycleViewAdapter adapter=(NewsRecycleViewAdapter)binding.randomRv.getAdapter();
        assert adapter != null;
        adapter.putNewsList(newsModel.getNRandomNews(12),1);
    }

    public NewsRecyclerViewModel(@NonNull Application application, ActivityCollectBinding binding,String email) {
        super(application);
        NewsRecycleViewAdapter adapter=(NewsRecycleViewAdapter)binding.collectRv.getAdapter();
        assert adapter != null;
        adapter.putNewsList(newsModel.getCollectNews(email),0);
    }

}
