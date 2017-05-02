package com.hxzs.mall.fragment.homefragment.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hxzs.hxzs.R;
import com.hxzs.mall.fragment.homefragment.ViewHolder.TuijianRecycleViewHolder;
import com.hxzs.mall.fragment.homefragment.bean.HomeBean;
import com.hxzs.mall.interfaces.RecycleViewclick;
import com.hxzs.mall.utils.Constants;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/4/28 13:32
 */
public class TuijianAdapter extends RecyclerView.Adapter<TuijianRecycleViewHolder> {
    private final Context context;
    private final HomeBean.ResultBean result;
    private RecycleViewclick mOncliect;

    public TuijianAdapter(Context context, HomeBean.ResultBean result) {
        this.context = context;
        this.result = result;
    }

    @Override
    public TuijianRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.tuijian_recycle_item, null);
        TuijianRecycleViewHolder tuijianRecycleViewHolder = new TuijianRecycleViewHolder(inflate);
        return tuijianRecycleViewHolder;
    }

    @Override
    public void onBindViewHolder(TuijianRecycleViewHolder holder, final int position) {
        ImageLoader.getInstance().displayImage(Constants.ImageURL+result.getRecommend_info().get(position).getFigure(),holder.mIv);
        holder.mTv1.setText(result.getRecommend_info().get(position).getName());
        holder.mTv2.setText("￥"+result.getRecommend_info().get(position).getCover_price());
        holder.mLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOncliect.clik(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.getRecommend_info().size();
    }

    public void setoncliect(RecycleViewclick oncliect) {
        mOncliect = oncliect;
    }
}
