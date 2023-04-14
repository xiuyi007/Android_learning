package com.li.myapplication.RecycleView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.li.myapplication.R;

public class LinearRecycleViewActivity extends AppCompatActivity {
    private RecyclerView mRvMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycle_view);
        mRvMain = findViewById(R.id.rv_main);
        mRvMain.setLayoutManager(new LinearLayoutManager(LinearRecycleViewActivity.this));
        mRvMain.setAdapter(new LinearAdapter(LinearRecycleViewActivity.this, new LinearAdapter.OnItemClickListener() {
            @Override
            public void OnClick(int pos) {
                Toast.makeText(LinearRecycleViewActivity.this, "click" + pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }

}