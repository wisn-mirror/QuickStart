package com.laiyifen.library.net.server.task;

/**
 * Created by Wisn on 2018/5/3 下午1:58.
 */

public class PriorityObject<E> {

    public final int priority;
    public final E obj;

    public PriorityObject(int priority, E obj) {
        this.priority = priority;
        this.obj = obj;
    }
}
