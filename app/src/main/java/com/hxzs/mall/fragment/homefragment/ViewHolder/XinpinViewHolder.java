package com.hxzs.mall.fragment.homefragment.ViewHolder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.hxzs.hxzs.R;
import com.hxzs.mall.fragment.homefragment.Adapter.XinPinAdapter;
import com.hxzs.mall.fragment.homefragment.activity.ParticularsActivity;
import com.hxzs.mall.fragment.homefragment.bean.EvenBusBean;
import com.hxzs.mall.fragment.homefragment.bean.HomeBean;
import com.hxzs.mall.interfaces.RecycleViewclick;

import org.greenrobot.eventbus.EventBus;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/4/28 13:59
 */
public class XinpinViewHolder extends RecyclerView.ViewHolder {

    private final RecyclerView mRecyclerView;

    public XinpinViewHolder(View itemView) {
        super(itemView);
        mRecyclerView = (RecyclerView) itemView.findViewById(R.id.home_recycle_xinpin);
    }

    public void setdata(final Context context, final HomeBean.ResultBean result) {
        XinPinAdapter adapter = new  XinPinAdapter(context,result);
        mRecyclerView.setLayoutManager(new GridLayoutManager(context,2));
        mRecyclerView.setAdapter(adapter);

        adapter.setonclick(new RecycleViewclick() {
            @Override
            public void clik(int position) {
                EvenBusBean bean = new EvenBusBean(result.getHot_info().get(position).getName(),result.getHot_info().get(position).getFigure(),result.getHot_info().get(position).getCover_price());
                EventBus.getDefault().postSticky(bean);
                Intent in = new Intent(context, ParticularsActivity.class);
                context.startActivity(in);
            }
        });
    }
}
