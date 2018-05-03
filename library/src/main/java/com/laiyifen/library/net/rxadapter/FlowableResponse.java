package com.laiyifen.library.net.rxadapter;

import com.laiyifen.library.net.adapter.AdapterParam;
import com.laiyifen.library.net.adapter.Call;
import com.laiyifen.library.net.adapter.CallAdapter;
import com.laiyifen.library.net.model.Response;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;

/**
 * Created by Wisn on 2018/5/3 下午1:29.
 */


public class FlowableResponse<T> implements CallAdapter<T, Flowable<Response<T>>> {
    @Override
    public Flowable<Response<T>> adapt(Call<T> call, AdapterParam param) {
        ObservableResponse<T> observable = new ObservableResponse<>();
        return observable.adapt(call, param).toFlowable(BackpressureStrategy.LATEST);
    }
}
