package com.hxzs.mall.application;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * 1. 初始化的工具类
 * 2. @author $Yuminze
 * 3. @date 2017/4/25 18:29
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);
        //初始化okhttp的工具类
        initokhttp();

    }

    private void initokhttp() {
        OkHttpClient client = new OkHttpClient.Builder()
                //设置连接超时的时间
                .connectTimeout(10000, TimeUnit.MILLISECONDS)
                //设置读取超时时间
                .readTimeout(10000,TimeUnit.MILLISECONDS)

                .build();

        OkHttpUtils.initClient(client);
    }
}
