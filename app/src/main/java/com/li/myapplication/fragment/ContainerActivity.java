package com.li.myapplication.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.li.myapplication.R;

public class ContainerActivity extends AppCompatActivity implements AFragment.onMessageClick{
    private TextView mTvTitle;
    private AFragment aFragment;
/*    private BFragment bFragment;
    private Button mBtnChange;*/

    //不推荐: 写一个function来给fragment调用，从而实现数据传递的功能
    public void setData(String text) {
        mTvTitle.setText(text);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        mTvTitle = findViewById(R.id.tv_title);
        //实例化AFragment

        aFragment = AFragment.getNewInstance("this is a added AFrament");
        //把AFragment添加到Activity中
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container, aFragment, "a").commitAllowingStateLoss();
        /*mBtnChange = findViewById(R.id.btn_change);
        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bFragment == null)
                {
                    bFragment = new BFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).commitAllowingStateLoss();
            }
        });*/
    }

    @Override
    public void onClick(String s) {
        mTvTitle.setText(s);
    }
}