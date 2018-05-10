package com.laiyifen.library.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;

import com.laiyifen.library.view.swipebacklayout.SwipeBackActivity;

/**
 * Created by Wisn on 2018/5/4 上午9:02.
 */

public abstract class BaseActivity extends SwipeBackActivity {
    private boolean isFrist = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayout());
        hideActionBar();
        initView(this);
    }

    public void hideActionBar() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
    }

    public void showActionBar() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.show();
        }
    }


    public abstract int bindLayout();

    public abstract void initView(Activity activity);

    public abstract void initData(Context context);


    @Override
    protected void onStart() {
        super.onStart();
        if (isFrist) {
            initData(this);
            isFrist = false;
        }
    }


}
