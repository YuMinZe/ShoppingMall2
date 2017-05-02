package com.hxzs.mall.fragment.homefragment.ViewHolder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.hxzs.hxzs.R;
import com.hxzs.mall.fragment.homefragment.Adapter.RexiaoAdapter;
import com.hxzs.mall.fragment.homefragment.activity.ParticularsActivity;
import com.hxzs.mall.fragment.homefragment.bean.EvenBusBean;
import com.hxzs.mall.fragment.homefragment.bean.HomeBean;
import com.hxzs.mall.interfaces.RecycleViewclick;

import org.greenrobot.eventbus.EventBus;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/4/27 19:48
 */
public class RexiaoViewHolder extends RecyclerView.ViewHolder {

    private final RecyclerView mRecyclerView;

    public RexiaoViewHolder(View itemView) {
        super(itemView);
        mRecyclerView = (RecyclerView) itemView.findViewById(R.id.home_recycle_rexiao);
    }

    public void setdata(final Context context, final HomeBean.ResultBean result) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        RexiaoAdapter adapter = new RexiaoAdapter();
        adapter.setdata(context,result);
        mRecyclerView.setAdapter(adapter);
        adapter.setonclick(new RecycleViewclick() {
            @Override
            public void clik(int position) {

                EvenBusBean bean = new EvenBusBean(result.getSeckill_info().getList().get(position).getName(),result.getSeckill_info().getList().get(position).getFigure(),result.getSeckill_info().getList().get(position).getCover_price());
                EventBus.getDefault().postSticky(bean);
                Intent in = new Intent(context, ParticularsActivity.class);
                context.startActivity(in);

            }
        });
    }
}
