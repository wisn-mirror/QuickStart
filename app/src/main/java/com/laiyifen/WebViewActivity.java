package com.laiyifen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.laiyifen.library.ActivityPath;
import com.laiyifen.library.base.BaseActivity;
import com.laiyifen.library.view.webview.X5WebView;

/**
 * Created by Wisn on 2018/5/7 下午1:32.
 */
@Route(path = ActivityPath.App.WebViewActivity)
public class WebViewActivity extends BaseActivity {

    private X5WebView webView;

    public static void startWeb(Context context, String url){
        Intent intent=new Intent(context,WebViewActivity.class);
        intent.putExtra("url",url);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        webView = (X5WebView) findViewById(R.id.webview);
        webView.loadUrl(getIntent().getStringExtra("url"));
    }
}
