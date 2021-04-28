package com.example.hotnewsapp.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.hotnewsapp.R;
import com.example.hotnewsapp.databinding.FragmentUserBinding;
import com.example.hotnewsapp.entity.LoginUser;
import com.example.hotnewsapp.viewmodel.UserViewModel;

public class UserFragment extends Fragment {

    private Activity mActivity;
    private FragmentUserBinding fragmentUserBinding;
    private LoginUser loginUser;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mActivity=(Activity)context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginUser=(LoginUser)mActivity.getIntent().getSerializableExtra("loginUser");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentUserBinding=FragmentUserBinding.inflate(inflater);

        initView();

        return fragmentUserBinding.getRoot();
    }

    private void initView(){
      //  fragmentUserBinding.setUserViewModel(new UserViewModel(loginUser.getEmail()));
    }
}
