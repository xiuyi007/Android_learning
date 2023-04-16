package com.li.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.li.myapplication.RecycleView.RecycleViewActivity;

public class UIActivity extends AppCompatActivity {

    private Button mBtnTextView;
    private Button btn_three;
    private Button btn_4;
    private Button btn_checkbox;
    private Button btn_imageview;
    private Button btn_recycleView;
    private Button btn_webView;
    private Button btn_toast;
    private Button btn_dialog;
    private Button btn_progressbar;
    private Button btn_custom_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        mBtnTextView = findViewById(R.id.btn_textview);
        mBtnTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到TextView演示界面
                Intent intent = new Intent(UIActivity.this, TextViewActivity.class);
                startActivity(intent);
            }
        });

        mBtnTextView = findViewById(R.id.btn_textview_two);
        mBtnTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UIActivity.this, ButtonActivity.class);
                startActivity(intent);
            }
        });
        btn_three = findViewById(R.id.btn_three);
        btn_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UIActivity.this, EditTextActivity.class);
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
        btn_toast= findViewById(R.id.btn_toast);
        setListeners(btn_toast);
        btn_dialog= findViewById(R.id.btn_dialog);
        setListeners(btn_dialog);
        btn_progressbar = findViewById(R.id.btn_progressbar);
        setListeners(btn_progressbar);
        btn_custom_dialog = findViewById(R.id.btn_custom_dialog);
        setListeners(btn_custom_dialog);
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
                    intent = new Intent(UIActivity.this, RadioButtonActivity.class);
                    break;

                case R.id.btn_three:
                    intent = new Intent(UIActivity.this, EditTextActivity.class);
                    break;
                case R.id.checkbox_1:
                    intent = new Intent(UIActivity.this, CheckBoxActivity.class);
                    break;
                case R.id.goto_imageView:
                    intent = new Intent(UIActivity.this, ImageViewActivity.class);
                    break;
                case R.id.goto_rv:
                    intent = new Intent(UIActivity.this, RecycleViewActivity.class);
                    break;
                case R.id.btn_webview:
                    intent = new Intent(UIActivity.this, WebViewActivity.class);
                    break;
                case R.id.btn_toast:
                    intent = new Intent(UIActivity.this, ToastActivity.class);
                    break;
                case R.id.btn_dialog:
                    intent = new Intent(UIActivity.this, DialogActivity.class);
                    break;
                case R.id.btn_progressbar:
                    intent = new Intent(UIActivity.this, ProgressBarActivity.class);
                    break;
                case R.id.btn_custom_dialog:
                    intent = new Intent(UIActivity.this, CustomDialogActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}