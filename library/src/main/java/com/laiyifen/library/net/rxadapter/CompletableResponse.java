package com.laiyifen.library.net.rxadapter;

import com.laiyifen.library.net.adapter.AdapterParam;
import com.laiyifen.library.net.adapter.Call;
import com.laiyifen.library.net.adapter.CallAdapter;

import io.reactivex.Completable;

/**
 * Created by Wisn on 2018/5/3 下午1:28.
 */

public class CompletableResponse<T> implements CallAdapter<T, Completable> {
    @Override
    public Completable adapt(Call<T> call, AdapterParam param) {
        ObservableResponse<T> observable = new ObservableResponse<>();
        return observable.adapt(call, param).ignoreElements();
    }
}
