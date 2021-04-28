package com.example.hotnewsapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.hotnewsapp.R;
import com.example.hotnewsapp.entity.LoginUser;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginUser loginUser=(LoginUser)getIntent().getSerializableExtra("loginUser");
        

        Intent intent;
       // Log.d("TAG", "已有账户："+loginUser.toString());
        intent=new Intent(MainActivity.this,HomeActivity.class);
        startActivity(intent);
    }
}