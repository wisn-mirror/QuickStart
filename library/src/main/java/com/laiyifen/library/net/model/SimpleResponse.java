package com.laiyifen.library.net.model;

import java.io.Serializable;

/**
 * Created by Wisn on 2018/5/18 上午11:42.
 */
public class SimpleResponse implements Serializable {

    private static final long serialVersionUID = -1477609349345966116L;

    public int code;
    public String msg;

    public BaseNetBean toResponse() {
        BaseNetBean baseNetBean = new BaseNetBean();
        baseNetBean.code = code;
        baseNetBean.msg = msg;
        return baseNetBean;
    }
}