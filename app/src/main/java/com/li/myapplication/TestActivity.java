package com.li.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

//创建Activity三部曲
//1. 继承AppCompatActivity
//2. Manifest中记录，这样就可以跳转了
//3. 创建layout，setContentView,不然你空着，也没什么意思
public class TestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_test);
    }
}
