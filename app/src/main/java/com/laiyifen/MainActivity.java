package com.laiyifen;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.laiyifen.library.common.CommonActivity;
import com.laiyifen.library.constants.ARoutePath;

@Route(path = ARoutePath.App.MainActivity)
public class MainActivity extends CommonActivity implements View.OnClickListener {


    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Activity activity) {
        swipeBackLayout.setEnableGesture(false);
        ARouter.init(getApplication());
        ARouter.getInstance().build(ARoutePath.App.TestActivity).navigation();
    }

    @Override
    public void initData(Context context) {

    }

    @Override
    public void onClick(View v) {

    }
}
