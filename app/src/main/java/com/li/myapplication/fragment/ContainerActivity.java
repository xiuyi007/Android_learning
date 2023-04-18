package com.li.myapplication.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.li.myapplication.R;

public class ContainerActivity extends AppCompatActivity {

    private AFragment aFragment;
/*    private BFragment bFragment;
    private Button mBtnChange;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        //实例化AFragment

        aFragment = AFragment.getNewInstance("this is a added AFrament");
        //把AFragment添加到Activity中
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container, aFragment, "a").commitAllowingStateLoss();
        /*mBtnChange = findViewById(R.id.btn_change);
        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bFragment == null)
                {
                    bFragment = new BFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).commitAllowingStateLoss();
            }
        });*/
    }
}