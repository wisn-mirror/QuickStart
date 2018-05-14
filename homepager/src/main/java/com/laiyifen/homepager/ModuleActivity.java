package com.laiyifen.homepager;

import android.app.Activity;
import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.laiyifen.library.commons.common.CommonActivity;
import com.laiyifen.library.commons.constants.ARoutePath;

/**
 * Created by Wisn on 2018/5/14 下午6:49.
 */
@Route(path = ARoutePath.homepager.ModuleActivity)
public class ModuleActivity extends CommonActivity{
    @Override
    public int bindLayout() {
        return R.layout.fragment_homepager;
    }

    @Override
    public void initView(Activity activity) {

    }

    @Override
    public void initData(Context context) {

    }
}
