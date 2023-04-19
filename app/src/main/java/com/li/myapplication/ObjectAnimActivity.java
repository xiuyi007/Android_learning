package com.li.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.time.temporal.ValueRange;

public class ObjectAnimActivity extends AppCompatActivity {

    private TextView mTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_anim);

        mTv = findViewById(R.id.tv);
/*
        mTv.animate().translationYBy(500).setDuration(2000).start(); //通常高度不用写死，就可以是xxx.getHeight这种感觉
        mTv.animate().alpha(0).setDuration(2000).start();
*/

/*        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //实际的动画值
                Log.d("anm", animation.getAnimatedValue() + "");
                //动画的进度0-1
                Log.d("anm", animation.getAnimatedFraction() + "");
                //比如可以做，动画进行到40的时候做xxx
            }
        });*/

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mTv, "translationY", 0, 500, 200, 300); //从0到500到200到300
        objectAnimator.setDuration(2000).start();//这个也可以加监听,这里不写了

    }
}