package com.li.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;

import com.li.myapplication.RecycleView.RecycleViewActivity;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button mBtnTextView;
    private Button btn_three;
    private Button btn_4;
    private Button btn_checkbox;
    private Button btn_imageview;
    private Button btn_recycleView;
    private Button btn_webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnTextView = findViewById(R.id.btn_textview);
        mBtnTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到TextView演示界面
                Intent intent = new Intent(MainActivity.this, TextViewActivity.class);
                startActivity(intent);
            }
        });

        mBtnTextView = findViewById(R.id.btn_textview_two);
        mBtnTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ButtonActivity.class);
                startActivity(intent);
            }
        });
        btn_three = findViewById(R.id.btn_three);
        btn_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EditTextActivity.class);
                startActivity(intent);
            }
        });
        btn_4 = findViewById(R.id.button_4);
        //每次重复的写这些代码太冗余了，直接写了个方法
        setListeners(btn_4);
        btn_checkbox = findViewById(R.id.checkbox_1);
        setListeners(btn_checkbox);
        btn_imageview = findViewById(R.id.goto_imageView);
        setListeners(btn_imageview);
        btn_recycleView = findViewById(R.id.goto_rv);
        setListeners(btn_recycleView);
        btn_webView = findViewById(R.id.btn_webview);
        setListeners(btn_webView);

    }
    private void setListeners(View view) {
        OnClick onClick = new OnClick();
        view.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()) {
                case R.id.button_4:
                    intent = new Intent(MainActivity.this, RadioButtonActivity.class);
                    break;

                case R.id.btn_three:
                    intent = new Intent(MainActivity.this, EditTextActivity.class);
                    break;
                case R.id.checkbox_1:
                    intent = new Intent(MainActivity.this, CheckBoxActivity.class);
                    break;
                case R.id.goto_imageView:
                    intent = new Intent(MainActivity.this, ImageViewActivity.class);
                    break;
                case R.id.goto_rv:
                    intent = new Intent(MainActivity.this, RecycleViewActivity.class);
                case R.id.btn_webview:
                    intent = new Intent(MainActivity.this, WebViewActivity.class);
            }
            startActivity(intent);
        }
    }
}