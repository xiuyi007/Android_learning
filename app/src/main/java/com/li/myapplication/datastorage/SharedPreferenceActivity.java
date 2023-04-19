package com.li.myapplication.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.li.myapplication.R;

import org.w3c.dom.Text;

public class SharedPreferenceActivity extends AppCompatActivity {

    private EditText mEtText;
    private Button mBtnSave, mBtnShow;
    private TextView mTvShow;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);

        mSharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        mEdit = mSharedPreferences.edit();

        mEtText = findViewById(R.id.et_text);
        mBtnSave = findViewById(R.id.btn_save);
        mBtnShow = findViewById(R.id.btn_show);
        mTvShow = findViewById(R.id.tv_show);
        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEdit.putString("name", mEtText.getText().toString());
                mEdit.apply(); //commit也可以，其实差别就在于写回磁盘的策略，内存都是立刻生效，一个立刻写回磁盘，一个不是
            }
        });
        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvShow.setText(mSharedPreferences.getString("name", ""));
            }
        });
    }
}