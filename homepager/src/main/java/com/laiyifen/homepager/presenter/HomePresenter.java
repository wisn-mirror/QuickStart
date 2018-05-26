package com.laiyifen.homepager.presenter;


import com.laiyifen.homepager.HomePager;
import com.laiyifen.homepager.bean.Movies;
import com.laiyifen.library.rerx.rx.RxObservableListener;

/**
 * Created by Wisn on 2018/5/22 下午2:30.
 */
public class HomePresenter extends HomePager.Presenter {
    private int pageNumber = 0;

    @Override
    public void getTopMovies(int count) {
        getRxManager().addObserver(mModel.getTopMovies(pageNumber * count, count)
                , new RxObservableListener<Movies>(mView) {
                    @Override
                    public void onNext(Movies result) {
                        if(pageNumber==0){
                            mView.showMovies(result);
                        }else{
                            mView.loadMore(result);
                        }
                    }
                });
    }

    @Override
    public void refreshMovies(int count) {
        pageNumber=0;
        getTopMovies(count);
    }

    @Override
    public void loadMoreMovies(int count) {
        pageNumber++;
        getTopMovies(count);
    }
}
