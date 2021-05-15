package com.example.hotnewsapp.util;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotnewsapp.R;
import com.example.hotnewsapp.entity.News;
import com.example.hotnewsapp.view.activity.NewsDetailActivity;

import java.util.List;

public class NewsRecycleViewAdapter extends RecyclerView.Adapter<NewsRecycleViewAdapter.ViewHolder> {

    private Context context;
    private List<News> newsList;
    private static final int HOME = 0;
    private static final int INTRO = 1;
    int type;

    public void putNewsList(List<News> newsList,int type){
        this.newsList=newsList;
        this.type=type;
    }

    @Override
    public int getItemViewType(int position) {
        if ( type== 0) {
            return HOME;
        } else return INTRO;


    }

    public NewsRecycleViewAdapter(Context context){
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewHolder;

        switch (viewType) {
//            主页展示
            case HOME:
                ViewDataBinding homeBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.recycleview_news_item, parent, false);
                viewHolder = new ViewHolder(homeBinding);
                View home=LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_news_item,parent,false);
                break;
//             搜索页下方推荐
            case INTRO:
                ViewDataBinding introBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.layout_search_introduce_item, parent, false);
                viewHolder = new ViewHolder(introBinding);
                View intro=LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_search_introduce_item,parent,false);
                break;
            default:
                return null;
        }

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=viewHolder.getAdapterPosition();
                News news=newsList.get(position);
                Intent intent=new Intent(context, NewsDetailActivity.class);
                intent.putExtra("news_to_show",news);
                v.getContext().startActivity(intent);
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
