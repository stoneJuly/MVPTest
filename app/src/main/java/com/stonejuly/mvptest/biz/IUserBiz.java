package com.stonejuly.mvptest.biz;


public interface IUserBiz {
    void login(String userName, String passWord, OnLoginListener loginListener);
}
