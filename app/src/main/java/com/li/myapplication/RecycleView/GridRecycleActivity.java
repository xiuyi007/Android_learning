package com.li.myapplication.RecycleView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.li.myapplication.R;

public class GridRecycleActivity extends AppCompatActivity {
    private RecyclerView mRvGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycle);
        mRvGrid = findViewById(R.id.rv_grid);
        mRvGrid.setLayoutManager(new GridLayoutManager(GridRecycleActivity.this, 3));
        mRvGrid.setAdapter(new GridAdapter(GridRecycleActivity.this, new GridAdapter.clickResponse() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(GridRecycleActivity.this, "click: " + pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }
}