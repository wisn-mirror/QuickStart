package com.laiyifen.shopcart;

import android.app.Activity;
import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.laiyifen.library.commons.common.CommonActivity;
import com.laiyifen.library.commons.constants.ARoutePath;
import com.laiyifen.order.R;

/**
 * Created by Wisn on 2018/5/5 下午8:56.
 */

@Route(path = ARoutePath.shopcart.ModuleActivity)
public class ModuleActivity extends CommonActivity {

    @Override
    public int bindLayout() {
        return R.layout.fragment_shopcart;
    }

    @Override
    public void initView(Activity activity) {

    }

    @Override
    public void initData(Context context) {

    }
}
