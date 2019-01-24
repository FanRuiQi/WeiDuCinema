package com.bw.movie.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public abstract class BaseFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(getContent(), container, false);

        initView(view);
        initData(view);
        return view;
    }
    public void setToast(String dataString){
        Toast.makeText(getActivity(),dataString,Toast.LENGTH_SHORT).show();
    }
    public void setLog(String context,String dataString){
        Log.e(context,dataString);
    }
    public abstract void initView(View view);
    public abstract void initData(View view);
    public abstract int getContent();
}
