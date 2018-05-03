package com.laiyifen.library.net.rxadapter;

import com.laiyifen.library.net.adapter.AdapterParam;
import com.laiyifen.library.net.adapter.Call;
import com.laiyifen.library.net.adapter.CallAdapter;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;

/**
 * Created by Wisn on 2018/5/3 下午1:29.
 */


public class FlowableBody<T> implements CallAdapter<T, Flowable<T>> {
    @Override
    public Flowable<T> adapt(Call<T> call, AdapterParam param) {
        ObservableBody<T> observable = new ObservableBody<>();
        return observable.adapt(call, param).toFlowable(BackpressureStrategy.LATEST);
    }
}
