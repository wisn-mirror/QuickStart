package com.laiyifen.library.net.server;

import com.laiyifen.library.net.model.Progress;

/**
 * Created by Wisn on 2018/5/3 下午1:54.
 */

public interface ProgressListener<T> {
    /** 成功添加任务的回调 */
    void onStart(Progress progress);

    /** 下载进行时回调 */
    void onProgress(Progress progress);

    /** 下载出错时回调 */
    void onError(Progress progress);

    /** 下载完成时回调 */
    void onFinish(T t, Progress progress);

    /** 被移除时回调 */
    void onRemove(Progress progress);
}