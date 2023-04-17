package com.li.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.li.myapplication.jump.AActivity;

public class LearningActivity extends AppCompatActivity {
    private Button mBtnLife;
    private Button mBtnJump;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);
        mBtnLife = findViewById(R.id.btn_lifecycle);
        mBtnJump = findViewById(R.id.btn_jump);
        mBtnLife.setOnClickListener(new ClickListener());
        mBtnJump.setOnClickListener(new ClickListener());
    }

    class ClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId())
            {
                case R.id.btn_lifecycle:
                    intent = new Intent(LearningActivity.this, LifeCycleActivity.class);
                    break;
                case R.id.btn_jump:
                    intent = new Intent(LearningActivity.this, AActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}