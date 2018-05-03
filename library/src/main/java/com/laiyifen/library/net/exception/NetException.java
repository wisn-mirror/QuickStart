package com.laiyifen.library.net.exception;

/**
 * Created by wisn on 2017/8/22.
 */

public class NetException extends Exception {
    private static final long serialVersionUID = -8641198158155821498L;

    public NetException(String detailMessage) {
        super(detailMessage);
    }

    public static NetException UNKNOWN() {
        return new NetException("unknown exception!");
    }

    public static NetException BREAKPOINT_NOT_EXIST() {
        return new NetException("breakpoint file does not exist!");
    }

    public static NetException BREAKPOINT_EXPIRED() {
        return new NetException("breakpoint file has expired!");
    }
}
