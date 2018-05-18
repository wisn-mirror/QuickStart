package com.laiyifen;

import com.alibaba.android.arouter.launcher.ARouter;
import com.laiyifen.library.base.BaseApplication;
import com.laiyifen.library.utils.Utils;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by Wisn on 2018/5/2 上午11:15.
 */

public class App extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "8c212d3996", false);
        Utils.init(this);
//        ARouter.debuggable();
        ARouter.openLog();     // 打印日志
        ARouter.openDebug();     // 打印日志
        ARouter.init(this);


    }
}