package com.hxzs.mall.fragment.homefragment.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hxzs.hxzs.R;


/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/4/28 13:30
 */
public class TuijianRecycleViewHolder extends RecyclerView.ViewHolder {

    public final ImageView mIv;
    public final TextView mTv1;
    public final TextView mTv2;
    public final LinearLayout mLl;

    public TuijianRecycleViewHolder(View itemView) {
        super(itemView);
        mIv = (ImageView) itemView.findViewById(R.id.tuijian_iv);
        mTv1 = (TextView) itemView.findViewById(R.id.tuijian_tv);
        mTv2 = (TextView) itemView.findViewById(R.id.tuijian_tv1);
        mLl = (LinearLayout) itemView.findViewById(R.id.tuijian_ll);
    }
}
