package com.laiyifen.library.net.convert;

import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by Wisn on 2018/5/3 上午10:37.
 */

public class StringConvert implements Converter<String> {

    @Override
    public String convertResponse(Response response) throws Throwable {
        ResponseBody body = response.body();
        if (body == null) return null;
        return body.string();
    }
}

