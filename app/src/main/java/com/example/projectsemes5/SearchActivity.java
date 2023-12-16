package com.example.projectsemes5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.projectsemes5.adapter.HotelsAdapter;
import com.example.projectsemes5.model.HotelData;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    EditText searchET;

//    FirebaseDatabase database;
//    DatabaseReference dbreference;
//    RecyclerView recyclerView;
//    List<HotelData> hotelDataList;
//    ValueEventListener eventListener;
//


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

//        // recycler view
//        recyclerView = findViewById(R.id.hotelRV);
//        GridLayoutManager glm = new GridLayoutManager(SearchActivity.this, 1);
//        recyclerView.setLayoutManager(glm);
//
////        AlertDialog.Builder builder = new AlertDialog.Builder(SearchActivity.this);
////        builder.setCancelable(false);
////        AlertDialog dialog = builder.create();
//
//
//        hotelDataList = new ArrayList<>();
//
//        HotelsAdapter adapter = new HotelsAdapter(SearchActivity.this, hotelDataList);
//        recyclerView.setAdapter(adapter);
//
//        dbreference = FirebaseDatabase.getInstance().getReference("hotels");
//
//        eventListener = dbreference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                hotelDataList.clear();
//                for(DataSnapshot itemSnapshot: snapshot.getChildren()){
//                    HotelData hd = itemSnapshot.getValue(HotelData.class);
//                    hotelDataList.add(hd);
//                }
//
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });


    }

    public void backOnClick(){
        Intent backToHome = new Intent(SearchActivity.this, HomeActivity.class);
        startActivity(backToHome);
    }
}