package com.laiyifen.library.net.rxadapter;

import com.laiyifen.library.net.adapter.AdapterParam;
import com.laiyifen.library.net.adapter.Call;
import com.laiyifen.library.net.adapter.CallAdapter;

import io.reactivex.Maybe;

/**
 * Created by Wisn on 2018/5/3 下午1:30.
 */

public class MaybeBody<T> implements CallAdapter<T, Maybe<T>> {
    @Override
    public Maybe<T> adapt(Call<T> call, AdapterParam param) {
        ObservableBody<T> observable = new ObservableBody<>();
        return observable.adapt(call, param).singleElement();
    }
}
