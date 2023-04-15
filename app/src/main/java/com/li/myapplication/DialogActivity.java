package com.li.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import util.ToastUtil;

public class DialogActivity extends AppCompatActivity {
    private Button btn_dialog_1, btn_dialog_2, btn_dialog_3, btn_dialog_4, btn_dialog_5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        btn_dialog_1 = findViewById(R.id.btn_dialog_1);
        btn_dialog_2 = findViewById(R.id.btn_dialog_2);
        btn_dialog_3 = findViewById(R.id.btn_dialog_3);
        btn_dialog_4 = findViewById(R.id.btn_dialog_4);
        btn_dialog_5 = findViewById(R.id.btn_dialog_5);
        btn_dialog_1.setOnClickListener(new ClickListener());
        btn_dialog_2.setOnClickListener(new ClickListener());
        btn_dialog_3.setOnClickListener(new ClickListener());
        btn_dialog_5.setOnClickListener(new ClickListener());
    }

    class ClickListener implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.btn_dialog_1:
                    AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
                    builder.setTitle("请回答").setMessage("你觉得如何").setIcon(R.drawable.search)
                            .setPositiveButton("棒", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(DialogActivity.this, "你很诚实");
                                }
                            })
                            .setNeutralButton("不好", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(DialogActivity.this, "瞎说");
                                }
                            }).show();
                    break;
                case R.id.btn_dialog_2:
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(DialogActivity.this);
                    String[] array2 = new String[] {"man", "woman"};
                    builder2.setTitle("选择性别").setItems(array2, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(getApplicationContext(), array2[which]);
                        }
                    }).show();
                    break;
                case R.id.btn_dialog_3:
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(DialogActivity.this);
                    String[] array3 = new String[] {"man", "woman"};
                    builder3.setTitle("选择性别");
                    builder3.setSingleChoiceItems(array3, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(getApplicationContext(), array3[which]);
                            dialog.dismiss();
                        }
                    }).setCancelable(false).show();
                    break;
                case R.id.btn_dialog_4:
                    String[] array4 = new String[] {"唱歌", "跳舞", "写代码"};
                    boolean[] isSelected = new boolean[] {false, true, true};
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(DialogActivity.this);
                    builder4.setTitle("选择兴趣").setMultiChoiceItems(array4, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            ToastUtil.showMsg(getApplicationContext(), array4[which] + " is" + isChecked);
                        }
                    }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //do something
                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //do something
                        }
                    }).show();
                    break;
                case R.id.btn_dialog_5:
                    AlertDialog.Builder builder5 = new AlertDialog.Builder(DialogActivity.this);
                    View view = LayoutInflater.from(DialogActivity.this).inflate(R.layout.layout_dialog, null);
                    EditText etUserName = view.findViewById(R.id.et_username);
                    EditText etPassword = view.findViewById(R.id.et_password);
                    Button btnLogin = view.findViewById(R.id.btn_login);
                    btnLogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //do something
                        }
                    });
                    builder5.setTitle("请先登录").setView(view).show();
            }
        }
    }
}