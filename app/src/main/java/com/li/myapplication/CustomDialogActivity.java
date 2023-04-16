package com.li.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.li.myapplication.widget.CustomDialog;

public class CustomDialogActivity extends AppCompatActivity {
    private Button mBtnDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
        mBtnDialog = findViewById(R.id.btn_cus_1);
        mBtnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customDialog = new CustomDialog(CustomDialogActivity.this);
                customDialog.setTitle("提示").setMessage("确认删除此项").setCancel("取消", new CustomDialog.OnCancelListener() {
                    @Override
                    public void OnCancel(CustomDialog dialog) {

                    }
                }).setConfirm("确认", new CustomDialog.OnConfirmListener() {
                    @Override
                    public void OnConfirm(CustomDialog dialog) {

                    }
                }).show();
            }
        });
    }
}