package com.lianjun.steve.presenter.role;

import android.content.Context;

import com.lianjun.basic.mvp.MvpView;

/**
 * Created by Administrator on 2016/10/12.
 */

public interface ILoginView extends MvpView {

    String getUserName();

    String getPassWord();

    Context getContext();
}
