package com.lianjun.basic.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.lianjun.basic.R;
import com.lianjun.basic.utils.ScreenUtils;
import com.lianjun.basic.widget.LoadingView;

/**
 * author Changgc on 2016/3/30.
 * email  changgongcai@126.com
 */
public abstract class CommonActivity extends FragmentActivity {

    protected LoadingView mLoadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
        if (null == mLoadingView) {
            mLoadingView = new LoadingView(this);
            int size = ScreenUtils.dp2px(this, 50);
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(size, size);
            params.gravity = Gravity.CENTER;
            mLoadingView.setLayoutParams(params);
            mLoadingView.dismissLoading();
            addContentView(mLoadingView, params);
        }

        initData();
        initView();
    }

    protected abstract int getLayoutResource();

    protected abstract void initData();

    protected abstract void initView();

    protected void initTitleBar() {
    }
    private TextView titleTextView;

    protected void setTitleText(String title) {
        if (titleTextView==null){
            titleTextView = (TextView) this.findViewById(R.id.title_bar_main_heading);
        }
        if (titleTextView!=null){
            titleTextView.setText(title);
        }

    }

    private ImageButton backImageButton;

    protected void setBackButtonVisibility(boolean vivibility){
        if (backImageButton==null){
            backImageButton = (ImageButton) this.findViewById(R.id.title_bar_back);
        }
        if (backImageButton!=null){
            if (vivibility){
                backImageButton.setVisibility(View.VISIBLE);
            }else{
                backImageButton.setVisibility(View.GONE);
            }
        }
    }

    public void goBack(View view){
        finish();
    }
}
