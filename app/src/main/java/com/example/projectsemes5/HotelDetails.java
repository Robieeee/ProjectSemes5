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
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class HotelDetails extends AppCompatActivity {
    ImageView second_back_arrow, second_arrow_up;
    TextView second_title, second_subtitle, second_rating_number, second_rating_number2, more_details;
    RatingBar second_ratingbar;
    Animation from_left, from_right, from_bottom;
    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_details);
        second_back_arrow = findViewById(R.id.second_back_arrow);
        second_arrow_up = findViewById(R.id.second_arrow);
        second_title = findViewById(R.id.second_title);
        second_subtitle = findViewById(R.id.second_subtitle);
        second_rating_number = findViewById(R.id.second_rating_number);
        second_rating_number2 = findViewById(R.id.second_numrate);
        more_details = findViewById(R.id.details);
        second_ratingbar = findViewById(R.id.second_ratingbar);



        second_arrow_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(page ini, ke page vanes);
//                StartActivity(intent);
            }
        });
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );

        from_left = AnimationUtils.loadAnimation(this,R.anim.anim_from_left);
        from_bottom = AnimationUtils.loadAnimation(this,R.anim.anim_from_bottom);
        from_right = AnimationUtils.loadAnimation(this,R.anim.anim_from_right);

        second_back_arrow.setAnimation(from_left);
        second_title.setAnimation(from_right);
        second_subtitle.setAnimation(from_right);
        more_details.setAnimation(from_bottom);
        second_ratingbar.setAnimation(from_left);
        second_rating_number2.setAnimation(from_right);
        second_rating_number.setAnimation(from_right);


        second_arrow_up.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HotelDetails.this,hoteldetails2.class);
                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(second_arrow_up,"background_image_transition");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(HotelDetails.this, pairs);
                startActivity(intent, options.toBundle());
            }
        });

    }
}