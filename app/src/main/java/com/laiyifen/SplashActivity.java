package com.laiyifen;

import android.app.Activity;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.laiyifen.common.common.CommonActivity;
import com.laiyifen.common.constants.ARoutePath;

/**
 * Created by Wisn on 2018/5/11 上午9:10.
 */
public class SplashActivity extends CommonActivity {

    @Override
    public int bindLayout() {
        return R.layout.activity_spalsh;
    }

    @Override
    public void initView(Activity activity) {

    }

    @Override
    public void initData(Context context) {
        ARouter.getInstance().build(ARoutePath.App.MainActivity)
                .navigation();
    }

}
