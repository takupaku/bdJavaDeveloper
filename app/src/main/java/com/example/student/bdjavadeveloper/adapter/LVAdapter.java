package com.example.student.bdjavadeveloper.adapter;


import android.content.Context;
import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.student.bdjavadeveloper.R;
import com.example.student.bdjavadeveloper.model.Item;

import java.util.List;

public class LVAdapter extends RecyclerView.Adapter<LVAdapter.ViewHolder> {
    private Context context;
    private List<Item> items;

    public LVAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view =LayoutInflater.from(context).inflate(R.layout.sample_layout,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class  ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView user,profile_url;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
