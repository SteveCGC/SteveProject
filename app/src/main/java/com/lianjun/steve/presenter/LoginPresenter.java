package com.lianjun.steve.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.lianjun.basic.app.SharePreferenceManager;
import com.lianjun.basic.bean.LoginResult;
import com.lianjun.basic.bean.User;
import com.lianjun.basic.mvp.BasePresenter;
import com.lianjun.basic.mvp.SCallback;
import com.lianjun.steve.presenter.role.ILoginView;

import retrofit2.Call;

/**
 * Created by Administrator on 2016/10/12.
 */

public class LoginPresenter extends BasePresenter<ILoginView> {

    public void login() {
        String username = getView().getUserName();
        String password = getView().getPassWord();
        if (TextUtils.isEmpty(username)) {
            showToast("工号不能为空");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            showToast("密码不能为空");
            return;
        }
        User u = new User();
        u.setPassWord(password);
        u.setUserName(username);

        Call<LoginResult> resultCall = getService().login(u);
        showLoading();
        resultCall.enqueue(new SCallback<LoginResult>(this) {
            @Override
            public void onSuccess(LoginResult response) {
                SharedPreferences sharedPreferences = getView().getContext().getSharedPreferences(SharePreferenceManager.SP_CONFIG_NAME, Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(SharePreferenceManager.KEY_USER_ID, response.getContent().getUserId());
                edit.putString(SharePreferenceManager.KEY_EMP_POSITION, response.getContent().getEmpMpa().getPosition());
                edit.putString(SharePreferenceManager.KEY_STORE_CD, response.getContent().getEmpMpa().getE_STORE_CD());
                edit.putString(SharePreferenceManager.KEY_USER_REAL_NAME, response.getContent().getEmpMpa().getE_NAME());
                edit.putString(SharePreferenceManager.KEY_EMPLOYEE_ID, response.getContent().getEmpMpa().getE_EMPLOYEE_ID());
                edit.putString(SharePreferenceManager.KEY_USER_PASSWORD, getView().getPassWord());
            }
        });
    }

}
