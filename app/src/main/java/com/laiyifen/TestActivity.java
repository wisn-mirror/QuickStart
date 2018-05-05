package com.laiyifen;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.util.Log;

import com.laiyifen.library.base.BaseActivity;
import com.laiyifen.library.view.refresh.SmartRefreshLayout;
import com.laiyifen.library.view.refresh.api.DefaultRefreshHeaderCreator;
import com.laiyifen.library.view.refresh.api.RefreshFooter;
import com.laiyifen.library.view.refresh.api.RefreshHeader;
import com.laiyifen.library.view.refresh.api.RefreshLayout;
import com.laiyifen.library.view.refresh.constant.RefreshState;
import com.laiyifen.library.view.refresh.header.ClassicsHeader;
import com.laiyifen.library.view.refresh.listener.SimpleMultiPurposeListener;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by Wisn on 2018/5/3 下午5:07.
 */

public class TestActivity extends BaseActivity {

    private SmartRefreshLayout smartRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
//            supportActionBar.hide();
        }
        smartRefreshLayout = (SmartRefreshLayout) findViewById(R.id.refreshlayout);
//        smartRefreshLayout.setRefreshHeader();
        smartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("更新于%s", Locale.getDefault());
                return new ClassicsHeader(context).setTimeFormat(simpleDateFormat);
            }
        });
        smartRefreshLayout.setEnableLoadMore(false);
        smartRefreshLayout.setEnableRefresh(false);
        smartRefreshLayout.setOnMultiPurposeListener(new SimpleMultiPurposeListener() {


            @Override
            public void onFooterFinish(RefreshFooter footer, boolean success) {
                super.onFooterFinish(footer, success);
                log("onFooterFinish");
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);
                log("onRefresh");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        smartRefreshLayout.finishRefresh();
                    }
                },1000);
            }

            @Override
            public void onHeaderFinish(RefreshHeader header, boolean success) {
                super.onHeaderFinish(header, success);
                log("onHeaderFinish");
            }

            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                super.onLoadMore(refreshLayout);
                log("onLoadMore");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        smartRefreshLayout.finishLoadMore();
                    }
                },5000);
            }

            @Override
            public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {
                super.onStateChanged(refreshLayout, oldState, newState);
            }
        });

    }
    public void log(String msg){
        Log.e("Test",msg);
    }

}
