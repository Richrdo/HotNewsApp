package com.example.hotnewsapp.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.example.hotnewsapp.R;
import com.example.hotnewsapp.databinding.ActivityHomeBinding;
import com.example.hotnewsapp.util.TabFragmentPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
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


    }
}