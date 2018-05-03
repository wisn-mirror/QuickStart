package com.laiyifen.library.net.rxadapter;

import com.laiyifen.library.net.adapter.AdapterParam;
import com.laiyifen.library.net.adapter.Call;
import com.laiyifen.library.net.adapter.CallAdapter;
import com.laiyifen.library.net.model.Response;

import io.reactivex.Observable;

/**
 * Created by Wisn on 2018/5/3 下午1:31.
 */

public class ObservableResponse<T> implements CallAdapter<T, Observable<Response<T>>> {
    @Override
    public Observable<Response<T>> adapt(Call<T> call, AdapterParam param) {
        return AnalysisParams.analysis(call, param);
    }
}
