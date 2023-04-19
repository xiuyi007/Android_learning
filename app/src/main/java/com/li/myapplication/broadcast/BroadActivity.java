package com.li.myapplication.broadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.li.myapplication.R;

import org.w3c.dom.Text;

//只是为了演示广播，并非这么用的，这里实现的内容完全不需要广播，startActivityForResult就能实现
public class BroadActivity extends AppCompatActivity {
    private Button mBtn1;
    private TextView tv;
    private MyBroadcast myBroadcast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad);
        mBtn1 = findViewById(R.id.btn1);
        tv = findViewById(R.id.tv_test);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BroadActivity.this, BroadActivity2.class);
            }
        });
        myBroadcast = new MyBroadcast();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.li.update"); //设置我这个activity接受哪些广播，广播不是一定要接受的
        LocalBroadcastManager.getInstance(this).registerReceiver(myBroadcast, intentFilter);
    }

    private class MyBroadcast extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()) {
                case "com.li.update":
                    tv.setText("123");
                    break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消注册
        LocalBroadcastManager.getInstance(this).unregisterReceiver(myBroadcast);
    }
}