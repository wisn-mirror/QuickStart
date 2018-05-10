package com.laiyifen;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.laiyifen.library.ActivityPath;
import com.laiyifen.library.base.BaseActivity;
import com.meituan.android.walle.WalleChannelReader;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button module1;
    private Button module2;
    private Button webview;


    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Activity activity) {
        TextView text = (TextView) findViewById(R.id.name);
        module1 = (Button) findViewById(R.id.module1);
        module2 = (Button) findViewById(R.id.module2);
        webview = (Button) findViewById(R.id.webview);
        String channel = WalleChannelReader.getChannel(this.getApplicationContext());
        text.setText(channel);
        swipeBackLayout.setEnableGesture(false);
        module1.setOnClickListener(this);
        module2.setOnClickListener(this);
        webview.setOnClickListener(this);
        ARouter.init(getApplication());
        ARouter.getInstance().build(ActivityPath.App.TestActivity).navigation();
    }

    @Override
    public void initData(Context context) {

    }

    @Override
    public void onClick(View v) {
        if(v==module1){
            ARouter.getInstance().build(ActivityPath.Module1.Module1Activity)
                    .navigation(MainActivity.this);
        }else if(v==module2){
            ARouter.getInstance().build(ActivityPath.Module2.Module2Activity)
                    .navigation();
        }else if(v==webview){
            ARouter.getInstance()
                    .build(ActivityPath.App.WebViewActivity)
                    .withString("url", "file:///android_asset/schame-test.html")
                    .navigation(MainActivity.this);
        }
    }
}
