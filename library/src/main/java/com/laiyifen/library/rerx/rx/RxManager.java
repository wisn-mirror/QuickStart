package com.laiyifen.library.rerx.rx;

import com.laiyifen.library.utils.LogUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Wisn on 2018/4/2 下午1:29.
 */

public class RxManager {
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public <T> DisposableObserver<T> addObserver(final Observable<T> netWorkObservable,
                                                 final RxObservableListener<T> rxObservableListener) {
        DisposableObserver<T> observer = netWorkObservable.compose(RxSchedulers.<T>io_main())
                .subscribeWith(new RxSubscriber<T>() {
                    @Override
                    protected void onStart() {
                        super.onStart();
                        rxObservableListener.onNetStart(null);
                    }

                    @Override
                    public void _onNext(T t) {
                        LogUtils.d("_onNext");
                        rxObservableListener.onNext(t);
                    }

                    @Override
                    public void _onError(NetWorkCodeException.ResponseThrowable e) {
                        LogUtils.d("_onError" + e.getMessage());
                        rxObservableListener.onNetError(e);
                    }

                    @Override
                    public void _onComplete() {
                        LogUtils.d("_onComplete");
                        rxObservableListener.onComplete();
                    }
                });

        if (observer != null) {
            compositeDisposable.add(observer);
        }
        return observer;
    }

    public void clear() {
        compositeDisposable.dispose();
    }
}
