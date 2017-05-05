package com.stonejuly.mvptest.biz;


import com.stonejuly.mvptest.bean.User;

public interface OnLoginListener {
    void loginSuccess(User user);
    void loginFailed();
}
