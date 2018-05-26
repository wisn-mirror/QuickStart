package com.laiyifen.library.rerx.rx;

import android.text.TextUtils;

import com.laiyifen.library.commons.mvp.BaseView;

/**
 * Created by Wisn on 2018/4/2 下午5:02.
 */

public abstract class RxObservableListener<T> implements ObservableListener<T> {

    private BaseView mView;
    private String mErrorMsg;

    protected RxObservableListener(BaseView view){
        this.mView = view;
    }

    protected RxObservableListener(BaseView view, String errorMsg){
        this.mView = view;
        this.mErrorMsg = errorMsg;
    }

    @Override
    public void onNetStart(String msg) {
        if (mView == null) {
            return;
        }
        mView.onNetStart(msg);
    }

    @Override
    public void onComplete() {
        mView.onNetFinish(null);
    }

    @Override
    public void onNetError(NetWorkCodeException.ResponseThrowable e) {
        if (mView == null) {
            return;
        } if (mErrorMsg != null && !TextUtils.isEmpty(mErrorMsg)) {
            mView.onNetError(mErrorMsg);
        }else {
            mView.onNetError(e.message);
        }
    }

}
