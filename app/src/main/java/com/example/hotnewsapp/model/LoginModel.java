package com.example.hotnewsapp.model;

import com.example.hotnewsapp.entity.LoginUser;
import com.example.hotnewsapp.entity.State;

public class LoginModel {

    State state;

    public State login(LoginUser loginUser){
        state= HttpUtils.login("http://47.106.76.106:8080/hotNewsSys/login?email="
                +loginUser.getEmail()+"&password="+loginUser.getPassword());
        return state;
    }

}
