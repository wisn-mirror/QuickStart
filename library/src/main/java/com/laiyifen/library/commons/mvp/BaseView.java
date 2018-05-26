package com.laiyifen.library.commons.mvp;

/**
 * Created by Wisn on 2018/4/2 下午1:29.
 */

public interface BaseView {
    void onNetError(String errorMsg);
    void onNetStart(String startMsg);
    void onNetFinish(String startMsg);

}
