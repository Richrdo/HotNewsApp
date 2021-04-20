package com.example.hotnewsapp.viewmodel;

import android.app.Application;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.AndroidViewModel;

import com.example.hotnewsapp.databinding.FragmentDomesticBinding;
import com.example.hotnewsapp.databinding.FragmentInternationalBinding;
import com.example.hotnewsapp.databinding.FragmentSocialBinding;
import com.example.hotnewsapp.model.HttpUtils;
import com.example.hotnewsapp.util.NewsRecycleViewAdapter;

import static com.example.hotnewsapp.model.HttpUtils.TAG;

public class NewsRecyclerViewModel extends AndroidViewModel {

    public NewsRecyclerViewModel(@NonNull Application application) {
        super(application);
    }

    public NewsRecyclerViewModel(@NonNull Application application,@NonNull FragmentInternationalBinding binding) {
        super(application);
        NewsRecycleViewAdapter adapter=(NewsRecycleViewAdapter)binding.newsRcyListInternational.getAdapter();
        if (adapter==null){
            Log.e(TAG, "adapter is null!" );
        }
        adapter.putNewsList(HttpUtils.getNews("international"));
    }

    public NewsRecyclerViewModel(@NonNull Application application, FragmentSocialBinding binding) {
        super(application);
        NewsRecycleViewAdapter adapter=(NewsRecycleViewAdapter)binding.newsListSocial.getAdapter();
        adapter.putNewsList(HttpUtils.getNews("domestic"));
    }
    public NewsRecyclerViewModel(@NonNull Application application, FragmentDomesticBinding binding) {
        super(application);
        NewsRecycleViewAdapter adapter=(NewsRecycleViewAdapter)binding.newsListDomestic.getAdapter();
        adapter.putNewsList(HttpUtils.getNews("social"));
    }
//    public NewsRecyclerViewModel(@NonNull Application application, FragmentInternationalBinding binding) {
//        super(application);
//        NewsRecycleViewAdapter adapter=(NewsRecycleViewAdapter)binding.newsRcyListInternational.getAdapter();
//        adapter.putNewsList(HttpUtils.getNews("international"));
//    }

    public void getNews(View view){}
}
