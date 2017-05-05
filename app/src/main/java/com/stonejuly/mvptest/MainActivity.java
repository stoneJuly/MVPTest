package com.stonejuly.mvptest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.stonejuly.mvptest.bean.User;
import com.stonejuly.mvptest.presenter.UserLoginPresenter;
import com.stonejuly.mvptest.view.IUserLoginView;

public class MainActivity extends AppCompatActivity implements IUserLoginView{
    private EditText mEtUserName;
    private EditText mEtPassWord;
    private Button mBtnLogin;
    private Button mBtnClear;
    private ProgressBar mPbLoading;

    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mEtUserName = (EditText) findViewById(R.id.et_username);
        mEtPassWord = (EditText) findViewById(R.id.et_password);
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnClear = (Button) findViewById(R.id.btn_clear);
        mPbLoading = (ProgressBar) findViewById(R.id.pb_loading);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.login();
            }
        });
        mBtnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.clear();
            }
        });
    }

    @Override
    public String getUserName() {
        return mEtUserName.getText().toString();
    }

    @Override
    public String getPassWord() {
        return mEtPassWord.getText().toString();
    }

    @Override
    public void clearUserName() {
        mEtUserName.setText("");
    }

    @Override
    public void clearPassWord() {
        mEtPassWord.setText("");
    }

    @Override
    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void skipNextPage(User user) {
        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailReason() {
        Toast.makeText(this, "login failed", Toast.LENGTH_SHORT).show();
    }
}
