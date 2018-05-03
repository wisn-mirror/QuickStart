package com.laiyifen.library.net.rxadapter;

import com.laiyifen.library.net.adapter.AdapterParam;
import com.laiyifen.library.net.adapter.Call;
import com.laiyifen.library.net.adapter.CallAdapter;

import io.reactivex.Single;

/**
 * Created by Wisn on 2018/5/3 下午1:32.
 */

public class SingleBody<T> implements CallAdapter<T, Single<T>> {
    @Override
    public Single<T> adapt(Call<T> call, AdapterParam param) {
        ObservableBody<T> observable = new ObservableBody<>();
        return observable.adapt(call, param).singleOrError();
    }
}