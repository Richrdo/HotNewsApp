package com.example.hotnewsapp.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.hotnewsapp.R;
import com.example.hotnewsapp.entity.LoginUser;
import com.example.hotnewsapp.entity.State;
import com.example.hotnewsapp.model.HttpUtils;
import com.example.hotnewsapp.model.LoginModel;
import com.example.hotnewsapp.util.Tools;
import com.example.hotnewsapp.view.activity.HomeActivity;
import com.example.hotnewsapp.view.activity.RegisterActivity;

public class LoginViewModel extends BaseObservable {

    private String email;
    private String password;
    State state;
    LoginModel loginModel=new LoginModel();

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

    //注册点击事件
    public void goToRegister(View view){
        Context context=view.getContext();
        context.startActivity(new Intent(context, RegisterActivity.class));
    }

//    登录点击事件
    public void loginAct(View view){
        LoginUser loginUser=new LoginUser();
        loginUser.setEmail(email);
        loginUser.setPassword(password);
        state=loginModel.login(loginUser);
        if (state.getCode()==200){
            Intent intent=new Intent(view.getContext(), HomeActivity.class);
            Tools.loginUser=loginUser;
            view.getContext().startActivity(intent);
        }
        Toast.makeText(view.getContext(), state.getMessage(), Toast.LENGTH_LONG).show();
    }

}
