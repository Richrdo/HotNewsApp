package com.example.hotnewsapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.hotnewsapp.R;
import com.example.hotnewsapp.entity.LoginUser;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent;
        intent=new Intent(MainActivity.this,HomeActivity.class);
        startActivity(intent);
    }
}