package com.hxzs.mall.fragment.homefragment.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hxzs.hxzs.R;
import com.hxzs.mall.fragment.homefragment.ViewHolder.XinPinRecycleViewHolder;
import com.hxzs.mall.fragment.homefragment.bean.HomeBean;
import com.hxzs.mall.interfaces.RecycleViewclick;
import com.hxzs.mall.utils.Constants;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/4/28 14:03
 */
public class XinPinAdapter extends RecyclerView.Adapter<XinPinRecycleViewHolder>{
    private final Context context;
    private final HomeBean.ResultBean result;
    private RecycleViewclick mOnclick;

    public XinPinAdapter(Context context, HomeBean.ResultBean result) {
        this.context = context;
        this.result = result;
    }


    @Override
    public XinPinRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.xinpin_recycle_item, null, false);
        XinPinRecycleViewHolder xinPinRecycleViewHolder = new XinPinRecycleViewHolder(inflate);
        return xinPinRecycleViewHolder;
    }

    @Override
    public void onBindViewHolder(XinPinRecycleViewHolder holder, final int position) {
        ImageLoader.getInstance().displayImage(Constants.ImageURL+result.getHot_info().get(position).getFigure(),holder.mxIv);
        holder.mxTv1.setText(result.getHot_info().get(position).getName());
        holder.mxTv2.setText("￥"+result.getHot_info().get(position).getCover_price());
        holder.mLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnclick.clik(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.getHot_info().size();
    }

    public void setonclick(RecycleViewclick onclick) {
        mOnclick = onclick;
    }
}
