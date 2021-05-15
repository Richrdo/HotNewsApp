package com.example.hotnewsapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hotnewsapp.R;
import com.example.hotnewsapp.databinding.ActivityLoginBinding;
import com.example.hotnewsapp.entity.LoginUser;
import com.example.hotnewsapp.entity.State;
import com.example.hotnewsapp.model.HttpUtils;
import com.example.hotnewsapp.viewmodel.LoginViewModel;


public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "MYTAG";

    State state;
    ActivityLoginBinding activityLoginBinding;
    LoginViewModel loginViewModel=new LoginViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginBinding=DataBindingUtil.setContentView(this,R.layout.activity_login);

        initViewModel(this);

        activityLoginBinding.setLoginViewModel(loginViewModel);

    }

    private void initViewModel(Context context){
        LoginUser loginUser=(LoginUser)getIntent().getSerializableExtra("loginUser");
        if (loginUser==null){
            Log.e(TAG, "initViewModel: 非跳转用户" );
        }else{
            loginViewModel.setEmail(loginUser.getEmail());
        }
    }
}