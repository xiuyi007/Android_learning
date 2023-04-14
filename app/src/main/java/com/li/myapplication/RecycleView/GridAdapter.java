package com.li.myapplication.RecycleView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.li.myapplication.R;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {
    Context mcontext;
    GridAdapter.clickResponse mClick;
    public GridAdapter(Context context, GridAdapter.clickResponse click) {
        this.mcontext = context;
        this.mClick = click;
    }

    @NonNull
    @Override
    public GridAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GridAdapter.GridViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.layout_grid_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GridAdapter.GridViewHolder holder, int position) {
        holder.textView.setText("hello, world");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClick.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 60;
    }

    public interface clickResponse {
        void onClick(int pos);
    }

    class GridViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
        }
    }
}
