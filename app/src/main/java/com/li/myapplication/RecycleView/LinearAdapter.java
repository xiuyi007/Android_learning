package com.li.myapplication.RecycleView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.li.myapplication.R;
//进阶LinearAdapter
//进一步想获取下拉刷新、上拉加载等功能，可以去github上找XRecyclerView这个库
public class LinearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private OnItemClickListener mlistener;

    public LinearAdapter(Context context, OnItemClickListener listener) {
        this.mContext = context;
        this.mlistener = listener;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0)
            return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item_single, parent, false));
        else
            return new LinearViewHolder2(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item, parent, false));
    }

    //偶数的viewType为0否则为1
    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0)
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //设置监听的一种方法
/*        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "click....." + position, Toast.LENGTH_SHORT).show();
            }
        });*/
        if (getItemViewType(position) == 0)
        {
            LinearViewHolder linearViewHolder = (LinearViewHolder)holder;
            linearViewHolder.textView.setText("hello, world");
//            ((LinearViewHolder)holder).textView.setText("hello, world"); //这么写也可以
        }
        else
        {
            LinearViewHolder2 linearViewHolder2 = (LinearViewHolder2) holder;
            linearViewHolder2.textView.setText("togethf");
        }
        //另一种方法, 思想很重要！！！！！！
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mlistener.OnClick(position);
            }
        });
    }
    public interface OnItemClickListener {
        void OnClick(int pos);
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class LinearViewHolder extends  RecyclerView.ViewHolder {
        private TextView textView;
        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
        }
    }
    class LinearViewHolder2 extends  RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imgView;
        public LinearViewHolder2(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
            imgView = itemView.findViewById(R.id.iv_title);
        }
    }
}
