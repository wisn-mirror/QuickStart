package com.laiyifen.library.net.adapter;


import com.laiyifen.library.net.base.Request;
import com.laiyifen.library.net.callback.Callback;
import com.laiyifen.library.net.model.Response;

/**
 * Created by wisn on 2017/8/22.
 */

public interface  Call<T> {
    /** 同步执行 */
    Response<T> execute() throws Exception;

    /** 异步回调执行 */
    void execute(Callback<T> callback);

    /** 是否已经执行 */
    boolean isExecuted();

    /** 取消 */
    void cancel();

    /** 是否取消 */
    boolean isCanceled();

    Call<T> clone();

    Request getRequest();
}