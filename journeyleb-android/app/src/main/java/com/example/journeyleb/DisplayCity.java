package com.example.journeyleb;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;



public class DisplayCity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_city);


        Button buttonSelectCity = findViewById(R.id.buttonSelectCity);
        buttonSelectCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Redirect to CityDetailsJbeil  activity
                Intent intent = new Intent(DisplayCity.this, CityDetailsJbeil.class);
                startActivity(intent);
            }
        });


        // Repeat the process for the second city button if needed
        Button buttonSelectCity2 = findViewById(R.id.buttonSelectCity2);
        buttonSelectCity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Redirect to CityDetails activity
                Intent intent = new Intent(DisplayCity.this, CityDetailsBatroun.class);
                startActivity(intent);
            }
        });


}

}