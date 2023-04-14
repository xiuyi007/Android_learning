package com.li.myapplication.RecycleView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.li.myapplication.R;

public class StaggeredGridRecycleViewActivity extends AppCompatActivity {
    private RecyclerView mRv_stg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered_grid_recycle_view);
        mRv_stg = findViewById(R.id.rv_staggered_grid);
        mRv_stg.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRv_stg.setAdapter(new StaggeredGridAdapter(StaggeredGridRecycleViewActivity.this, new StaggeredGridAdapter.clickResponse() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(StaggeredGridRecycleViewActivity.this, "click" + pos, Toast.LENGTH_SHORT).show();
            }
        }));

    }
}