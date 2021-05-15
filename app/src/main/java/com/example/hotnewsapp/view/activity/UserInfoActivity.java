package com.example.hotnewsapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.hotnewsapp.R;
import com.example.hotnewsapp.databinding.ActivityUserInforBinding;
import com.example.hotnewsapp.viewmodel.UserViewModel;

public class UserInfoActivity extends AppCompatActivity {

    ActivityUserInforBinding activityUserInforBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityUserInforBinding= DataBindingUtil.setContentView(this,R.layout.activity_user_infor);
        Intent intent=getIntent();
        UserViewModel userViewModel = (UserViewModel) intent.getSerializableExtra("userViewModel");
        activityUserInforBinding.setUserViewModel(userViewModel);
    }
}