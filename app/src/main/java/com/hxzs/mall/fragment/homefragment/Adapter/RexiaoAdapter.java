package com.hxzs.mall.fragment.homefragment.Adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hxzs.hxzs.R;
import com.hxzs.mall.fragment.homefragment.ViewHolder.RerecycleViewholder;
import com.hxzs.mall.fragment.homefragment.bean.HomeBean;
import com.hxzs.mall.interfaces.RecycleViewclick;
import com.hxzs.mall.utils.Constants;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/4/27 19:54
 */
public class RexiaoAdapter extends RecyclerView.Adapter<RerecycleViewholder> {
    private Context context;
    private HomeBean.ResultBean result;
    private RecycleViewclick mOnclick;

    @Override
    public RerecycleViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.rexiao_item, null);
        RerecycleViewholder rerecycleViewholder = new RerecycleViewholder(inflate);
        return rerecycleViewholder;
    }

    @Override
    public void onBindViewHolder(RerecycleViewholder holder, final int position) {
        ImageLoader.getInstance().displayImage(Constants.ImageURL+result.getSeckill_info().getList().get(position).getFigure(),holder.mIv);
        holder.mTv1.setText(result.getSeckill_info().getList().get(position).getOrigin_price()+"");
        holder.mTv2.setText(result.getSeckill_info().getList().get(position).getCover_price()+"");
        holder.mTv2.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
        holder.mLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnclick.clik(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.getSeckill_info().getList().size();
    }

    public void setdata(Context context, HomeBean.ResultBean result) {
        this.context = context;
        this.result = result;
    }

    public void setonclick(RecycleViewclick onclick) {
        this.mOnclick = onclick;
    }
}
