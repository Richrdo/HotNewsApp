package com.example.hotnewsapp.entity;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class State implements Serializable {
    private int code;
    private String message;

    public State(){

    }

    public State(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "State{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
