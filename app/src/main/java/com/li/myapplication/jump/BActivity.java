package com.li.myapplication.jump;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.li.myapplication.R;

public class BActivity extends AppCompatActivity {
    private TextView mTvTitle;
    private Button mBtnClick;
    private Button mBtnA;

    private void logTaskName()
    {
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("BActivity", info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("BActivity", "------Create-------");
        Log.d("BActivity", "taskId: " + getTaskId() + " ,hash: " + hashCode());

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_b);
        Log.d("BActivity", "------Create-------");
        Log.d("BActivity", "taskId: " + getTaskId() + " ,hash: " + hashCode());
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        int number = bundle.getInt("number");
        mTvTitle = findViewById(R.id.tv_title);
        mBtnClick = findViewById(R.id.btn_click);
        mBtnClick = findViewById(R.id.btn_toA);
        mBtnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BActivity.this, AActivity.class);
                startActivity(intent);
            }
        });
        mTvTitle.setText(name +" ," + number);

        mBtnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle1 = new Bundle();
                bundle1.putString("title", "i am back");
                bundle1.putString("md", "md");
                intent.putExtras(bundle1);
                setResult(AActivity.RESULT_OK, intent);
                finish(); //关闭当前页面
            }
        });


    }
}
