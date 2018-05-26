package com.laiyifen;

import com.laiyifen.library.base.BaseApplication;
import com.laiyifen.library.commons.constants.Config;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by Wisn on 2018/5/2 上午11:15.
 */

public class App extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "8c212d3996", false);
        initConfig();
    }

    private void initConfig() {
        Config.BASE_URL="https://api.douban.com/";
    }

}
