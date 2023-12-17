package com.example.projectsemes5.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectsemes5.HotelDetails;
import com.example.projectsemes5.model.HotelData;
import com.example.projectsemes5.R;
import com.example.projectsemes5.model.HotelData;

import java.util.List;

public class HotelsAdapter extends RecyclerView.Adapter<HotelsAdapter.MyViewHolder> {
    private Context context;
    private List<HotelData> hotelDataList;

    public HotelsAdapter(Context context, List<HotelData> hotelDataList) {
        this.context = context;
        this.hotelDataList = hotelDataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hotels_row_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        HotelData hotel = hotelDataList.get(position);
        int hotelId = hotel.getImageUrl();
        int resourceId = context.getResources().getIdentifier("hotel_" + hotelId, "drawable", context.getPackageName());

        holder.hotelName.setText(hotel.getName());
        holder.hotelLocation.setText(hotel.getLocation());
        holder.hotelPrice.setText(hotel.getPrice());
        holder.hotelRB.setRating(hotel.getRating());
        holder.hotelImg.setImageResource(resourceId);

        holder.recCard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // pindah ke detail
                Intent intent = new Intent(context, HotelDetails.class);
                intent.putExtra("hotelName", hotelDataList.get(holder.getAdapterPosition()).getName());
                intent.putExtra("hotelRating", hotelDataList.get(holder.getAdapterPosition()).getRating());
                intent.putExtra("hotelImg", hotelDataList.get(holder.getAdapterPosition()).getImageUrl());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return hotelDataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView hotelImg;
        TextView hotelName, hotelLocation, hotelPrice;
        RatingBar hotelRB;
        CardView recCard;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            hotelImg = itemView.findViewById(R.id.hotelImageIV);
            hotelName = itemView.findViewById(R.id.hotelNameTV);
            hotelLocation = itemView.findViewById(R.id.hotelLocationTV);
            hotelPrice = itemView.findViewById(R.id.hotelPriceTV);
            hotelRB = itemView.findViewById(R.id.hotelRatingRB);

            recCard = itemView.findViewById(R.id.recCard);

        }
    }
}


