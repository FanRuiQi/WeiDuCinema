package com.bw.movie.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.bw.movie.precenter.IPrecenterImpl;
import com.bw.movie.view.IView;

import java.util.Map;

/**
 * Author: 范瑞旗
 * Date: 2019/1/23 16:08
 * Description: 基类Activity
 */

public abstract class BaseActivity extends AppCompatActivity implements IView{
    private IPrecenterImpl mPrecenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContent());
        initView();
        initData();
    }

    public void showShortToast(String text){
        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
    }

    public void setLog(String context,String dataString){
        Log.e(context,dataString);
    }

    public void setStartActivity(Class isClass,boolean isboolean){
        isStartActivity(isClass,isboolean);
    }

    public void isStartActivity(Class isClass, boolean isboolean) {
        if (isboolean){

        }else {

        }
    }

    public void doNetRequestData(String url, Map<String, String> map, Class clazz, String type){

        mPrecenter.startRequestData(url,map,clazz,type);
    }

    public abstract void initView();
    public abstract void initData();
    public abstract int getContent();


    @Override
    public void onSuccess(Object data) {
        success(data);
    }

    @Override
    public void onFail(String error) {
        fail(error);
    }

    public abstract void success(Object data);
    public abstract void fail(String error);
}
