package com.laiyifen.library.rerx.rx;

/**
 * Created by Wisn on 2018/4/2 下午4:50.
 */

public interface ObservableListener<T> {

    void onNetStart(String msg);
    void onNext(T result);
    void onComplete();
    void onNetError(NetWorkCodeException.ResponseThrowable responseThrowable);
}
