package com.li.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class LifeCycleActivity extends AppCompatActivity {

    //通过这种方式，可以去研究生命周期，看看什么时候是什么生命周期，面对不同情况，在相应生命周期做些什么操作，这还是有点意思的。
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Log.d("lifeCycle", "-------onCreate---------");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifeCycle", "-------onStart---------");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifeCycle", "-------onResume---------");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifeCycle", "-------onPause---------");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifeCycle", "-------onStop---------");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifeCycle", "-------onDestroy---------");

    }
}