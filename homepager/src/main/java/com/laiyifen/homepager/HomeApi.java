package com.laiyifen.homepager;

import com.laiyifen.homepager.bean.Movies;
import com.laiyifen.library.commons.constants.ApiUrl;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Wisn on 2018/4/7 下午3:26.
 */

public interface HomeApi {

    @GET(ApiUrl.homepager.getTopMove)
    Observable<Movies> getMovies(@Query("start") int start, @Query("count") int count);
}
