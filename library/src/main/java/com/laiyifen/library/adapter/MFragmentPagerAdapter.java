package com.laiyifen.library.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Wisn on 2018/5/14 下午5:09.
 */
public class MFragmentPagerAdapter extends FragmentPagerAdapter {
    HashMap<String, Fragment> data;
    List<String> pages = null;
    List<String> titles = null;

    public MFragmentPagerAdapter(FragmentManager fm, List<String> pages) {
        super(fm);
        data = new HashMap<>(pages.size());
        this.pages = pages;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = data.get(pages.get(position));
        if (fragment == null) {
            fragment = (Fragment) ARouter.getInstance().build(pages.get(position)).navigation();
            if(titles!=null){
                data.put(titles.get(position), fragment);
            }else{
                data.put(pages.get(position), fragment);
            }
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return pages.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (titles != null && titles.size() > position) return titles.get(position);
        return "";
    }
}

