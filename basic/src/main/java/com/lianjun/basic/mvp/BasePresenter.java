package com.lianjun.basic.mvp;

import com.lianjun.basic.api.ApiService;
import com.lianjun.basic.api.ServiceFactory;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2016/6/1.
 */
public class BasePresenter<T extends MvpView> {

    public BasePresenter() {
    }

    //当内存不足的时候可释放内存
    public WeakReference<T> mViewRef;
    public WeakReference<ApiService> mServiceRef;

    /**
     * bind P with V
     *
     * @param view
     */
    public void attachView(T view) {
        mViewRef = new WeakReference<T>(view);
        ApiService mMainService = ServiceFactory.getInstance().getApiService();
        mServiceRef = new WeakReference<>(mMainService);

    }

    /**
     * 解除关联
     */
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }

        if (mServiceRef != null) {
            mServiceRef.clear();
            mServiceRef = null;
        }

    }

    protected T getView() {
        return mViewRef.get();
    }

    protected ApiService getService() {
        return mServiceRef.get();
    }

    protected void showToast(String str){
        T mView = getView();
        if(mView!=null){
            mView.showToast(str);
        }
    }

    protected void showLoading(){
        T mView = getView();
        if(mView!=null){
            mView.showLoading();
        }
    }

    protected void hideLoading(){
        T mView = getView();
        if(mView!=null){
            mView.hideLoading();
        }
    }
}
