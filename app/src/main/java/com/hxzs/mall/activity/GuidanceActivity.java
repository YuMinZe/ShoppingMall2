package com.hxzs.mall.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hxzs.hxzs.R;


public class GuidanceActivity extends AppCompatActivity {
    private Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

            }
        };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guidance);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent in = new Intent(GuidanceActivity.this,MainActivity.class);
                startActivity(in);
                finish();
            }
        },2000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeMessages(0);
    }
}
