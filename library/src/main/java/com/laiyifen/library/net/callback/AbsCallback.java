package com.laiyifen.library.net.callback;

import com.laiyifen.library.net.base.Request;
import com.laiyifen.library.net.model.Progress;
import com.laiyifen.library.net.model.Response;
import com.laiyifen.library.net.utils.NetLog;

/**
 * Created by Wisn on 2018/5/3 上午10:31.
 */

public abstract class AbsCallback<T> implements Callback<T> {

    @Override
    public void onStart(Request<T, ? extends Request> request) {
    }

    @Override
    public void onCacheSuccess(Response<T> response) {
    }

    @Override
    public void onError(Response<T> response) {
        NetLog.printStackTrace(response.getException());
    }

    @Override
    public void onFinish() {
    }

    @Override
    public void uploadProgress(Progress progress) {
    }

    @Override
    public void downloadProgress(Progress progress) {
    }
}
