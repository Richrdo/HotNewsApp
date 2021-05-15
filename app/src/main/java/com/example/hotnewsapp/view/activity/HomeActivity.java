package com.example.hotnewsapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hotnewsapp.R;
import com.example.hotnewsapp.databinding.ActivityHomeBinding;
import com.example.hotnewsapp.util.TabFragmentPagerAdapter;
import com.example.hotnewsapp.view.fragment.DomesticFragment;
import com.example.hotnewsapp.view.fragment.InternationalFragment;
import com.example.hotnewsapp.view.fragment.SocialFragment;
import com.example.hotnewsapp.view.fragment.UserFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{
    ActivityHomeBinding binding;
    List<Fragment> fragmentList=new ArrayList<>();
    ViewPager viewPager;
    FragmentPagerAdapter adapter;
    InternationalFragment internationalFragment=new InternationalFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_home);
        init();
    }
    public void init(){
        fragmentList.add(new DomesticFragment());
        fragmentList.add(new InternationalFragment());
        fragmentList.add(new SocialFragment());
        fragmentList.add(new UserFragment());

        adapter=new TabFragmentPagerAdapter(getSupportFragmentManager(),fragmentList);
        viewPager=binding.homeViewPager;

        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);
        binding.tabLayout.setupWithViewPager(viewPager);
        binding.search.setOnClickListener(this);
    }
//  搜索框点击事件
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(HomeActivity.this,SearchActivity.class);
        startActivity(intent);
    }
}