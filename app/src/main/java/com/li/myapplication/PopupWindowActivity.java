package com.li.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import util.ToastUtil;

public class PopupWindowActivity extends AppCompatActivity {
    private Button mBtnPopup;
    private PopupWindow mPop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);
        mBtnPopup = findViewById(R.id.btn_popup);
        mBtnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.layout_pop, null);
                TextView textView = view.findViewById(R.id.tv_good);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPop.dismiss();
                        ToastUtil.showMsg(PopupWindowActivity.this, "good");
                    }
                });
//  往里面放啥都可以，不是一定要自定义view    EditText editText = new EditText(PopupWindowActivity.this);
                mPop = new PopupWindow(view, mBtnPopup.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
                mPop.setOutsideTouchable(true); //点空白处收回
                mPop.setFocusable(true); //点击弹出，点击收回
                mPop.showAsDropDown(mBtnPopup); //作为谁的下拉菜单
            }
        });
    }
}