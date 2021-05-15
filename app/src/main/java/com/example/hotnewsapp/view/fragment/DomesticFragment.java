package com.example.hotnewsapp.view.fragment;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotnewsapp.R;
import com.example.hotnewsapp.databinding.FragmentDomesticBinding;
import com.example.hotnewsapp.databinding.FragmentInternationalBinding;
import com.example.hotnewsapp.util.NewsRecycleViewAdapter;
import com.example.hotnewsapp.viewmodel.NewsRecyclerViewModel;


public class DomesticFragment extends Fragment {

    private Activity mActivity;
    FragmentDomesticBinding fragmentDomesticBinding;
    private NewsRecyclerViewModel newsRecyclerViewModel;
    private NewsRecycleViewAdapter newsRecycleViewAdapter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mActivity=(Activity)context;
        newsRecycleViewAdapter=new NewsRecycleViewAdapter(mActivity);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("TAG", "开始初始化适配器");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentDomesticBinding= FragmentDomesticBinding.inflate(inflater);

        initView();

        return fragmentDomesticBinding.getRoot();
    }

    private void initView(){
        RecyclerView recyclerView=fragmentDomesticBinding.newsListDomestic;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(newsRecycleViewAdapter);
        newsRecyclerViewModel=new NewsRecyclerViewModel(mActivity.getApplication(),fragmentDomesticBinding);
        fragmentDomesticBinding.setViewModel(newsRecyclerViewModel);
    }
}
