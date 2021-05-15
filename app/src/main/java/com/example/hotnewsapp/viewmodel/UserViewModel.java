package com.example.hotnewsapp.viewmodel;

import android.content.Intent;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.hotnewsapp.R;
import com.example.hotnewsapp.entity.LoginUser;
import com.example.hotnewsapp.model.UserModel;
import com.example.hotnewsapp.util.Tools;
import com.example.hotnewsapp.view.activity.CollectActivity;
import com.example.hotnewsapp.view.activity.HomeActivity;
import com.example.hotnewsapp.view.activity.LoginActivity;
import com.example.hotnewsapp.view.activity.UserInfoActivity;

import java.io.Serializable;

public class UserViewModel extends BaseObservable implements Serializable {

    LoginUser loginUser;

    String name;
    String email;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(R.id.user_name);
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(R.id.user_email);
    }

    public void setLoginUser(LoginUser loginUser){
        this.loginUser=loginUser;
        setName(UserModel.getUserMessage(loginUser.getEmail()));
        setEmail(loginUser.getEmail());
    }

    //    个人信息页面
    public void showUserInfo(View view){
        Intent intent;
        if (loginUser==null){
            intent=new Intent(view.getContext(),LoginActivity.class);
        }else {
            intent=new Intent(view.getContext(), UserInfoActivity.class);

        }
        view.getContext().startActivity(intent);
    }

//    退出登入
    public void signOutAct(View view){
        Intent intent=new Intent(view.getContext(), HomeActivity.class);
        Tools.loginUser=null;
        view.getContext().startActivity(intent);
    }

    //查看收藏
    public void showCollect(View view){
        Intent intent=new Intent(view.getContext(),CollectActivity.class);
        view.getContext().startActivity(intent);
    }

}
