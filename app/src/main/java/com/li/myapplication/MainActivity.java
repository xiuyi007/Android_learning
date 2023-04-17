package com.li.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_UI, btn_special;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_UI = findViewById(R.id.btn_ui);
        btn_UI.setOnClickListener(new ClickListener());
        btn_special = findViewById(R.id.btn_learn);
        btn_special.setOnClickListener(new ClickListener());

    }
    class ClickListener implements View.OnClickListener
    {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId())
            {
                case R.id.btn_ui:
                    intent = new Intent(getApplicationContext(), UIActivity.class);
                    break;
                case R.id.btn_learn:
                    intent = new Intent(getApplicationContext(), LearningActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}