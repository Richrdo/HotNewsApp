package com.example.hotnewsapp.view;

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

public class NewsDetailActivity extends AppCompatActivity implements View.OnClickListener{

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
        setCollectState();//每次加载要判断是否已被收藏，若收藏了则要保持状态
        newsDetilBinding.collectButton.setOnClickListener(this);//
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.collect_button://收藏按钮点击事件
                //判断是否登录，若未登录则跳转登录页面
                //若已登录，则根据收藏状态 置反
                break;
        }
    }

    public void setCollectState(){//收藏状态
        //判断是否已收藏
        //已收藏 则（未收藏图片是R.mipmap.collect1，收藏图片shR.mipmap.collect2）
        //newsDetilBinding.collectButton.setImageResource(R.mipmap.collect2);
        //未收藏则啥也不做
    }
}
