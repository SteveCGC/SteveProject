package com.lianjun.basic.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * author Changgc on 2016/3/30.
 * email  changgongcai@126.com
 */
public abstract class BaseFragment extends Fragment {

    protected View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView ==null)
            rootView = inflater.inflate(getLayoutResource(), container, false);
//        ButterKnife.bind(this, rootView);

        ViewGroup parentView = (ViewGroup) rootView.getParent();
        if (parentView !=null) parentView.removeView(rootView);

//        ButterKnife.bind(this, rootView);
        initData();
        return rootView;
    }

    protected abstract int getLayoutResource();

    protected abstract void initData();

    public String getName() {
        return BaseFragment.class.getName();
    }


}
