package com.laiyifen.library.net.rxadapter;

import com.laiyifen.library.net.adapter.AdapterParam;
import com.laiyifen.library.net.adapter.Call;
import com.laiyifen.library.net.adapter.CallAdapter;
import com.laiyifen.library.net.model.Result;

import io.reactivex.Maybe;

/**
 * Created by Wisn on 2018/5/3 下午1:30.
 */

public class MaybeResult<T> implements CallAdapter<T, Maybe<Result<T>>> {
    @Override
    public Maybe<Result<T>> adapt(Call<T> call, AdapterParam param) {
        ObservableResult<T> observable = new ObservableResult<>();
        return observable.adapt(call, param).singleElement();
    }
}
