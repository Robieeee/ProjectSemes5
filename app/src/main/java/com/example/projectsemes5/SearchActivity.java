package com.example.projectsemes5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.example.projectsemes5.adapter.HotelsAdapter;
import com.example.projectsemes5.model.HotelData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    EditText searchET;
    RecyclerView recyclerView;
    DatabaseReference database;
    HotelsAdapter adapter;
    List<HotelData> hotelDataList;
    ValueEventListener eventListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // Search
        searchET = findViewById(R.id.search_barET);
        Intent ambilData = getIntent();
        String searchedKey = ambilData.getStringExtra("searchedKeyId");
        searchET.setText(searchedKey);
        searchedKey = searchET.getText().toString();

//      // Recycler view
        recyclerView = findViewById(R.id.hotelRV);
        database = FirebaseDatabase.getInstance().getReference("hotels");
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(SearchActivity.this);
        recyclerView.setLayoutManager(llm);

        hotelDataList = new ArrayList<>();

        adapter = new HotelsAdapter(SearchActivity.this, hotelDataList);
        recyclerView.setAdapter(adapter);

        eventListener = database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                hotelDataList.clear();
                for(DataSnapshot itemSnapshot: snapshot.getChildren()){
                    HotelData hd = itemSnapshot.getValue(HotelData.class);
                    hotelDataList.add(hd);

                    Log.d("Hotel","Hotel" + hd.getId() + hd.getName() + hd.getRating() + hd.getPrice() + hd.getLocation());

                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    public void backOnClick(){
        Intent backToHome = new Intent(SearchActivity.this, HomeActivity.class);
        startActivity(backToHome);
    }
}