package com.hxzs.mall.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.RadioGroup;

import com.hxzs.hxzs.R;
import com.hxzs.mall.base.BaseFragment;
import com.hxzs.mall.fragment.community.CommunityFragment;
import com.hxzs.mall.fragment.homefragment.HomeFragment;
import com.hxzs.mall.fragment.shoppingcart.ShoppingCartFragment;
import com.hxzs.mall.fragment.type.TypeFragment;
import com.hxzs.mall.fragment.user.UserFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.main_group)
    RadioGroup mMainGroup;

    private List<BaseFragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //初始化fragment
        initfragment();
        //默认首页选中
        mMainGroup.check(R.id.main_home);
        RePlacefm(list.get(0));
    }

    private void initfragment() {
        list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new TypeFragment());
        list.add(new CommunityFragment());
        list.add(new ShoppingCartFragment());
        list.add(new UserFragment());

    }
    private int position;

    @OnClick({R.id.main_home, R.id.main_type, R.id.main_community, R.id.main_cart, R.id.main_user})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_home:
                position = 0;
                mMainGroup.check(R.id.main_home);
                break;
            case R.id.main_type:
                position = 1;
                mMainGroup.check(R.id.main_type);
                break;
            case R.id.main_community:
                position = 2;
                mMainGroup.check(R.id.main_community);
                break;
            case R.id.main_cart:
                position = 3;
                mMainGroup.check(R.id.main_cart);
                break;
            case R.id.main_user:
                position = 4;
                mMainGroup.check(R.id.main_user);
                break;
        }
        BaseFragment baseFragment = list.get(position);
        RePlacefm(baseFragment);
    }
    private Fragment mContent;
    private void RePlacefm(BaseFragment baseFragment) {
        //获得fragment的管理器
        FragmentManager fragmentManager = getSupportFragmentManager();
        //开启fragment事物
        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        //替换FrameLayout布局,提交
//        transaction.replace(R.id.main_frame,baseFragment).commit();

        //隐藏和显示
        if(mContent!=null){
            //隐藏上个fragment
            transaction.hide(mContent);
        }
        if(!baseFragment.isAdded()){
            //如果还没有添加则添加fragment
            transaction.add(R.id.main_frame,baseFragment);
        }
        //显示
        transaction.show(baseFragment);
        mContent = baseFragment;
        //提交
        transaction.commit();

    }
}
