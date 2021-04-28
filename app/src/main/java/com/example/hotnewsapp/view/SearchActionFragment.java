package com.example.hotnewsapp.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hotnewsapp.R;
import com.example.hotnewsapp.databinding.FragmentDomesticBinding;
import com.example.hotnewsapp.databinding.FragmentSearchActionBinding;
import com.example.hotnewsapp.util.NewsRecycleViewAdapter;
import com.example.hotnewsapp.viewmodel.NewsRecyclerViewModel;


public class SearchActionFragment extends Fragment{
    private FragmentSearchActionBinding binding;
    private View view;
    private FragmentInteraction listerner;
    private Activity mActivity;
    private NewsRecyclerViewModel newsRecyclerViewModel;
    private NewsRecycleViewAdapter newsRecycleViewAdapter;

    //  定义了与该fag通讯的activity必须实现的接口方法
    public interface FragmentInteraction {
        void searchActionProcess(String str);
    }

    //与activity通讯用
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mActivity=(Activity)context;
        newsRecycleViewAdapter=new NewsRecycleViewAdapter(mActivity);
        if(context instanceof FragmentInteraction) {
            listerner = (FragmentInteraction)context; // 2.2 获取到宿主activity并赋值
        } else{
            throw new IllegalArgumentException("activity must implements FragmentInteraction");
        }
    }

    //与activity通讯用
    //把传递进来的activity对象释放掉
    @Override
    public void onDetach() {
        super.onDetach();
        listerner = null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentSearchActionBinding.inflate(inflater);
        initView();
        return binding.getRoot();
    }

    public void initView(){
        RecyclerView recyclerView=binding.randomRv;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(newsRecycleViewAdapter);
        newsRecyclerViewModel=new NewsRecyclerViewModel(mActivity.getApplication(),binding);
        binding.setViewModel(newsRecyclerViewModel);
    }

}