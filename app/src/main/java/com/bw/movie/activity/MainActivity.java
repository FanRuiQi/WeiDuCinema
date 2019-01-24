package com.bw.movie.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bw.movie.R;

public class MainActivity extends AppCompatActivity {  //欢迎页

    private int t=3;

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            t=0;
            if (t==0){
                handler.removeMessages(1);
                startActivity(new Intent(MainActivity.this,GuideActivity.class));

            }
            handler.sendEmptyMessageDelayed(1,2000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        handler.sendEmptyMessageDelayed(1,2000);

    }

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeMessages(1);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeMessages(1);
    }
}
