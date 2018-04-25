package com.xihua.watermelon.flowerworld.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;

/*
 * 页面滑动图标滚动*/
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> list;
    public MyFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.list=list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
