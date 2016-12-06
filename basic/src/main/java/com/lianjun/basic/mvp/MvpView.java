package com.lianjun.basic.mvp;

/**
 * Created by Administrator on 2016/10/25.
 */

public interface MvpView {

    void showToast(String str);

    void showLoading();

    void hideLoading();
}
