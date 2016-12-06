package com.lianjun.basic.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.lianjun.basic.R;

/**
 * Created by Administrator on 2016/4/12.
 */
public class LoadingView extends FrameLayout {

    private ImageView loadingImageView;

    private RotateAnimation rotateAnimation;

    public LoadingView(Context context) {
        super(context);
        initView(context);
    }

    public LoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public LoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){
        View view = inflate(context, R.layout.view_loading, this);
        loadingImageView = (ImageView) view.findViewById(R.id.icon_loading);
        setupAnim();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    private void setupAnim(){
        rotateAnimation = new RotateAnimation(0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(500);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setRepeatMode(Animation.START_ON_FIRST_FRAME);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        loadingImageView.setAnimation(rotateAnimation);
    }

    private void startAnim(){
        if (null == rotateAnimation) return;
        rotateAnimation.start();
    }

    private void stopAnim(){
        if (null == rotateAnimation) return;
        rotateAnimation.cancel();
    }

    public void showLoading() {
        startAnim();
        setVisibility(VISIBLE);
    }


    public void dismissLoading() {
        stopAnim();
        setVisibility(GONE);
    }
}
