package com.example.hotnewsapp.view.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hotnewsapp.databinding.FragmentUserBinding;
import com.example.hotnewsapp.entity.LoginUser;
import com.example.hotnewsapp.util.Tools;
import com.example.hotnewsapp.view.activity.LoginActivity;
import com.example.hotnewsapp.view.activity.UserInfoActivity;
import com.example.hotnewsapp.viewmodel.UserViewModel;

public class UserFragment extends Fragment {

    private Activity mActivity;
    private FragmentUserBinding fragmentUserBinding;
    private final LoginUser loginUser=Tools.loginUser;
    UserViewModel userViewModel;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mActivity=(Activity)context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentUserBinding=FragmentUserBinding.inflate(inflater);

        initView();

        return fragmentUserBinding.getRoot();
    }

    private void initView(){
        userViewModel =new UserViewModel();
        if (loginUser!=null){
            userViewModel.setLoginUser(loginUser);
            Log.e("TAG", "initView: 现在的用户是" +loginUser.toString());
        }
        fragmentUserBinding.setUserViewModel(userViewModel);

        fragmentUserBinding.userInfoLayout.setOnClickListener(v->{
            Intent intent;
            if (Tools.loginUser==null){
                intent=new Intent(mActivity, LoginActivity.class);
            }else{
                userViewModel.setLoginUser(loginUser);
                intent=new Intent(mActivity, UserInfoActivity.class);
            }
            intent.putExtra("userViewModel", userViewModel);
            v.getContext().startActivity(intent);
        });


    }
}
