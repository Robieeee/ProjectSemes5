package com.example.projectsemes5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.projectsemes5.adapter.DiscountsAdapter;
import com.example.projectsemes5.model.DiscountsData;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    Button stayBtn, searchBtn;
    ImageView chatIcon;
    RecyclerView discountsRecycler;
    DiscountsAdapter discountsAdapter;
    EditText searchET;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        stayBtn = findViewById(R.id.staysBtn);
        stayBtn.setPressed(true);
        chatIcon = findViewById(R.id.chatBtn);

        String name = "Hi, " + getIntent().getStringExtra("userName");

        // Recyler view
        List<DiscountsData> discountsDataList = new ArrayList<>();
        discountsDataList.add(new DiscountsData(name , "Special 15% discount for your stays", "Only available on 15-25th of December! Grab it fast!", R.drawable.discounts_icon));
        discountsDataList.add(new DiscountsData("Go go go!" , "Special 40% discount for your car rentals", "Only available on 15-25th of December! Grab it fast!", R.drawable.car_icon));
        discountsDataList.add(new DiscountsData("Where to?" , "Special 35% discount for your flights", "Only available on 15-25th of December! Grab it fast!", R.drawable.plane_icon));
        setDiscountsRecycler(discountsDataList);

        // Go to search
        searchBtn = findViewById(R.id.searchBtn);
        searchET = findViewById(R.id.search_barET);

        searchBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String searchedKey = searchET.getText().toString();
                Intent goToSearch = new Intent(HomeActivity.this, SearchActivity.class);
                goToSearch.putExtra("searchedKeyId", searchedKey);
                startActivity(goToSearch);
            }
        });

        chatIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chat = new Intent(HomeActivity.this,chatActivity.class);
                startActivity(chat);
            }
        });
    }



    private void setDiscountsRecycler(List<DiscountsData> discountsDataList){

        discountsRecycler = findViewById(R.id.discountsRV);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        discountsRecycler.setLayoutManager(layoutManager);
        discountsAdapter = new DiscountsAdapter(this, discountsDataList);
        discountsRecycler.setAdapter(discountsAdapter);
    }

}