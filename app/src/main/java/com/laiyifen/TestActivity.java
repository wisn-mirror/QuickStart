package com.laiyifen;

import android.os.Bundle;
import android.support.v7.app.ActionBar;

import com.laiyifen.base.BaseActivity;
/**
 * Created by Wisn on 2018/5/3 下午5:07.
 */

public class TestActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ActionBar supportActionBar = getSupportActionBar();
        if(supportActionBar!=null){
//            supportActionBar.hide();
        }
    }
}
