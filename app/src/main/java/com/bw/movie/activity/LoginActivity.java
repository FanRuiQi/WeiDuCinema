package com.bw.movie.activity;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;

import butterknife.OnClick;

/**
 * Author: 范瑞旗
 * Date: 2019/1/23 16:08
 * Description: 登录页
 */
public class LoginActivity extends BaseActivity{


    @Override
    public void initView() {

    }

    @Override
    public void initData() {


    }

    @Override
    public int getContent() {
        return R.layout.activity_login;
    }

    @OnClick(R.id.login_btn_login)
    public void onLoginBtnClickListener(){

    }


    @Override
    public void success(Object data) {

    }

    @Override
    public void fail(String error) {

    }
}
