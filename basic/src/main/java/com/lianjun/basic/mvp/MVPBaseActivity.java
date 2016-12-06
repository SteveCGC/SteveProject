package com.lianjun.basic.mvp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.lianjun.basic.R;
import com.lianjun.basic.app.SharePreferenceManager;
import com.lianjun.basic.utils.ScreenUtils;
import com.lianjun.basic.widget.LoadingView;

/**
 * Created by Administrator on 2016/6/1.
 */
public abstract class MVPBaseActivity<V, T extends BasePresenter<V>> extends AppCompatActivity {

    protected LoadingView mLoadingView;
    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建presenter
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除关联
        mPresenter.detachView();
    }

    protected abstract T createPresenter();

    protected abstract int getLayoutResource();

    protected abstract void initData();

    protected abstract void initView();

    private TextView titleTextView;

    protected void setTitleText(String title) {
        if (titleTextView == null) {
            titleTextView = (TextView) this.findViewById(R.id.title_bar_main_heading);
        }
        if (titleTextView != null) {
            titleTextView.setText(title);
        }

    }

    private ImageButton backImageButton;

    protected void setBackButtonVisibility(boolean vivibility) {
        if (backImageButton == null) {
            backImageButton = (ImageButton) this.findViewById(R.id.title_bar_back);
        }
        if (backImageButton != null) {
            if (vivibility) {
                backImageButton.setVisibility(View.VISIBLE);
            } else {
                backImageButton.setVisibility(View.GONE);
            }
        }
    }

    public void goBack(View view) {
        finish();
    }

    protected SwipeRefreshLayout mSwipeRefreshLayout;

//    private ProgressDialog mProgressDialog;

    public void showLoadError() {
        showToast("请检查您的网络连接");
    }

    public void showToast(String str) {
        Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
    }

    public void showLoading() {
//        if (null == mLoadingView) return;
//        mLoadingView.showLoading();
        if (mSwipeRefreshLayout!=null){
            mSwipeRefreshLayout.setRefreshing(true);
        }
    }

    public void hideLoading() {
//        if (null == mLoadingView) return;
//        mLoadingView.dismissLoading();
        if (mSwipeRefreshLayout!=null&&mSwipeRefreshLayout.isRefreshing()){
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    protected ImageButton imageButtonBack, imageButtonAdd, imageButtonSearch,imageButtonMenu;

    protected void showBackImage(boolean isShow) {
        if (imageButtonBack == null) {
            imageButtonBack = (ImageButton) this.findViewById(com.lianjun.basic.R.id.title_bar_back);
        }
        if (imageButtonBack != null) {
            imageButtonBack.setVisibility(isShow ? View.VISIBLE : View.GONE);
        }
    }

    protected void showAddImage(boolean isShow) {
        if (imageButtonAdd == null) {
            imageButtonAdd = (ImageButton) this.findViewById(com.lianjun.basic.R.id.title_bar_add);
        }
        if (imageButtonAdd != null) {
            imageButtonAdd.setVisibility(isShow ? View.VISIBLE : View.GONE);
        }
    }

    protected void showSearchImage(boolean isShow) {
        if (imageButtonSearch == null) {
            imageButtonSearch = (ImageButton) this.findViewById(com.lianjun.basic.R.id.title_bar_search);
        }
        if (imageButtonSearch != null) {
            imageButtonSearch.setVisibility(isShow ? View.VISIBLE : View.GONE);
        }
    }

    protected void showMenuImage(boolean isShow) {
        if (imageButtonMenu == null) {
            imageButtonMenu = (ImageButton) this.findViewById(com.lianjun.basic.R.id.title_bar_menu);
        }
        if (imageButtonMenu != null) {
            imageButtonMenu.setVisibility(isShow ? View.VISIBLE : View.GONE);
        }
    }


    public String getUserId(){
        return SharePreferenceManager.getString(this,SharePreferenceManager.KEY_EMPLOYEE_ID,"");
    }
    
    public String getStoreCd(){
        return SharePreferenceManager.getString(this, SharePreferenceManager.KEY_STORE_CD,"");
    }

    protected void setTextViewText(int tvId,String text){
        TextView tv  = (TextView) findViewById(tvId);
        if (tv!=null&& !TextUtils.isEmpty(text)){
            tv.setText(text);
        }
    }
}
