package com.example.hotnewsapp.viewmodel;

import android.app.Application;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.hotnewsapp.R;
import com.example.hotnewsapp.databinding.NewsDetilBinding;
import com.example.hotnewsapp.entity.LoginUser;
import com.example.hotnewsapp.entity.News;
import com.example.hotnewsapp.entity.State;
import com.example.hotnewsapp.model.NewsModel;
import com.example.hotnewsapp.model.UserModel;
import com.example.hotnewsapp.view.activity.LoginActivity;

public class NewsViewModel extends AndroidViewModel {

    public NewsViewModel(@NonNull Application application) {
        super(application);
    }

    public State isCollected(int NewsId){
        Log.i("NewsViewModel","isCollected:判断是否收藏");
        State state=new State();

        if(UserModel.loginUser==null){
            Log.i("NewsViewModel","isCollected:未登录");
            state.setMessage("未登录");
            state.setCode(0);
        }else if(UserModel.loginUser!=null&&UserModel.collection==null){
            Log.i("NewsViewModel","isCollected:已登录，无收藏");
            state.setMessage("未收藏");
            state.setCode(0);
        }else if(UserModel.loginUser!=null&&UserModel.collection!=null){
            for(int i=0;i<UserModel.collection.size();i++){
                if (NewsId==UserModel.collection.get(i).getId()){
                    Log.i("isCollected","isCollected:已登录，已收藏");
                    state.setMessage("已收藏");
                    state.setCode(1);
                    return state;
                }
            }
            Log.i("NewsViewModel","isCollected:已登录，未收藏");
            state.setMessage("未收藏");
            state.setCode(0);
        }
        return state;
    }

    public State collectButtonClick(View view, @NonNull NewsDetilBinding binding, State collectState, News news){
        State newCollectState=collectState;
        if(collectState.getCode()==0){//添加收藏
            Log.d("NewsViewModel/点击收藏按钮","add");
            if(collectState.getMessage().equals("未登录")){

                Log.d("NewsViewModel/点击收藏按钮","collectState="+collectState.getMessage()+";逻辑：未登录");

                Intent intent=new Intent(view.getContext(), LoginActivity.class);
                view.getContext().startActivity(intent);

                Toast.makeText(view.getContext(), "请先登录", Toast.LENGTH_SHORT).show();
            }else if(collectState.getMessage().equals("未收藏")){
                Log.d("NewsViewModel/点击收藏按钮","collectState="+collectState.getMessage()+";逻辑：未收藏");
                State opState=UserModel.addCollect(news.getId());
                if(opState.getCode()==200) {
                    binding.collectButton.setImageResource(R.mipmap.collect2);
                    Log.d("NewsViewModel/点击收藏按钮","opState="+opState.getMessage()+";逻辑：添加收藏成功");
                    newCollectState.setCode(1);
                    newCollectState.setMessage("已收藏");

                }
                Toast.makeText(view.getContext(), "添加收藏成功", Toast.LENGTH_SHORT).show();
            }
        }else{//取消收藏
            Log.d("NewsViewModel/点击收藏按钮","delete");
            State opState=UserModel.deleteCollect(news.getId());;
            if(opState.getCode()==200){
                binding.collectButton.setImageResource(R.mipmap.collect1);
                Log.d("NewsViewModel/点击收藏按钮","opState="+opState.getMessage()+";逻辑：删除收藏成功");
                newCollectState.setCode(0);
                newCollectState.setMessage("未收藏");
            }
            Toast.makeText(view.getContext(), "删除收藏成功", Toast.LENGTH_SHORT).show();
        }
        return newCollectState;
    }
}
