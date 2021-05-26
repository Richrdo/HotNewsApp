package com.example.hotnewsapp.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.hotnewsapp.R;
import com.example.hotnewsapp.databinding.NewsDetilBinding;
import com.example.hotnewsapp.databinding.RecycleviewNewsItemBinding;
import com.example.hotnewsapp.entity.News;
import com.example.hotnewsapp.entity.State;
import com.example.hotnewsapp.model.UserModel;
import com.example.hotnewsapp.viewmodel.NewsViewModel;
import com.example.hotnewsapp.viewmodel.UserViewModel;

public class NewsDetailActivity extends AppCompatActivity implements View.OnClickListener{

    private NewsDetilBinding binding;
    State collectState;
    NewsViewModel viewModel;
    News news;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.news_detil);

        initView(getIntent());
    }

    private void initView(Intent intent){
        news=(News)intent.getSerializableExtra("news_to_show");
        viewModel=new NewsViewModel(getApplication());
        binding.setNews(news);
        setCollectState();//每次加载要判断是否已被收藏，若收藏了则要保持状态
        binding.collectButton.setOnClickListener(this);//
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.collect_button:
                collectState=viewModel.collectButtonClick(v,binding,collectState,news);

                break;
        }
    }

    public void setCollectState(){//收藏状态
        //设置收藏按钮
        collectState=viewModel.isCollected(news.getId());
        if(collectState.getCode()==0){
            binding.collectButton.setImageResource(R.mipmap.collect1);
        }else binding.collectButton.setImageResource(R.mipmap.collect2);
    }
}
