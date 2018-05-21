package com.laiyifen.library.commons.mvp;

import com.laiyifen.library.rx.RxManager;

/**
 * Created by Wisn on 2018/4/2 下午1:29.
 */

public abstract class BasePresenter<T> {
    public T mView;
    private RxManager rxManager;

    public void setV( T view) {
        this.mView = view;
    }

    public RxManager getRxManager() {
        if (rxManager == null) {
            synchronized (BasePresenter.class) {
                if (rxManager == null) {
                    rxManager = new RxManager();
                }
            }
        }
        return rxManager;
    }

    public void onDestroy() {
        getRxManager().clear();
        if (rxManager != null) {
            rxManager = null;
        }
    }

}
