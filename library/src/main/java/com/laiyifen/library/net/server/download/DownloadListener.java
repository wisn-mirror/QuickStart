package com.laiyifen.library.net.server.download;

import com.laiyifen.library.net.server.ProgressListener;

import java.io.File;

/**
 * Created by Wisn on 2018/5/3 下午1:53.
 */

public abstract class DownloadListener implements ProgressListener<File> {

    public final Object tag;

    public DownloadListener(Object tag) {
        this.tag = tag;
    }
}