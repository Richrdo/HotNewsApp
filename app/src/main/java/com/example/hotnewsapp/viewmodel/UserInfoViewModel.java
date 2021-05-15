package com.example.hotnewsapp.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class UserInfoViewModel extends BaseObservable {

    String name;
    String email;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
