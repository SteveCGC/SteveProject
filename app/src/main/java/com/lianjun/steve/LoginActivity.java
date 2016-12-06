package com.lianjun.steve;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.ProgressBar;

import com.lianjun.basic.mvp.MVPBaseActivity;
import com.lianjun.steve.presenter.LoginPresenter;
import com.lianjun.steve.presenter.role.ILoginView;

public class LoginActivity extends MVPBaseActivity<ILoginView,LoginPresenter> implements ILoginView, View.OnClickListener {

    private AppCompatEditText mEditTextUsername,mEditTextPassword;
    private ProgressBar mProgressBar;

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mEditTextUsername = (AppCompatEditText) this.findViewById(R.id.login_et_username);
        mEditTextPassword = (AppCompatEditText) this.findViewById(R.id.login_et_password);
        mProgressBar = (ProgressBar) this.findViewById(R.id.login_progress);
        this.findViewById(R.id.login_btn_confirm).setOnClickListener(this);
    }

    @Override
    public String getUserName() {
        return mEditTextUsername.getText().toString().trim();
    }

    @Override
    public String getPassWord() {
        return mEditTextPassword.getText().toString().trim();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.login_btn_confirm:
                mProgressBar.setVisibility(View.VISIBLE);
                break;
        }
    }
}
