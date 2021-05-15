package com.example.hotnewsapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.hotnewsapp.R;
import com.example.hotnewsapp.databinding.ActivityRegisterBinding;
import com.example.hotnewsapp.viewmodel.RegisterViewModel;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding activityRegisterBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityRegisterBinding= DataBindingUtil.setContentView(this,R.layout.activity_register);
        activityRegisterBinding.setRegisterViewModel(new RegisterViewModel());
    }

}