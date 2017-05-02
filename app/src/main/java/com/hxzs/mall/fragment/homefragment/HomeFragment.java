package com.hxzs.mall.fragment.homefragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.hxzs.hxzs.R;
import com.hxzs.mall.base.BaseFragment;
import com.hxzs.mall.fragment.homefragment.Adapter.HomeRecycleAdapter;
import com.hxzs.mall.fragment.homefragment.bean.HomeBean;
import com.hxzs.mall.utils.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/4/24 20:05
 */
public class HomeFragment extends BaseFragment {


    private View view;
    private TextView mTv_sousuo;
    private TextView mTv_xiaoxi;
    private RecyclerView mRecycler;
    private ImageButton mImagebutton;
    private HomeBean.ResultBean mResult;

    @Override
    public View initview(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = View.inflate(mcontext, R.layout.fragment_home, null);
        //初始化控件
        mTv_sousuo = (TextView) view.findViewById(R.id.home_title_sousuo);
        mTv_xiaoxi = (TextView) view.findViewById(R.id.home_title_xiaoxi);
        mRecycler = (RecyclerView) view.findViewById(R.id.home_recycle);
        mImagebutton = (ImageButton) view.findViewById(R.id.home_imagebutton);
        //点击事件
        licenter();
        return view;
    }

    private void licenter() {

        mImagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //使recycleview回到下标是0的位置
                mRecycler.scrollToPosition(0);

            }
        });
        mTv_sousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mcontext,"搜索", Toast.LENGTH_SHORT).show();
            }
        });

        mTv_xiaoxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mcontext,"消息", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void initdata() {
        //OkHttpUtils请求框架       不用考虑anr
        okhttpgetdata();
    }

    private void okhttpgetdata() {
        //找到封装的url
        String url = Constants.URL;
        //OkHttpUtils的get请求
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    //请求失败时回调
                    @Override
                    public void onError(Call call, Exception e, int i) {
                        Toast.makeText(mcontext,"网络无连接",Toast.LENGTH_SHORT).show();
                    }
                    //请求成功时返回
                    @Override
                    public void onResponse(String s, int i) {
                        Toast.makeText(mcontext,"网络请求成功",Toast.LENGTH_SHORT).show();
                        //解析json数据
                        jsonjiesi(s);
                    }
                });

    }

    public void jsonjiesi(String json) {
        //fastjaon解析数据
        HomeBean homeBean = JSON.parseObject(json, HomeBean.class);
        mResult = homeBean.getResult();
        //判断 有没有数据
        if(mResult !=null){
            HomeRecycleAdapter adapter = new HomeRecycleAdapter(mcontext, mResult);
            mRecycler.setLayoutManager(new GridLayoutManager(mcontext,1));
            mRecycler.setAdapter(adapter);
        }else{
            Toast.makeText(mcontext,"暂无展示的数据",Toast.LENGTH_SHORT).show();
        }

    }
}
