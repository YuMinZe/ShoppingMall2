package com.hxzs.mall.fragment.community;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hxzs.mall.base.BaseFragment;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/4/24 20:05
 */
public class CommunityFragment extends BaseFragment {

    private TextView mText;

    @Override
    public View initview(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mText = new TextView(mcontext);
        return mText;
    }

    @Override
    public void initdata() {
        mText.setText("CommunityFragment");
    }
}
