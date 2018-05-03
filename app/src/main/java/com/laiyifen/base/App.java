package com.laiyifen.base;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by Wisn on 2018/5/2 上午11:15.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "f482351318", false);

    }
}
