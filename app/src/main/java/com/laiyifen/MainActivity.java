package com.laiyifen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.meituan.android.walle.WalleChannelReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       TextView text= findViewById(R.id.name);
        String channel = WalleChannelReader.getChannel(this.getApplicationContext());
        text.setText(channel);
    }
}
