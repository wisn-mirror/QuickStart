package com.laiyifen.library.net.callback;

import com.laiyifen.library.net.convert.FileConvert;

import java.io.File;

import okhttp3.Response;

/**
 * Created by Wisn on 2018/5/3 上午10:34.
 */

public abstract class FileCallback extends AbsCallback<File> {

    private FileConvert convert;    //文件转换类

    public FileCallback() {
        this(null);
    }

    public FileCallback(String destFileName) {
        this(null, destFileName);
    }

    public FileCallback(String destFileDir, String destFileName) {
        convert = new FileConvert(destFileDir, destFileName);
        convert.setCallback(this);
    }

    @Override
    public File convertResponse(Response response) throws Throwable {
        File file = convert.convertResponse(response);
        response.close();
        return file;
    }
}