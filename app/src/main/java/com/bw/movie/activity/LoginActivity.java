package com.bw.movie.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bw.movie.Apis;
import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.general.activity.HomeActivity;
import com.bw.movie.precenter.IPrecenterImpl;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Author: 范瑞旗
 * Date: 2019/1/23 16:08
 * Description: 登录页
 */
public class LoginActivity extends BaseActivity{

    @BindView(R.id.login_edit_phone)   //手机号
            TextView mTextView_phone;

    @BindView(R.id.login_edit_pwd)     //密码
            TextView mTextView_pwd;

    @BindView(R.id.login_checkbox_rememberPwd)  //记住密码
            CheckBox mCheckBox_rememberPwd;

    @BindView(R.id.login_checkbox_autoLogin)  //记住密码
            CheckBox mCheckBox_autoLogin;

    @BindView(R.id.login_text_register)    //注册
            TextView mTextView_register;

    @BindView(R.id.login_btn_login)          //登录按钮
            Button mButton_login;
    private boolean b=true;
    private IPrecenterImpl mIPrecenter;
    private SharedPreferences mPreferences;

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

        ButterKnife.bind(this);

        mIPrecenter = new IPrecenterImpl(this);

        mPreferences = getSharedPreferences("swl", MODE_PRIVATE);

        boolean check = mPreferences.getBoolean("check", false);
        boolean auto = mPreferences.getBoolean("auto", false);
        String String_phone = mPreferences.getString("phone", null);
        String String_pwd = mPreferences.getString("pwd", null);
        if (check){
            mTextView_phone.setText(String_phone);
            mTextView_pwd.setText(String_pwd);
            mCheckBox_rememberPwd.setChecked(true);
        }
        if (auto){
            startActivity(new Intent(LoginActivity.this, com.bw.movie.general.activity.HomeActivity.class));
        }

    }

    @Override
    public int getContent() {
        return R.layout.activity_login;
    }

    @OnClick(R.id.login_btn_login)
    public void onLoginButtonClickListener(){  //登录按钮监听

        String phone = mTextView_phone.getText().toString().trim();
        String pwd = mTextView_pwd.getText().toString().trim();

        if (phone.isEmpty()||pwd.isEmpty()){

            showShortToast(R.string.login_phone_pwd_isEmpty+"");
        }else {

            Map<String, String> map = new HashMap<>();
            map.put("phone",phone);
            map.put("pwd",pwd);

            doNetRequestData(Apis.URL_LOGIN,map,LoginBean.class,"post");

        }
    }


    @Override
    public void success(Object data) {

        LoginBean loginBean = (LoginBean) data;
        String message = loginBean.getMessage();
        if (message.equals("登录成功")){
            if (mCheckBox_rememberPwd.isChecked()){  //保存账号密码
                SharedPreferences.Editor edit = mPreferences.edit();
                edit.putString("phone",mTextView_phone.getText().toString().trim());
                edit.putString("pwd",mTextView_pwd.getText().toString().trim());
                edit.putBoolean("check",true);
                edit.commit();

            }else {

            }

            if (mCheckBox_autoLogin.isChecked()){  //自动登录
                SharedPreferences.Editor edit = mPreferences.edit();
                edit.putBoolean("auto",true);
                edit.commit();

            }else {

            }
            LoginBean.ResultBean beanResult = loginBean.getResult();
            String sessionId = beanResult.getSessionId();
            int userId = beanResult.getUserId();
            String headPic = beanResult.getUserInfo().getHeadPic();
            String nickName = beanResult.getUserInfo().getNickName();

            SharedPreferences.Editor edit = mPreferences.edit();  //保存用户的sessionId

            edit.putString("sessionId",sessionId);
            edit.putString("userId",userId+"");
            edit.putString("headPic",headPic);
            edit.putString("nickName",nickName);
            edit.commit();

            startActivity(new Intent(LoginActivity.this,HomeActivity.class));
            //Toast.makeText(MainActivity.this,"登录成功!",Toast.LENGTH_SHORT).show();
            showShortToast(R.string.login_success_toast+"");
        }else {
            showShortToast(R.string.login_fail_toast+"");
        }

    }

    @Override
    public void fail(String error) {
        showShortToast(R.string.not_NetWork+"");
    }
}
