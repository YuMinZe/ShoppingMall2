package com.hxzs.mall.fragment.homefragment.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.hxzs.hxzs.R;


public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        WebView webView = (WebView) findViewById(R.id.xiangqing_Webview);

        Intent intent = getIntent();
        String flag = intent.getStringExtra("flag");
        webView.loadUrl(flag);
    }
}
