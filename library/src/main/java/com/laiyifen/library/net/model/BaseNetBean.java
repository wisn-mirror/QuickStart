package com.laiyifen.library.net.model;

import java.io.Serializable;

/**
 * Created by Wisn on 2018/5/18 上午11:42.
 */
public class BaseNetBean <T> implements Serializable {
    public int code;
    public String msg;
    public T data;

    @Override
    public String toString() {
        return "BaseNetBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}