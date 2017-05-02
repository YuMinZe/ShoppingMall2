package com.hxzs.mall.fragment.homefragment.activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hxzs.hxzs.R;
import com.hxzs.mall.fragment.homefragment.bean.EvenBusBean;
import com.hxzs.mall.utils.Constants;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ParticularsActivity extends AppCompatActivity {


    private TextView mName;
    private TextView mPrice;
    private ImageView mImages;

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

    }
    @Subscribe(sticky = true,threadMode = ThreadMode.BACKGROUND)
    public void  onEventMainThread(EvenBusBean eventbus){
        ImageLoader.getInstance().displayImage(Constants.ImageURL+eventbus.getImages(),mImages);
        Log.i("zzz",Constants.ImageURL+eventbus.getImages());
        mName.setText(eventbus.getName()+"");
        mPrice.setText(eventbus.getPrice()+"");

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
