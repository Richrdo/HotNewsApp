package com.example.hotnewsapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.hotnewsapp.R;
import com.example.hotnewsapp.databinding.ActivityCollectBinding;
import com.example.hotnewsapp.util.NewsRecycleViewAdapter;
import com.example.hotnewsapp.util.Tools;
import com.example.hotnewsapp.viewmodel.NewsRecyclerViewModel;

public class CollectActivity extends AppCompatActivity {

    ActivityCollectBinding activityCollectBinding;
    NewsRecycleViewAdapter newsRecycleViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCollectBinding= DataBindingUtil.setContentView(this,R.layout.activity_collect);
        newsRecycleViewAdapter=new NewsRecycleViewAdapter(getApplicationContext());

        initView();
    }

    private void initView(){
        activityCollectBinding.collectRv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        activityCollectBinding.collectRv.setAdapter(newsRecycleViewAdapter);
        NewsRecyclerViewModel newsRecyclerViewModel=new NewsRecyclerViewModel(getApplication(),activityCollectBinding, Tools.loginUser.getEmail());

        activityCollectBinding.setViewModel(newsRecyclerViewModel);
    }
}