package com.laiyifen.library.commons.common;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.laiyifen.library.base.BaseActivity;
import com.laiyifen.library.commons.mvp.BaseModel;
import com.laiyifen.library.commons.mvp.BasePresenter;
import com.laiyifen.library.utils.ObjectGetByClassUtils;

/**
 * Created by Wisn on 2018/5/13 上午10:04.
 */
public abstract class CommonActivity <T extends BaseModel, E extends BasePresenter> extends BaseActivity {
    public T mModel;
    public E mPresenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mModel = ObjectGetByClassUtils.getClass(this, 0);
        mPresenter = ObjectGetByClassUtils.getClass(this, 1);
        if (mModel != null && mPresenter != null) {
            mPresenter.setMV(mModel, this);
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.onDestroy();
    }
}
