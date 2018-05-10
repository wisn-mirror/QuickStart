package com.laiyifen.library.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.ActionBar;

import com.alibaba.android.arouter.launcher.ARouter;
import com.laiyifen.library.view.swipebacklayout.SwipeBackActivity;
import com.laiyifen.library.view.swipebacklayout.SwipeBackLayout;

/**
 * Created by Wisn on 2018/5/4 上午9:02.
 */

public abstract class BaseActivity extends SwipeBackActivity {
    private boolean isFrist = true;

    public SwipeBackLayout swipeBackLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        swipeBackLayout = getSwipeBackLayout();
        swipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        swipeBackLayout.addSwipeListener(new SwipeBackLayout.SwipeListener() {
            @Override
            public void onScrollStateChange(int state, float scrollPercent) {
            }

            @Override
            public void onEdgeTouch(int edgeFlag) {
                vibrate(VIBRATE_DURATION);
            }

            @Override
            public void onScrollOverThreshold() {
                vibrate(VIBRATE_DURATION);
            }
        });
        setContentView(getLayoutId());
        hideActionBar();
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



    public abstract int getLayoutId();

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
