package com.li.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import util.ToastUtil;

public class HandlerActivity extends AppCompatActivity {

    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
/*        //延时做某事情
        mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(HandlerActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }, 3000);*/

        //线程通信
        //这里写一个最基本的使用
        mHandler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                switch (msg.what)
                {
                    case 1:
                        ToastUtil.showMsg(HandlerActivity.this, "receive msg:1");
                        break;
                }
            }
        };

        new Thread() {
            @Override
            public void run() {
                super.run();
                Message ms = new Message();
                ms.what = 1;
                mHandler.sendMessage(ms);
            }
        }.start();

    }
}