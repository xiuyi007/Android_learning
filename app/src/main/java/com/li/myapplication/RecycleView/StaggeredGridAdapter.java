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

public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.GridViewHolder> {
    Context mcontext;
    StaggeredGridAdapter.clickResponse mClick;
    public StaggeredGridAdapter(Context context, StaggeredGridAdapter.clickResponse click) {
        this.mcontext = context;
        this.mClick = click;
    }

    @NonNull
    @Override
    public StaggeredGridAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StaggeredGridAdapter.GridViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.layout_staggered_grid_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StaggeredGridAdapter.GridViewHolder holder, int position) {
        if (position % 2 == 0)
        {
            holder.imageView.setImageResource(R.drawable.we);
        }else
        {
            holder.imageView.setImageResource(R.drawable.us);
        }
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
        private ImageView imageView;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv);
        }
    }
}
