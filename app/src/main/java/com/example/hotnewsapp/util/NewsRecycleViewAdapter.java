package com.example.hotnewsapp.util;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotnewsapp.R;
import com.example.hotnewsapp.entity.News;
import com.example.hotnewsapp.view.NewsDetailActivity;

import java.util.List;

public class NewsRecycleViewAdapter extends RecyclerView.Adapter<NewsRecycleViewAdapter.ViewHolder> {

    private Context context;
    private List<News> newsList;

    public void putNewsList(List<News> newsList){
        this.newsList=newsList;
    }

    public NewsRecycleViewAdapter(Context context){
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.recycleview_news_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(binding);

        //获取子控件并添加点击事件
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_news_item,parent,false);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=viewHolder.getAdapterPosition();
                News news=newsList.get(position);
                Intent intent=new Intent(context, NewsDetailActivity.class);
                intent.putExtra("news_to_show",news);
                context.startActivity(intent);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getBinding().setVariable(BR.news,newsList.get(position));
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private ViewDataBinding binding;

        public ViewHolder(ViewDataBinding binding){
            super(binding.getRoot());
            this.binding=binding;
        }

        public ViewDataBinding getBinding() {
            return binding;
        }

        public void setBinding(ViewDataBinding binding) {
            this.binding = binding;
        }
    }
}
