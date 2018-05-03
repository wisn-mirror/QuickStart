package com.laiyifen.library.net.rxadapter;

import com.laiyifen.library.net.adapter.AdapterParam;
import com.laiyifen.library.net.adapter.Call;
import com.laiyifen.library.net.adapter.CallAdapter;
import com.laiyifen.library.net.model.Response;
import com.laiyifen.library.net.model.Result;
import com.laiyifen.library.net.observable.ResultObservable;

import io.reactivex.Observable;

/**
 * Created by Wisn on 2018/5/3 下午1:31.
 */

public class ObservableResult<T> implements CallAdapter<T, Observable<Result<T>>> {
    @Override
    public Observable<Result<T>> adapt(Call<T> call, AdapterParam param) {
        Observable<Response<T>> observable = AnalysisParams.analysis(call, param);
        return new ResultObservable<>(observable);
    }
}
