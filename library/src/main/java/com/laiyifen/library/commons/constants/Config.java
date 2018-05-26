package com.laiyifen.library.commons.constants;

import android.content.Context;

/**
 * Created by Wisn on 2018/5/22 下午1:29.
 */
public class Config {
    public static boolean isDebug = true;
    public static String HttpLogTAG = "Buiness";
    //网络缓存地址
    public static String URL_CACHE;
    //设置Context
    public static Context CONTEXT;
    //缓存最大的内存,默认为10M
    public static long MAX_MEMORY_SIZE = 10 * 1024 * 1024;

    //SharePreference的配置文件名
    public static String USER_CONFIG="test";

    public static String BASE_URL="http://api.laiyifen.com";

}
