package com.example.projectsemes5.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectsemes5.model.DiscountsData;
import com.example.projectsemes5.R;
import com.example.projectsemes5.model.DiscountsData;

import java.util.List;

public class DiscountsAdapter extends RecyclerView.Adapter<DiscountsAdapter.DiscountsViewHolder> {

    Context context;
    List<DiscountsData> discountsDataList;

    public DiscountsAdapter(Context context, List<DiscountsData> discountsDataList) {
        this.context = context;
        this.discountsDataList = discountsDataList;
    }

    @NonNull
    @Override
    public DiscountsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.discounts_row_item, parent, false);

        return new DiscountsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscountsViewHolder holder, int position) {
        holder.name.setText(discountsDataList.get(position).getPlaceName());
        holder.title.setText(discountsDataList.get(position).getTitle());
        holder.desc.setText(discountsDataList.get(position).getDescription());
        holder.discounts_icon.setImageResource(discountsDataList.get(position).getImageUrl());
    }

    @Override
    public int getItemCount() {
        return discountsDataList.size();
    }

    public static final class DiscountsViewHolder extends RecyclerView.ViewHolder{
        ImageView discounts_icon;
        TextView name, title, desc;

        public DiscountsViewHolder(@NonNull View itemView){
            super(itemView);
            discounts_icon = itemView.findViewById(R.id.discount_icon);
            name = itemView.findViewById(R.id.nameTV);
            title = itemView.findViewById(R.id.titleTV);
            desc = itemView.findViewById(R.id.descTV);

        }
    }
}
