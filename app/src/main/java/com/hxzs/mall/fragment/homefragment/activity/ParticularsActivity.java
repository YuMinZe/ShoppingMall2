package com.hxzs.mall.fragment.homefragment.activity;


import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hxzs.hxzs.R;
import com.hxzs.mall.fragment.homefragment.bean.EvenBusBean;
import com.hxzs.mall.utils.Constants;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ParticularsActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView mName;
    private TextView mPrice;
    private ImageView mImages;
    private Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                EvenBusBean eventbus = (EvenBusBean) msg.obj;
                ImageLoader.getInstance().displayImage(Constants.ImageURL+eventbus.getImages(),mImages);
                mName.setText(eventbus.getName()+"");
                mPrice.setText(eventbus.getPrice()+"");
            }
        };


    //使用工具进行的初始化
    private ImageButton ibGoodInfoBack;
    private ImageButton ibGoodInfoMore;
    private ImageView ivGoodInfoImage;
    private TextView tvGoodInfoName;
    private TextView tvGoodInfoDesc;
    private TextView tvGoodInfoPrice;
    private TextView tvGoodInfoStore;
    private TextView tvGoodInfoStyle;
    private WebView wbGoodInfoMore;
    private LinearLayout llGoodsRoot;
    private TextView tvGoodInfoCallcenter;
    private TextView tvGoodInfoCollection;
    private TextView tvGoodInfoCart;
    private Button btnGoodInfoAddcart;

    //更多布局控件的实例化
    private TextView tv_more_share;
    private TextView tv_more_search;
    private TextView tv_more_home;
    private Button btn_more;
    private LinearLayout ll_root;

    private void findViews() {
        tvGoodInfoPrice = (TextView) findViewById(R.id.tv_good_info_price);
        tvGoodInfoStore = (TextView) findViewById(R.id.tv_good_info_store);
        tvGoodInfoStyle = (TextView) findViewById(R.id.tv_good_info_style);
        wbGoodInfoMore = (WebView) findViewById(R.id.wb_good_info_more);
        llGoodsRoot = (LinearLayout) findViewById(R.id.ll_goods_root);

        tvGoodInfoCallcenter = (TextView) findViewById(R.id.tv_good_info_callcenter);
        tvGoodInfoCollection = (TextView) findViewById(R.id.tv_good_info_collection);
        tvGoodInfoCart = (TextView) findViewById(R.id.tv_good_info_cart);

        btnGoodInfoAddcart = (Button) findViewById(R.id.btn_good_info_addcart);

        tv_more_share = (TextView) findViewById(R.id.tv_more_share);
        tv_more_search = (TextView) findViewById(R.id.tv_more_search);
        tv_more_home = (TextView) findViewById(R.id.tv_more_home);
        btn_more = (Button) findViewById(R.id.btn_more);

        ll_root = (LinearLayout) findViewById(R.id.ll_root);

        //点击事件
        btnGoodInfoAddcart.setOnClickListener(this);

        tvGoodInfoCallcenter.setOnClickListener(this);
        tvGoodInfoCollection.setOnClickListener(this);
        tvGoodInfoCart.setOnClickListener(this);
        //设置更多布局栏里控件的点击事件
        tv_more_share.setOnClickListener(this);
        tv_more_search.setOnClickListener(this);
        tv_more_home.setOnClickListener(this);

    }

    private static final String GOODS_BEAN = "goodsBean";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_particulars);

        EventBus.getDefault().register(this);
        mImages = (ImageView) findViewById(R.id.particulars_iv);
        mName = (TextView) findViewById(R.id.particulars_name);
        mPrice = (TextView) findViewById(R.id.particulars_price);
        ImageView fanhui = (ImageView) findViewById(R.id.fanhui);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViews();
        initdata();

    }

    private void initdata() {
        //设置webView支持JavaScript,首先得到webView的设置对象,用settings进行设置
        WebSettings settings = wbGoodInfoMore.getSettings();
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setJavaScriptEnabled(true);
        //优先使用缓存
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
//        //允许网页缩放
//        settings.setSupportZoom(true);
        wbGoodInfoMore.setWebViewClient(new WebViewClient());
        wbGoodInfoMore.loadUrl("http://www.baidu.com");
    }

    @Subscribe(sticky = true,threadMode = ThreadMode.BACKGROUND)
    public void  onEventMainThread(EvenBusBean eventbus){
            Message msg = Message.obtain();
            msg.obj = eventbus;
            handler.sendMessage(msg);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View v) {
//返回的按钮,关闭商品详情页
        if (v == ibGoodInfoBack) {
            finish();
        } else if (v == ibGoodInfoMore) {
            Toast.makeText(ParticularsActivity.this, "更多", Toast.LENGTH_SHORT).show();
            ll_root.setVisibility(View.VISIBLE);
        } else if (v == btnGoodInfoAddcart) {
            Toast.makeText(this, "购物车", Toast.LENGTH_SHORT).show();
        } else if (v == tvGoodInfoCallcenter) {
            Toast.makeText(ParticularsActivity.this, "联系客服", Toast.LENGTH_SHORT).show();
        } else if (v == tvGoodInfoCollection) {
            Toast.makeText(this, "收藏", Toast.LENGTH_SHORT).show();
        } else if (v == tvGoodInfoCart) {
            Toast.makeText(ParticularsActivity.this, "购物车", Toast.LENGTH_SHORT).show();
        } else if (v == tv_more_share) {
            Toast.makeText(ParticularsActivity.this, "分享", Toast.LENGTH_SHORT).show();
        } else if (v == tv_more_search) {
            Toast.makeText(ParticularsActivity.this, "搜索", Toast.LENGTH_SHORT).show();
        } else if (v == tv_more_home) {
            Toast.makeText(ParticularsActivity.this, "首页", Toast.LENGTH_SHORT).show();
        }
    }
}
