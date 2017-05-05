package com.stonejuly.mvptest.presenter;


import android.os.Handler;

import com.stonejuly.mvptest.bean.User;
import com.stonejuly.mvptest.biz.IUserBiz;
import com.stonejuly.mvptest.biz.OnLoginListener;
import com.stonejuly.mvptest.biz.UserBiz;
import com.stonejuly.mvptest.view.IUserLoginView;

public class UserLoginPresenter {
    private IUserBiz userBiz;
    private IUserLoginView loginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView loginView) {
        this.userBiz = new UserBiz();
        this.loginView = loginView;

    }
    public void login() {
        loginView.showLoading();
        userBiz.login(loginView.getUserName(), loginView.getPassWord(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.hideLoading();
                        loginView.skipNextPage(user);
                    }
                });
            }

            @Override
            public void loginFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.hideLoading();
                        loginView.showFailReason();
                    }
                });
            }
        });
    }
    public void clear() {
        loginView.clearUserName();
        loginView.clearPassWord();
    }
}
