package com.laiyifen.library.net.server.upload;

import com.laiyifen.library.net.server.ProgressListener;

/**
 * Created by Wisn on 2018/5/3 下午1:56.
 */

public abstract class UploadListener<T> implements ProgressListener<T> {

    public final Object tag;

    public UploadListener(Object tag) {
        this.tag = tag;
    }
}
