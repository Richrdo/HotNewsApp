package com.example.hotnewsapp.model;

import com.example.hotnewsapp.entity.State;
import com.google.gson.Gson;

public class RegisterModel {

    State state;
    String result;

    public State register(String name,String email,String password){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                result=HttpUtils.send("http://47.106.76.106:8080/hotNewsSys/register?email="+email+"&name="+name+"&password="+password," ","POST","application/json");
            }
        });
        thread.start();
        try{
            thread.join();
            Thread.sleep(20);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        Gson gson=new Gson();
        state=gson.fromJson(result,State.class);
        return state;
    }

}
