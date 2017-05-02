package com.hxzs.mall.fragment.homefragment.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hxzs.hxzs.R;
import com.hxzs.mall.fragment.homefragment.ViewHolder.MyRecycleGrid;
import com.hxzs.mall.fragment.homefragment.bean.HomeBean;
import com.hxzs.mall.interfaces.RecycleViewclick;
import com.hxzs.mall.utils.Constants;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/4/26 21:00
 */
public class MyAdapter extends RecyclerView.Adapter<MyRecycleGrid>  {
    Context context;
    List<HomeBean.ResultBean.ChannelInfoBean> data;
    private RecycleViewclick mOnclic;

    public MyAdapter(Context context, List<HomeBean.ResultBean.ChannelInfoBean> data) {
        this.context = context;
        this.data = data;

    }

    @Override
    public MyRecycleGrid onCreateViewHolder(ViewGroup parent, int viewType) {
        //加载布局资源
        View inflate = LayoutInflater.from(context).inflate(R.layout.home_recycle_grid_item, null,false);
        MyRecycleGrid grid = new MyRecycleGrid(inflate);
        return grid;
    }

    @Override
    public void onBindViewHolder(MyRecycleGrid holder, final int position) {
        //赋值
        ImageLoader.getInstance().displayImage(Constants.ImageURL+data.get(position).getImage(),holder.mIv);
        holder.mTv.setText(data.get(position).getChannel_name()+"");
        holder.mLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnclic.clik(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setonclic(RecycleViewclick onclic) {
        mOnclic = onclic;
    }
}
