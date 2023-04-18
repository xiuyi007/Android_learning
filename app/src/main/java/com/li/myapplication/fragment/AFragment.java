package com.li.myapplication.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.li.myapplication.R;

public class AFragment extends Fragment {
    private BFragment bFragment;
    private Button mBtnChange;
    private Button mBtnReset;
    private Button mBtnMessage;
    private TextView mTvTitle;
    private onMessageClick listener;


    public interface onMessageClick
    {
        void onClick(String s);
    }
    //给AFragment传递参数
    //不要用构造函数传参，没用。Fragment的一些机制会让你这个传参无效
    public static AFragment getNewInstance(String s) {
        AFragment aFragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", s);
        aFragment.setArguments(bundle);
        return aFragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        //与activity绑定的时候做些事情
        try {
            listener = (onMessageClick) context;
        }catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement onMessageClick interface");
        }


    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("AFragment", "-- i am created;");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //相当于activity的setcontentview的感觉
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        Log.d("AFragment", "---------Created------------" );
        //可能因为某种原因，attach的activity会被销毁
/*        if (getActivity() == null)
        {
            //do something
        }
        else {
            //do something
        }*/
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTvTitle = view.findViewById(R.id.tv_title);
        if (getArguments() != null)
            mTvTitle.setText(getArguments().getString("title"));
        mBtnMessage = view.findViewById(R.id.btn_message);
        mBtnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //不推荐
/*                ContainerActivity activity = (ContainerActivity) getActivity();
                activity.setData("你好");*/
                //推荐
                listener.onClick("你好");
            }
        });
        mBtnChange = view.findViewById(R.id.btn_change);
        mBtnReset = view.findViewById(R.id.btn_reset);
        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvTitle.setText("now, u have changed the text");
            }
        });
        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bFragment == null)
                {
                    bFragment = new BFragment();
                }
                Fragment fragment = getParentFragmentManager().findFragmentByTag("a");
                if (fragment != null)
                //addToBackStack的话，你按返回键不是弹出activity，而是回滚事务
                {
                    getParentFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_container, bFragment).addToBackStack(null).commitAllowingStateLoss();
                }
                else{
                    getParentFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).addToBackStack(null).commitAllowingStateLoss();
                }
//                getParentFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).commitAllowingStateLoss();
            }
        });
    }



    @Override
    public void onDetach() {
        super.onDetach();
        //与activity解绑的时候做些事情
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //取消异步，但是我暂时不是很理解什么意思
    }
}
