package com.hxzs.mall.fragment.homefragment.ViewHolder;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hxzs.hxzs.R;
import com.hxzs.mall.fragment.homefragment.activity.WebViewActivity;
import com.hxzs.mall.fragment.homefragment.bean.HomeBean;
import com.hxzs.mall.utils.Constants;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/4/27 13:55
 */
public class ViewPagerViewHoler extends RecyclerView.ViewHolder {

    private final ViewPager mViewPager;
    private HomeBean.ResultBean result;
    private Context mcontext;

    public ViewPagerViewHoler(View itemView) {
        super(itemView);
        mViewPager = (ViewPager) itemView.findViewById(R.id.home_recycle_viewpager);
    }

    public void setdata(HomeBean.ResultBean result, Context context) {
        this.result = result;
        this.mcontext = context;
        mViewPager.setAdapter(new MyPagerAdapter());

    }

    public  class MyPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return result.getAct_info().size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            ImageView iv = new ImageView(mcontext);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);

            ImageLoader.getInstance().displayImage(Constants.ImageURL+result.getAct_info().get(position).getIcon_url(),iv);
            container.addView(iv);
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(mcontext, WebViewActivity.class);
                    in.putExtra("flag",Constants.ImageURL+result.getAct_info().get(position).getUrl());
                    mcontext.startActivity(in);
                }
            });
            return iv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
