package com.li.myapplication.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;


public class MyButton extends AppCompatButton {


    public MyButton(@NonNull Context context) {
        super(context);
    }

    public MyButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    //触摸事件，都是从这个方法开始往下分发
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d("MyButton", "--------dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                Log.d("MyButton", "--OnTouch_Callback--------");
                break;
        }
        return super.onTouchEvent(event); //return true,则不会向内传播，否则向内传播，比如activity也会触发touch事件回调
    }
}
