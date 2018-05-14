package com.laiyifen.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Wisn on 2018/5/14 下午5:09.
 */
public class MainPagerAdapter extends FragmentPagerAdapter {
    HashMap<String, Fragment> data;
    List<String> pages = null;

    public MainPagerAdapter(FragmentManager fm, List<String> pages) {
        super(fm);
        data = new HashMap<>(pages.size());
        this.pages = pages;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = data.get(pages.get(position));
        if (fragment == null) {
            fragment = (Fragment) ARouter.getInstance().build(pages.get(position)).navigation();
            data.put(pages.get(position), fragment);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return pages.size();
    }

}

