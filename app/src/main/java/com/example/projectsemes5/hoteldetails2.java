package com.example.projectsemes5;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class hoteldetails2 extends AppCompatActivity {
    ImageView arrow_down;
    ScrollView scrollView;
    Animation bottomform;
    Integer resourceId;
    ImageView header_background;
    TextView third_title, third_rating_num;
    RatingBar third_ratingBar;
    Button roadmap_button;

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoteldetails2);
        arrow_down = findViewById(R.id.down_arrow);
        scrollView = findViewById(R.id.scrollView);
        bottomform = AnimationUtils.loadAnimation(this,R.anim.anim_from_bottom);
        arrow_down.setAnimation(bottomform);
        scrollView.setAnimation(bottomform);
        roadmap_button = findViewById(R.id.roadmap_button);

        third_title = findViewById(R.id.third_title);
        third_rating_num = findViewById(R.id.third_rating_number);
        third_ratingBar = findViewById(R.id.third_ratingbar);
        header_background = findViewById(R.id.header_background);

        // ganti data jadi data hotel
        String name = getIntent().getStringExtra("hotelName");
        Float rating = getIntent().getFloatExtra("hotelRating", 0);
        Integer img = getIntent().getIntExtra("hotelImg", 1);

        third_title.setText(name);
        third_ratingBar.setRating(rating);
        third_rating_num.setText((rating.toString()));
        // ini blm ditambahin hehe nanti ya kerjain data mining dulu, soalnya img nya perlu diresize
        //header_background.setBackgroundResource(resourceId);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );

        arrow_down.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hoteldetails2.this, HotelDetails.class);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(arrow_down, "background_image_transition");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(hoteldetails2.this, pairs);
                startActivity(intent, options.toBundle());
            }
        });
        
        roadmap_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(hoteldetails2.this, HomeActivity.class);
                Toast.makeText(hoteldetails2.this, "Booking successful!", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

    }
}