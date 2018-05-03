package com.laiyifen.library.net.server.task;

/**
 * Created by Wisn on 2018/5/3 下午1:57.
 */

public class PriorityRunnable extends PriorityObject<Runnable> implements Runnable {

    public PriorityRunnable(int priority, Runnable obj) {
        super(priority, obj);
    }

    @Override
    public void run() {
        this.obj.run();
    }
}
