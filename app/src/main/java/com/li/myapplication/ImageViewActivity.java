package com.li.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {
    private ImageView img2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        img2 = findViewById(R.id.img_2);
        //要在manifest中开启网络权限
        Glide.with(this).load("https://t7.baidu.com/it/u=1819248061,230866778&fm=193&f=GIF").into(img2);
    }
}