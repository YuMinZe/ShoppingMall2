package com.hxzs.mall.fragment.homefragment.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hxzs.hxzs.R;


/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/4/26 20:56
 */
public class MyRecycleGrid extends RecyclerView.ViewHolder {
    public  ImageView mIv;
    public  TextView mTv;
    public final LinearLayout mLl;

    public MyRecycleGrid(View itemView) {
        super(itemView);
        mIv = (ImageView) itemView.findViewById(R.id.grid_item_iv);
        mTv = (TextView) itemView.findViewById(R.id.grid_item_tv);
        mLl = (LinearLayout) itemView.findViewById(R.id.bj_ll);
    }

}
