package com.laiyifen.order;

import android.app.Activity;
import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.laiyifen.library.commons.common.CommonActivity;
import com.laiyifen.library.commons.constants.ARoutePath;

/**
 * Created by Wisn on 2018/5/5 下午8:56.
 */

@Route(path = ARoutePath.Module2.Module2Activity)
public class Module2Activity extends CommonActivity {

    @Override
    public int bindLayout() {
        return R.layout.module2_activity;
    }

    @Override
    public void initView(Activity activity) {

    }

    @Override
    public void initData(Context context) {

    }
}
