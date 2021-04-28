package com.example.hotnewsapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.hotnewsapp.R;
import com.example.hotnewsapp.databinding.ActivitySearchBinding;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener,SearchActionFragment.FragmentInteraction{
    private ActivitySearchBinding binding;
    private Fragment mFrag1;
    private Fragment mFrag2;
    private Fragment current;//记录当前页面
    String key="";//搜索关键词

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_search);
        Intent intent = getIntent();
        initEvents();
    }

    @Override
    public void searchActionProcess(String str) {//处理由SearchAction传过来的值(frag传给activity)
        Log.i("search","搜索框搜索");
        if (str != null) {
            key=str;
            binding.searchEdit.setText(key);
            selectFragment(1);//转导搜索结果frag
        }
    }

    public void initEvents(){
        Log.i("search","init event");
        binding.searchEdit.setOnClickListener(this);
        binding.searchButton.setOnClickListener(this);

        if(!key.equals("")) {
            binding.searchEdit.setText(key);
            selectFragment(1);
        }else selectFragment(0);
    }

    @Override
    public void onClick(View view) {
        Log.i("search","onclick");

        //点击搜索框外的地方时收起键盘
        InputMethodManager imm =  (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        if(imm != null) {
            imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(),
                    0);
        }

        switch (view.getId()){
            case R.id.search_edit:
                Log.d("TAG", "点击搜索框 ");
                selectFragment(0);
                break;
            case R.id.search_button:
                Log.d("TAG", "点击Button ");
                selectFragment(1);
                break;

        }
    }

    private void selectFragment(int i) {
        Log.i("search","selectFragment");
        //获取FragmentManager对象
        FragmentManager manager = getSupportFragmentManager();
        //获取FragmentTransaction对象
        FragmentTransaction transaction = manager.beginTransaction();
        //先隐藏所有的Fragment
        hideFragments(transaction);

        switch (i) {
            //搜索活动页面
            case 0:
                mFrag1 = new SearchActionFragment();
                transaction.add(R.id.search_content, mFrag1);
                current=mFrag1;
                binding.searchEdit.setCursorVisible(true);//编辑框闪
                break;
            //搜索结果页面
            case 1:
                if(binding.searchEdit.getText().toString().trim().equals("")) {//输入框为空，则无操作
                    transaction.show(current);
                } else{
                    key=binding.searchEdit.getText().toString();
                    Log.e("TAG", "Search message="+ key);
                    mFrag2 = new SearchResultFragment();
                    transaction.add(R.id.search_content, mFrag2);
                    binding.searchEdit.setCursorVisible(false);//编辑框不闪
                    current=mFrag2;
                }
                break;

        }
        //提交事务
        transaction.commit();
    }

    //将两个Fragment隐藏
    private void hideFragments(FragmentTransaction transaction) {
        if (mFrag1 != null) {
            transaction.hide(mFrag1);
        }
        if (mFrag2 != null) {
            transaction.hide(mFrag2);
        }
    }

    public String getKey(){ return  key;}//用于与搜索结果frag通讯(activity传给frag)
}