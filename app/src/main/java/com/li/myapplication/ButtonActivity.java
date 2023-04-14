package com.li.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {
    private Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        btn2 = findViewById(R.id.button_2);
        //这种更常用
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonActivity.this, "我被点击了", Toast.LENGTH_SHORT);
            }
        });
    }

    //另一种方式，在布局中写onlick，然后在这里写个方法
    public void showToast(View view) {
        Toast.makeText(this, "i am clicked", Toast.LENGTH_SHORT);
    }
}