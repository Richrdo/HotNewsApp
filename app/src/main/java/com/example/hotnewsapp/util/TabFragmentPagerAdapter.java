package com.example.hotnewsapp.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class TabFragmentPagerAdapter extends FragmentPagerAdapter {

    String[] mTitles=new String[]{"国内","国外","社会","用户"};
    List<Fragment> fragmentList;

    public TabFragmentPagerAdapter(@NonNull FragmentManager fm,List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList=fragmentList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return this.fragmentList==null?null:this.fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return this.fragmentList==null?0:this.fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
