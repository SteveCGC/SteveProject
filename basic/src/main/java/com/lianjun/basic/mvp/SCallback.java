package com.lianjun.basic.mvp;

import android.text.TextUtils;

import com.lianjun.basic.api.StatusCode;
import com.lianjun.basic.bean.BaseBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/10/25.
 */

public abstract class SCallback<T extends BaseBean> implements Callback<T> {

    private BasePresenter presenter;

    public SCallback(BasePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response != null) {
            T body = response.body();
            if (body != null) {
                String status = body.getStatus();
                if (!TextUtils.isEmpty(status)) {
                    if (StatusCode.SUCCESS.equals(status)) {//成功
                        onSuccess(body);
                    } else {
                        String message = body.getMessage();
                        if (!TextUtils.isEmpty(message)) {
                            presenter.showToast(message);
                        } else {
                            presenter.showToast("message为空");
                        }
                    }
                } else {
                    presenter.showToast("status为空");
                }
            } else {
                presenter.showToast("body为空");
            }
        } else {
            presenter.showToast("返回结果为空");
        }
    }

    public abstract void onSuccess(T response);

    @Override
    public void onFailure(Call<T> call, Throwable t) {

    }
}
