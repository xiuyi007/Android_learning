package com.li.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import util.ToastUtil;

public class ToastActivity extends AppCompatActivity {
    private Button mBtnToast1, mBtnToast2, mBtnToast3, mBtnToast4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        mBtnToast1 = findViewById(R.id.btn_toast_1);
        mBtnToast2 = findViewById(R.id.btn_toast_2);
        mBtnToast3 = findViewById(R.id.btn_toast_3);
        mBtnToast4 = findViewById(R.id.btn_toast_4);
        ClickListener clickListener = new ClickListener();
        mBtnToast1.setOnClickListener(clickListener);
        mBtnToast2.setOnClickListener(clickListener);
        mBtnToast3.setOnClickListener(clickListener);
        mBtnToast4.setOnClickListener(clickListener);
    }

    class ClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View view) {
            switch (view.getId())
            {
                case R.id.btn_toast_1:
                    Toast.makeText(getApplicationContext(), "Toast", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_toast_2:
                    Toast toast = Toast.makeText(ToastActivity.this, "居中Toast", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    toast.show();
                    break;
                case R.id.btn_toast_3:
                    Toast toastCustom = new Toast(getApplicationContext());
                    LayoutInflater inflater = LayoutInflater.from(ToastActivity.this);
                    //这里设置的布局，最外层的width和height是不起作用的，想用这两个属性，就在布局里再套一个布局。
                    View mView = inflater.inflate(R.layout.layout_toast, null);
                    ImageView imageView = mView.findViewById(R.id.iv_toast);//View在哪个控件里面就要用这个控件findview
                    TextView textView = mView.findViewById(R.id.tv_toast);
                    imageView.setImageResource(R.drawable.sender);
                    textView.setText("自定义toast");
                    toastCustom.setView(mView);
                    toastCustom.show();
                    break;
                case R.id.btn_toast_4:
                    //这种方式，就可以避免点击一次就创建一个新的toast。防止死亡点击
                    ToastUtil.showMsg(getApplicationContext(), "hello, world");
            }
        }
    }
}