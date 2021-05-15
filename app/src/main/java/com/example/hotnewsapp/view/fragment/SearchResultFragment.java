package com.example.hotnewsapp.view.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hotnewsapp.R;
import com.example.hotnewsapp.databinding.FragmentSearchResultBinding;
import com.example.hotnewsapp.entity.News;
import com.example.hotnewsapp.model.HttpUtils;
import com.example.hotnewsapp.util.NewsRecycleViewAdapter;
import com.example.hotnewsapp.view.activity.SearchActivity;

import java.util.List;


public class SearchResultFragment extends Fragment {
    private FragmentSearchResultBinding binding;
    private NewsRecycleViewAdapter searchResultAdapter;
    private RecyclerView searchRecyclerView;
    private List<News> newsList;
    private View view;
    String key="";
    SearchActivity mActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        Log.e("TAG", "onAttach: start" );
        super.onAttach(context);
        mActivity=(SearchActivity) context;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.e("TAG", "search result onCreate: " );
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("TAG", "search result onCreateView: " );
        binding= FragmentSearchResultBinding.inflate(inflater);
        view = binding.getRoot();
        initView();
        return view;
    }

    private void initView() {//初始化recyclerview
        Log.e("TAG", "initView:start ");
        searchRecyclerView = view.findViewById(R.id.search_result_rv);
        searchResultAdapter = new NewsRecycleViewAdapter(getActivity());

        //设置布局管理器
        searchRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //设置adapter
        searchRecyclerView.setAdapter(searchResultAdapter);
        Bundle bundle=getArguments();
        if(!mActivity.getKey().equals("")){
            key=mActivity.getKey();
            Log.e("TAG", "result key "+key);
            setData();
        }
    }

    private void setData() {
        Log.e("TAG", "setData: start" );
        if(!key.equals("")) {
            newsList = HttpUtils.getNewsByKey(key);
            searchResultAdapter.putNewsList(newsList,0);
        }
    }
}