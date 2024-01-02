package com.example.journeyleb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CityDetailsBatroun extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_details_batroun);

        Button buttonSelectact1 = findViewById(R.id.buttonSelectact1);
        buttonSelectact1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Redirect to ActivityDetailsJbeil activity
                Intent intent = new Intent(CityDetailsBatroun.this, ActivityDetailsBatroun.class);
                startActivity(intent);
            }
        });


        Button buttonSelectact2 = findViewById(R.id.buttonSelectact2);
        buttonSelectact2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Redirect to ActivityDetails2Jbeil activity
                Intent intent = new Intent(CityDetailsBatroun.this, ActivityDeatails2Batroun.class);
                startActivity(intent);
            }
        });



    }
}