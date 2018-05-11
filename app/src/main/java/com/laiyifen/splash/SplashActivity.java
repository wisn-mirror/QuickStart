package com.laiyifen.splash;

import android.app.Activity;
import android.content.Context;
import android.view.WindowManager;

import com.laiyifen.R;
import com.laiyifen.library.base.BaseActivity;

/**
 * Created by Wisn on 2018/5/11 上午9:10.
 */
public class SplashActivity extends BaseActivity {

    @Override
    public int bindLayout() {
        return R.layout.activity_spalsh;
    }

    @Override
    public void initView(Activity activity) {

    }

    @Override
    public void initData(Context context) {

    }
    /**
     * 设置全屏
     *
     * @param activity
     */
    public static void setFullScreen(Activity activity) {
        activity.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
