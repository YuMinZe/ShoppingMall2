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
 * 3. @date 2017/4/28 14:32
 */
public class XinPinRecycleViewHolder extends RecyclerView.ViewHolder {

    public final ImageView mxIv;
    public final TextView mxTv1;
    public final TextView mxTv2;
    public final LinearLayout mLl;

    public XinPinRecycleViewHolder(View itemView) {
        super(itemView);
        mxIv = (ImageView) itemView.findViewById(R.id.xinpin_iv);
        mxTv1 = (TextView) itemView.findViewById(R.id.xinpin_tv);
        mxTv2 = (TextView) itemView.findViewById(R.id.xinpin_tv1);
        mLl = (LinearLayout) itemView.findViewById(R.id.xinpin_ll);
    }
}
