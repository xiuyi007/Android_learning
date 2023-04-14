package com.li.myapplication.RecycleView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.li.myapplication.R;

public class RecycleViewActivity extends AppCompatActivity {
    private Button mBtn_linear, mBtn_hor, mBtn_grid, mBtn_staggered_grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        mBtn_hor = findViewById(R.id.btn_hor);
        mBtn_hor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecycleViewActivity.this, HorRecycleViewActivity.class);
                startActivity(intent);
            }
        });
        mBtn_linear = findViewById(R.id.btn_linear);
        mBtn_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecycleViewActivity.this, LinearRecycleViewActivity.class);
                startActivity(intent);
            }
        });
        mBtn_grid = findViewById(R.id.btn_grid);
        mBtn_grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecycleViewActivity.this, GridRecycleActivity.class);
                startActivity(intent);
            }
        });
        mBtn_staggered_grid = findViewById(R.id.btn_staggered_grid);
        mBtn_staggered_grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecycleViewActivity.this, StaggeredGridRecycleViewActivity.class);
                startActivity(intent);
            }
        });
    }
}