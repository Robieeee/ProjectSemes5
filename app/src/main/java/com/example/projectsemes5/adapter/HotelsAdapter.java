package com.example.projectsemes5.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectsemes5.model.HotelData;
import com.example.projectsemes5.R;
import com.example.projectsemes5.model.HotelData;

import java.util.List;

public class HotelsAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context context;
    private List<HotelData> hotelDataList;

    public HotelsAdapter(Context context, List<HotelData> hotelDataList) {
        this.context = context;
        this.hotelDataList = hotelDataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotels_row_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        Glide.with(context).load(hotelDataList.get(position).getImageUrl()).into(holder.recImage);
        holder.hotelName.setText(hotelDataList.get(position).getName());

        holder.recCard.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                // pindah ke detail
            }
        });
    }

    @Override
    public int getItemCount() {
        return hotelDataList.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{
    ImageView recImage;
    TextView hotelName;
    CardView recCard;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        //recImage = itemView.findViewById(R.id.recImage);
        hotelName = itemView.findViewById(R.id.hotelNameTV);
        recCard = itemView.findViewById(R.id.recCard);

    }
}
