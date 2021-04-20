package com.example.hotnewsapp.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.hotnewsapp.R;
import com.example.hotnewsapp.databinding.FragmentInternationalBinding;
import com.example.hotnewsapp.util.NewsRecycleViewAdapter;
import com.example.hotnewsapp.viewmodel.NewsRecyclerViewModel;
import com.google.android.material.tabs.TabLayout;

import static com.example.hotnewsapp.model.HttpUtils.TAG;

public class InternationalFragment extends Fragment {

    private Activity mActivity;

    private FragmentInternationalBinding fragmentInternationalBinding;
    private NewsRecycleViewAdapter newsRecycleViewAdapter;

    NewsRecyclerViewModel newsRecyclerViewModel;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mActivity=(Activity)context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("TAG", "开始初始化适配器");
        newsRecycleViewAdapter=new NewsRecycleViewAdapter(mActivity);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentInternationalBinding=FragmentInternationalBinding.inflate(inflater);

        initView();

        return fragmentInternationalBinding.getRoot();
    }

    private void initView(){

        Log.e(TAG, "InternationalFragment开始初始化Adapter" );
        RecyclerView recyclerView = fragmentInternationalBinding.newsRcyListInternational;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(newsRecycleViewAdapter);

        Log.e(TAG, "InternationalFragment开始初始化ViewModel" );
        newsRecyclerViewModel=new NewsRecyclerViewModel(mActivity.getApplication(),fragmentInternationalBinding);
        fragmentInternationalBinding.setViewModel(newsRecyclerViewModel);

    }
}
