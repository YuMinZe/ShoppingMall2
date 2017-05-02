package com.hxzs.mall.fragment.homefragment.ViewHolder;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.hxzs.hxzs.R;
import com.hxzs.mall.fragment.homefragment.bean.HomeBean;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/4/27 18:50
 */

public class MaioshaViewHolder extends RecyclerView.ViewHolder {

    private final TextView mTv;
    private int mNum;

    private Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                mNum--;
                if(mNum / 60 % 60<10&&mNum % 60>10){
                    mTv.setText("0"+mNum /36000 + ":0" + mNum / 60 % 60 + ":" + mNum % 60);
                }else if(mNum % 60<10&&mNum / 60 % 60>10){
                    mTv.setText("0"+mNum /36000 + ":" + mNum / 60 % 60 + ":0" + mNum % 60);
                }else if(mNum % 60<10&&mNum / 60 % 60<10){
                    mTv.setText("0"+mNum /36000 + ":0" + mNum / 60 % 60 + ":0" + mNum % 60);
                }else{
                    mTv.setText("0"+mNum /36000 + ":" + mNum / 60 % 60 + ":" + mNum % 60);
                }

                initdata();

            }
        };

    public MaioshaViewHolder(View itemView) {
        super(itemView);
        mTv = (TextView) itemView.findViewById(R.id.home_recycle_miaosha);
    }
    public void setdata(Context context, HomeBean.ResultBean result) {
        int i = Integer.parseInt(result.getSeckill_info().getStart_time());
        int j = Integer.parseInt(result.getSeckill_info().getEnd_time());
        mNum = (j - i)/1000;
        initdata();
    }

    private void initdata() {
        handler.sendEmptyMessageDelayed(0,1000);
        if(mNum==0){
            handler.removeMessages(0);
        }
    }
}
