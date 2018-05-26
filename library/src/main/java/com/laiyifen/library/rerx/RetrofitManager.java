package com.laiyifen.library.rerx;


import com.laiyifen.library.Interceptor.HttpLoggingInterceptor;
import com.laiyifen.library.commons.constants.Config;
import com.laiyifen.library.https.HttpsUtils;

import java.util.logging.Level;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Wisn on 2018/4/2 下午2:12.
 */

public class RetrofitManager {
    private static Retrofit mRetrofit;
    private static OkHttpClient.Builder okhttpClientBuilder;

    private static Retrofit getRetrofit() {
        if (mRetrofit == null) {
            OkHttpClient okHttpClient = buildOkHttpClient(okhttpClientBuilder);
            mRetrofit = buildRetrofit(okHttpClient);
        }
        return mRetrofit;
    }

    private static Retrofit buildRetrofit(OkHttpClient okHttpClient) {
        return mRetrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public static void setOkhttpClientBuilder(OkHttpClient.Builder okhttpClientBuilder) {
        RetrofitManager.okhttpClientBuilder = okhttpClientBuilder;
    }

    private static OkHttpClient buildOkHttpClient(OkHttpClient.Builder builder) {
        if (builder == null) {
            builder = new OkHttpClient.Builder();
        }
        //如果不是在正式包，添加拦截 打印响应json
        if (Config.isDebug) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(Config.HttpLogTAG);
            httpLoggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);
            httpLoggingInterceptor.setColorLevel(Level.INFO);
            builder.addInterceptor(httpLoggingInterceptor);
        }

        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory();
        builder.sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager);
        builder.hostnameVerifier(HttpsUtils.UnSafeHostnameVerifier);
        return builder.build();
    }

    public static <T> T getApiService(Class<T> clazz) {
        mRetrofit = getRetrofit();
        return mRetrofit.create(clazz);
    }


}
