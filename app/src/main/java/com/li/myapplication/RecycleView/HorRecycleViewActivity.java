package com.li.myapplication.RecycleView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.li.myapplication.R;

public class HorRecycleViewActivity extends AppCompatActivity {
    private RecyclerView mRvHor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hor_recycle_view);
        mRvHor = findViewById(R.id.rv_hor);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HorRecycleViewActivity.this);
        linearLayoutManager.setOrientation(linearLayoutManager.HORIZONTAL);
        mRvHor.setLayoutManager(linearLayoutManager);
        mRvHor.setAdapter(new HorAdapter(HorRecycleViewActivity.this, new HorAdapter.clickResponse() {
            @Override
            public void onClick() {
                Toast.makeText(HorRecycleViewActivity.this, "ha", Toast.LENGTH_SHORT).show();
            }
        }));


    }
}