package com.example.hotnewsapp.viewmodel;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.hotnewsapp.R;
import com.example.hotnewsapp.entity.LoginUser;
import com.example.hotnewsapp.model.UserModel;
import com.example.hotnewsapp.view.LoginActivity;

public class UserViewModel extends BaseObservable {

    UserModel userModel=new UserModel();

    private String name;
    private String email;

    public UserViewModel(String email){
         setEmail(email);
         setName(userModel.getUserMessage(email));
    }

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

    public void signOutAct(View view){
        this.email=null;
        this.name=null;
        Toast.makeText(view.getContext(),"已退出!",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(view.getContext(), LoginActivity.class);
        intent.putExtra("loginUser",new LoginUser());
        view.getContext().startActivity(intent);
    }
}
