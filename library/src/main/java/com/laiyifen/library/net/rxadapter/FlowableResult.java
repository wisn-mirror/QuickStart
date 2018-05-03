package com.laiyifen.library.net.rxadapter;

import com.laiyifen.library.net.adapter.AdapterParam;
import com.laiyifen.library.net.adapter.Call;
import com.laiyifen.library.net.adapter.CallAdapter;
import com.laiyifen.library.net.model.Result;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;

/**
 * Created by Wisn on 2018/5/3 下午1:29.
 */

public class FlowableResult<T> implements CallAdapter<T, Flowable<Result<T>>> {
    @Override
    public Flowable<Result<T>> adapt(Call<T> call, AdapterParam param) {
        ObservableResult<T> observable = new ObservableResult<>();
        return observable.adapt(call, param).toFlowable(BackpressureStrategy.LATEST);
    }
}