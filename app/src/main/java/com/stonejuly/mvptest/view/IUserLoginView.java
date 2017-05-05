package com.stonejuly.mvptest.view;


import com.stonejuly.mvptest.bean.User;

public interface IUserLoginView {
    String getUserName();
    String getPassWord();
    void clearUserName();
    void clearPassWord();
    void showLoading();
    void hideLoading();
    void skipNextPage(User user);
    void showFailReason();
}
