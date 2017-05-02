package com.hxzs.mall.fragment.homefragment.ViewHolder;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import android.widget.Toast;

import com.hxzs.hxzs.R;
import com.hxzs.mall.fragment.homefragment.Adapter.MyAdapter;
import com.hxzs.mall.fragment.homefragment.bean.HomeBean;
import com.hxzs.mall.interfaces.RecycleViewclick;
import com.hxzs.mall.utils.Constants;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/4/26 20:25
 */
public class GridViewHolder extends RecyclerView.ViewHolder {


    private final RecyclerView mRecyclerView;


    public GridViewHolder(View itemView) {
        super(itemView);
        mRecyclerView = (RecyclerView) itemView.findViewById(R.id.home_recycle_gridview);

    }

    public void setdata(List<HomeBean.ResultBean.ChannelInfoBean> channel_info, final Context context) {
        //设置recycleview的布局管理器为5列
        mRecyclerView.setLayoutManager(new GridLayoutManager(context,5));
        //适配器
        MyAdapter adapter = new MyAdapter(context,channel_info);
        mRecyclerView.setAdapter(adapter);
        adapter.setonclic(new RecycleViewclick() {
            @Override
            public void clik(int position) {
                Toast.makeText(context,""+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
