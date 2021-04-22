package com.example.hotnewsapp.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.hotnewsapp.R;
import com.example.hotnewsapp.entity.LoginUser;
import com.example.hotnewsapp.entity.State;
import com.example.hotnewsapp.model.HttpUtils;
import com.example.hotnewsapp.view.HomeActivity;
import com.example.hotnewsapp.view.LoginActivity;
import com.example.hotnewsapp.view.RegisterActivity;

public class LoginViewModel extends BaseObservable {

    private String email;
    private String password;
    State state;

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(R.id.login_email);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(R.id.login_password);
    }

    //跳转到注册页面
    public void goToRegister(View view){
        Context context=view.getContext();
        context.startActivity(new Intent(context, RegisterActivity.class));
    }

//    登录
    public void loginAct(View view){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                state= HttpUtils.login("http://47.106.76.106:8080/hotNewsSys/login?email="+email+"&password="+password);
            }
        });
        thread.start();
        try{
            thread.join();
            Thread.sleep(20);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        if (state.getCode()==200){
            Intent intent=new Intent(view.getContext(), HomeActivity.class);
            LoginUser loginUser=new LoginUser();
            loginUser.setEmail(email);
            intent.putExtra("loginUser",loginUser);
            view.getContext().startActivity(intent);
        }
        Toast.makeText(view.getContext(), state.getMessage(), Toast.LENGTH_SHORT).show();
    }

}
