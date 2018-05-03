package com.laiyifen.library.net.rxadapter;

import com.laiyifen.library.net.adapter.AdapterParam;
import com.laiyifen.library.net.adapter.Call;
import com.laiyifen.library.net.model.Response;
import com.laiyifen.library.net.observable.CallEnqueueObservable;
import com.laiyifen.library.net.observable.CallExecuteObservable;

import io.reactivex.Observable;

/**
 * Created by Wisn on 2018/5/3 下午1:15.
 */

public class AnalysisParams {

    static <T> Observable<Response<T>> analysis(Call<T> call, AdapterParam param) {
        Observable<Response<T>> observable;
        if (param == null) param = new AdapterParam();
        if (param.isAsync) {
            observable = new CallEnqueueObservable<>(call);
        } else {
            observable = new CallExecuteObservable<>(call);
        }
        return observable;
    }
}
