package com.example.hotnewsapp.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.hotnewsapp.R;
import com.example.hotnewsapp.databinding.NewsDetilBinding;
import com.example.hotnewsapp.databinding.RecycleviewNewsItemBinding;
import com.example.hotnewsapp.entity.News;

public class NewsDetailActivity extends AppCompatActivity {

    private NewsDetilBinding newsDetilBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newsDetilBinding= DataBindingUtil.setContentView(this, R.layout.news_detil);

        initView(getIntent());
    }

    private void initView(Intent intent){
        News news=(News)intent.getSerializableExtra("news_to_show");
        newsDetilBinding.setNews(news);

    }
}
