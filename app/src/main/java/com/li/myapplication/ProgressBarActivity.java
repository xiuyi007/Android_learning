package com.li.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ProgressBar;
import android.widget.Toast;

import util.ToastUtil;

public class ProgressBarActivity extends AppCompatActivity {
    private ProgressBar mPb3;
    private Button mBtn;
    private Button mBtnProgressDialog1, mBtnProgressDialog2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        mPb3 = findViewById(R.id.pb_3);
        mBtn = findViewById(R.id.btn_click);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.sendEmptyMessage(0);
            }
        });

        mBtnProgressDialog1 = findViewById(R.id.btn_progressbar_dialog1);
        mBtnProgressDialog2 = findViewById(R.id.btn_progressbar_dialog2);
        mBtnProgressDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(ProgressBarActivity.this);
                progressDialog.setMessage("正在加载");
                progressDialog.setTitle("提示");
                progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        ToastUtil.showMsg(ProgressBarActivity.this, "cancle");
                    }
                });
//                progressDialog.setCancelable(false);
                progressDialog.show();
            }
        });
        mBtnProgressDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(ProgressBarActivity.this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setTitle("tips");
                progressDialog.setMessage("正在下载");
                progressDialog.show();

            }
        });
    }
    //以下部分暂时不了解没关系，之后会学。
    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (mPb3.getProgress() < 100)
            {
                handler.postDelayed(runnable, 500);
            }else
            {
                Toast.makeText(ProgressBarActivity.this, "加载完成", Toast.LENGTH_SHORT).show();
            }
        }
    };

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mPb3.setProgress(mPb3.getProgress() + 5);
            handler.sendEmptyMessage(0);
        }
    };
}