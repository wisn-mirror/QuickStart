package com.laiyifen;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.laiyifen.library.ActivityPath;
import com.laiyifen.library.base.BaseActivity;

/**
 * Created by Wisn on 2018/5/7 下午1:27.
 */
@Route(path = ActivityPath.App.SchemeFilterActivity)
public class SchemeFilterActivity extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
