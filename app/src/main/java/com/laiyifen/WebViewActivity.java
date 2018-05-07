package com.laiyifen;

import android.os.Bundle;
import android.webkit.WebView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.laiyifen.library.ActivityPath;
import com.laiyifen.library.base.BaseActivity;

/**
 * Created by Wisn on 2018/5/7 下午1:32.
 */
@Route(path = ActivityPath.App.WebViewActivity)
public class WebViewActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        WebView webView = (WebView) findViewById(R.id.webview);
        webView.loadUrl(getIntent().getStringExtra("url"));
    }
}
