package com.laiyifen;

import android.os.Bundle;

import com.laiyifen.library.view.swipebacklayout.SwipeBackActivity;
/**
 * Created by Wisn on 2018/5/3 下午5:07.
 */

public class TestActivity extends SwipeBackActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
      /*  ActionBar supportActionBar = getSupportActionBar();
        if(supportActionBar!=null){
            supportActionBar.hide();
        }*/
    }
}
