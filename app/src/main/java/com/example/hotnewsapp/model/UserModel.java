package com.example.hotnewsapp.model;

import com.example.hotnewsapp.entity.LoginUser;
import com.example.hotnewsapp.entity.State;
import com.google.gson.Gson;

import java.io.Serializable;

public class UserModel implements Serializable {

    private static LoginUser loginUser=null;
    static Gson gson=new Gson();
    static State state;

    public LoginUser getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(LoginUser loginUser) {
        this.loginUser = loginUser;
    }

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

}
