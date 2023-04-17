package com.li.myapplication.jump;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.li.myapplication.R;

import util.ToastUtil;

public class AActivity extends AppCompatActivity {
    private Button mBtnJmp;
    private Button mBtnJmp2;
    private void logTaskName()
    {
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("AActivity", info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("AActivity", "------Create-------");
        Log.d("AActivity", "taskId: " + getTaskId() + " ,hash: " + hashCode());

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0)
        {
            Log.d("jump", "i am back");
            Toast.makeText(AActivity.this, data.getExtras().getString("title"), Toast.LENGTH_LONG).show();

        }
        else
        {
            ToastUtil.showMsg(AActivity.this,"md");
            Log.d("jump", "twice again");

        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_a);
        Log.d("AActivity", "------Create-------");
        Log.d("AActivity", "taskId: " + getTaskId() + " ,hash: " + hashCode());
        logTaskName();
        mBtnJmp = findViewById(R.id.btn_jmp);
        mBtnJmp2 = findViewById(R.id.btn_jmp2);
        mBtnJmp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AActivity.this, AActivity.class);
                startActivity(intent);
            }
        });
        mBtnJmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示1，通常用这个
                Intent intent1 = new Intent(AActivity.this, BActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("number", 88);
                bundle.putString("name", "togethf");
                intent1.putExtras(bundle);
                startActivity(intent1);
//                startActivityForResult(intent1, 0);
                //后来测试，这个想法可能是错的，以后再说，记住怎么用先！就是你跳出去，然后回传一个result，然后原函数就会收到你这个result，可以进行一些处理
                //经验证，调用多个这个方法，会等执行完所有的start，再触发onActivityResult，且触发顺序与调用顺序相反
                //故推测：startActivityForResult后，会跳到那个页面工作，页面结束后，会把RequestId(可能是别的)挂在一个等待栈上，然后继续执行原函数体，待函数体执行完毕，则根据出栈顺序执行onActivityResult方法
//                startActivityForResult(intent1, 1);

/*                //显示2
                Intent intent2 = new Intent();
                intent2.setClass(AActivity.this, BActivity.class);
                startActivity(intent2);

                //显示3
                Intent intent3 = new Intent();
                intent3.setClassName(AActivity.this, "com.li.myapplication.jump.BActivity");
                startActivity(intent3);

                //显示4
                Intent intent4 = new Intent();
                intent4.setComponent(new ComponentName(AActivity.this, "com.li.myapplication.jump.BActivity");
                startActivity(intent4);

                //隐式
                Intent intent5 = new Intent();
                intent5.setAction("this is a b activity"); //这里的内容是Manifest中设置的Action
                startActivity(intent5);*/
            }
        });

    }



}
