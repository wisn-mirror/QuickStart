package com.laiyifen.library.net.callback;

import com.laiyifen.library.net.convert.StringConvert;

import okhttp3.Response;

/**
 * Created by Wisn on 2018/5/3 上午10:35.
 */


public abstract class StringCallback extends AbsCallback<String> {

    private StringConvert convert;

    public StringCallback() {
        convert = new StringConvert();
    }

    @Override
    public String convertResponse(Response response) throws Throwable {
        String s = convert.convertResponse(response);
        response.close();
        return s;
    }
}
