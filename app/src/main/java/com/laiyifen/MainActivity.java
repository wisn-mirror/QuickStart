package com.laiyifen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.laiyifen.base.BaseActivity;
import com.laiyifen.library.net.Net;
import com.laiyifen.library.net.callback.StringCallback;
import com.laiyifen.library.net.model.Response;
import com.meituan.android.walle.WalleChannelReader;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text= (TextView) findViewById(R.id.name);
        String channel = WalleChannelReader.getChannel(this.getApplicationContext());
        text.setText(channel);
        startActivity(new Intent(this,TestActivity.class));
        swipeBackLayout.setEnableGesture(false);
        Net.<String>get("https://api.douban.com/v2/movie/top250?start=0&count=10")
                .execute( new StringCallback(){
                    @Override
                    public void onSuccess(Response<String> response) {
                        Log.e("test",response+response.body());
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                    }
                });
    }
}
