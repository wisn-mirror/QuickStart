package com.laiyifen.homepager;

import com.laiyifen.homepager.bean.Movies;
import com.laiyifen.library.commons.mvp.BaseModel;
import com.laiyifen.library.commons.mvp.BasePresenter;
import com.laiyifen.library.commons.mvp.BaseView;

import io.reactivex.Observable;

/**
 * Created by Wisn on 2018/5/22 下午2:34.
 */
public interface HomePager {
    interface Model extends BaseModel {
        Observable<Movies> getTopMovies(int start, int end);
    }

    interface View extends BaseView {
        void showMovies(Movies movies);
        void loadMore(Movies movies);
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        public abstract void getTopMovies( int count);
        public abstract void refreshMovies(int count);
        public abstract void loadMoreMovies(int count);
    }

}
