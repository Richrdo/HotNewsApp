package com.example.hotnewsapp.model;

import android.util.Log;

import com.example.hotnewsapp.entity.LoginUser;
import com.example.hotnewsapp.entity.News;
import com.example.hotnewsapp.entity.State;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.List;

public class UserModel implements Serializable {

    public static LoginUser loginUser=null;
    static Gson gson=new Gson();
    public static List<News> collection=null;
    static State state;

    public String getLoginUserEmail(){
        return  loginUser.getEmail();
    }

    public String getLoginUserName(){
        return getUserMessage(loginUser.getEmail());
    }



    public static String getUserMessage(String email){
        loginUser=new LoginUser();
        loginUser.setEmail(email);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                state=gson.fromJson(HttpUtils.send("http://47.106.76.106:8080/hotNewsSys/userName?email="+email),State.class);
                if (state.getCode()==200){
                    loginUser.setName(state.getMessage());
                }else{
                    loginUser.setName("空");
                }
            }
        });
        thread.start();
        try{
            thread.join();
            Thread.sleep(20);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return loginUser.getName();
    }

    public static State addCollect(int newsId){
        Log.i("UserModer","addCollect");
        State state = HttpUtils.addCollect(UserModel.loginUser.getEmail(), newsId);
        Log.i("UserModer","http state:"+state.getMessage());

        //刷新收藏列表
        collection = HttpUtils.getCollectNews(loginUser.getEmail());
        return state;
    }

    public static State deleteCollect(int newsId){
        Log.i("UserModer","deleteCollect");
        State state=HttpUtils.delCollect(UserModel.loginUser.getEmail(),newsId);
        Log.i("UserModer","http state:"+state.getMessage());

        //刷新收藏列表
        collection = HttpUtils.getCollectNews(loginUser.getEmail());
        return state;
    }
}
