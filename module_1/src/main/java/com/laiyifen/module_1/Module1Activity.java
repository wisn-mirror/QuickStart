package com.laiyifen.module_1;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.laiyifen.library.ActivityPath;
import com.laiyifen.library.base.BaseActivity;

/**
 * Created by Wisn on 2018/5/5 下午8:56.
 */
@Route(path = ActivityPath.Module1.Module1Activity)
public class Module1Activity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module1_activity);
    }
}
