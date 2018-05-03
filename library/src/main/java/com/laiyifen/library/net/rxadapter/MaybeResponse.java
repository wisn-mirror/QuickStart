package com.laiyifen.library.net.rxadapter;

import com.laiyifen.library.net.adapter.AdapterParam;
import com.laiyifen.library.net.adapter.Call;
import com.laiyifen.library.net.adapter.CallAdapter;
import com.laiyifen.library.net.model.Response;

import io.reactivex.Maybe;

/**
 * Created by Wisn on 2018/5/3 下午1:30.
 */

public class MaybeResponse<T> implements CallAdapter<T, Maybe<Response<T>>> {
    @Override
    public Maybe<Response<T>> adapt(Call<T> call, AdapterParam param) {
        ObservableResponse<T> observable = new ObservableResponse<>();
        return observable.adapt(call, param).singleElement();
    }
}
