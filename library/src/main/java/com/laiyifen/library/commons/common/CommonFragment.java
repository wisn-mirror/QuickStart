package com.laiyifen.library.commons.common;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laiyifen.library.base.BaseFragment;
import com.laiyifen.library.commons.mvp.BasePresenter;
import com.laiyifen.library.utils.ObjectGetByClassUtils;

/**
 * Created by Wisn on 2018/5/13 上午10:05.
 */
public abstract  class CommonFragment< E extends BasePresenter>  extends BaseFragment{
    public E mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPresenter = ObjectGetByClassUtils.getClass(this, 1);
        if ( mPresenter != null) {
            mPresenter.setV(this);
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.onDestroy();
    }
}
