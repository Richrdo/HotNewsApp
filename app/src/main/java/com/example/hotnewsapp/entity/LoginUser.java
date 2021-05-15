package com.example.hotnewsapp.entity;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.hotnewsapp.R;

import java.io.Serializable;

public class LoginUser extends BaseObservable implements Serializable {
    private String email;
    private String name;
    private String password;
    private String re_password;

    @Bindable
    public String getRe_password() {
        return re_password;
    }

    public void setRe_password(String re_password) {
        this.re_password = re_password;
    }

    public LoginUser(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public LoginUser(){

    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
