package com.stonejuly.mvptest.biz;

import com.stonejuly.mvptest.bean.User;

public class UserBiz implements IUserBiz {
    @Override
    public void login(final String userName, final String passWord, final OnLoginListener loginListener) {
        //模拟登陆操作
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //验证用户数据
                if("stoneJuly".equals(userName) && "666".equals(passWord)) {
                    User user = new User();
                    user.setUsername(userName);
                    user.setPassword(passWord);
                    loginListener.loginSuccess(user);
                }else {
                    loginListener.loginFailed();
                }
            }
        }.start();
    }
}
