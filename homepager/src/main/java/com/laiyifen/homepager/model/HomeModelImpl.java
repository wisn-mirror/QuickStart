package com.laiyifen.homepager.model;

import com.laiyifen.homepager.HomeApi;
import com.laiyifen.homepager.HomePager;
import com.laiyifen.homepager.bean.Movies;
import com.laiyifen.library.rerx.RetrofitManager;

import io.reactivex.Observable;

/**
 * Created by Wisn on 2018/5/22 下午2:55.
 */
public class HomeModelImpl implements HomePager.Model {
    @Override
    public Observable<Movies> getTopMovies(int start, int count) {
        return RetrofitManager.getApiService(HomeApi.class).getMovies(start,count);
    }
}
