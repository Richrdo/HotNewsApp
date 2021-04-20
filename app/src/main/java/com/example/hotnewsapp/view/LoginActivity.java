package com.example.hotnewsapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hotnewsapp.R;
import com.example.hotnewsapp.databinding.ActivityLoginBinding;
import com.example.hotnewsapp.entity.LoginUser;
import com.example.hotnewsapp.entity.State;
import com.example.hotnewsapp.model.HttpUtils;


public class LoginActivity extends AppCompatActivity {

    State state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void loginAct(View view){

        EditText passwordET=(EditText)findViewById(R.id.password);
        EditText emailET=(EditText)findViewById(R.id.email);
        String password=passwordET.getText().toString();
        String email=emailET.getText().toString();

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
            Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
            LoginUser loginUser=new LoginUser(email,password);

            startActivity(intent);
        }

        Toast.makeText(this, state.getMessage(), Toast.LENGTH_SHORT).show();
    }

}