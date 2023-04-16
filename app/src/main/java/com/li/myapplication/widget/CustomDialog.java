package com.li.myapplication.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.li.myapplication.R;

public class CustomDialog extends Dialog implements View.OnClickListener {
    private TextView mTvTitle, mTvMessage, mTvCancel, mTvConfirm;
    private String title, message, cancel, confirm;
    private OnCancelListener cancelListener;
    private OnConfirmListener confirmListener;

    public String getTitle() {
        return title;
    }

    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }
    public String getMessage() {
        return message;
    }

    public CustomDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getCancel() {
        return cancel;
    }

    public CustomDialog setCancel(String cancel, OnCancelListener listener) {
        this.cancelListener = listener;
        this.cancel = cancel;
        return this;
    }

    public String getConfirm() {
        return confirm;
    }

    public CustomDialog setConfirm(String confirm, OnConfirmListener listener) {
        this.confirm = confirm;
        this.confirmListener = listener;
        return this;
    }

    public CustomDialog(@NonNull Context context) {
        super(context);
    }
    //似乎没起作用？
    public CustomDialog(@NonNull Context context, int themeId) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);

        //设置宽度
        //这部分代码是固定的，网上直接搜，这里就不写了
        //设置的是dialog的长宽
        //.....略


        mTvTitle = findViewById(R.id.tv_title);
        mTvMessage = findViewById(R.id.tv_text);
        mTvCancel = findViewById(R.id.tv_cancel);
        mTvConfirm= findViewById(R.id.tv_confirm);
        if (!TextUtils.isEmpty(title))
            mTvTitle.setText(title);
        if(!TextUtils.isEmpty(message))
            mTvMessage.setText(message);
        if (!TextUtils.isEmpty(confirm))
            mTvConfirm.setText(confirm);
        if(!TextUtils.isEmpty(cancel))
            mTvCancel.setText(cancel);
        mTvCancel.setOnClickListener(this);
        mTvConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.tv_cancel:
                cancelListener.OnCancel(this);
                break;
            case R.id.tv_confirm:
                confirmListener.OnConfirm(this);
                break;
        }
    }

    public interface OnCancelListener{
        void OnCancel(CustomDialog dialog);
    }
    public interface OnConfirmListener{
        void OnConfirm(CustomDialog dialog);
    }
}
