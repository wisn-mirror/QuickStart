package com.laiyifen.library.net.rxadapter;

import com.laiyifen.library.net.adapter.AdapterParam;
import com.laiyifen.library.net.adapter.Call;
import com.laiyifen.library.net.adapter.CallAdapter;
import com.laiyifen.library.net.model.Response;
import com.laiyifen.library.net.observable.BodyObservable;

import io.reactivex.Observable;

/**
 * Created by Wisn on 2018/5/3 下午1:31.
 */

public class ObservableBody<T> implements CallAdapter<T, Observable<T>> {
    @Override
    public Observable<T> adapt(Call<T> call, AdapterParam param) {
        Observable<Response<T>> observable = AnalysisParams.analysis(call, param);
        return new BodyObservable<>(observable);
    }
}