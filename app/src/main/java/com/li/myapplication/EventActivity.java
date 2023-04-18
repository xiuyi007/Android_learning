package com.li.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.camera2.params.TonemapCurve;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.li.myapplication.widget.MyButton;

import util.ToastUtil;

//设置多个监听，只有最后一个设置的会生效，在layout中设置的是最先监听的，相当于优先级最低
public class EventActivity extends AppCompatActivity implements View.OnClickListener{
    //xml onclick方式，背后其实就是java写的onclick方法。
    public void show(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_event:
                ToastUtil.showMsg(EventActivity.this, "xml onclick");
        }
    }

    private Button mBtnEvent;
    private MyButton btnMy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mBtnEvent = findViewById(R.id.btn_event);
        btnMy = findViewById(R.id.btn_my);
        btnMy.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        Log.d("Listener", "---onTouch-----");
                        break;
                }
                //监听器的优先级高于回调，也就是高于控件本身的onTouchEvent;
                return false;
            }
        });
        //内部类方式
//        mBtnEvent.setOnClickListener(new OnClickListener());
        //匿名内部类方式
//        mBtnEvent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ToastUtil.showMsg(EventActivity.this, "匿名内部类");
//            }
//        });
        //通过事件源所在的类实现
//        mBtnEvent.setOnClickListener(this);
        //通过外部类实现，不想写了，感觉跟内部类写法差不多，就写在外面罢了
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                Log.d("MyButton", "--OnTouch in activity");
                break;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_event:
                ToastUtil.showMsg(EventActivity.this, "事件源所在类");
        }
    }

    class OnClickListener implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            ToastUtil.showMsg(EventActivity.this, "内部类方式");
        }
    }

}