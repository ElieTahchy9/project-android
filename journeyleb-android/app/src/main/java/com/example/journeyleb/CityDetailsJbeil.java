package com.example.journeyleb;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class CityDetailsJbeil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_details_jbeil);

        Button buttonSelectact1 = findViewById(R.id.buttonSelectact1);
        buttonSelectact1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Redirect to ActivityDetailsJbeil activity
                Intent intent = new Intent(CityDetailsJbeil.this, ActivityDeatailsJbeil.class);
                startActivity(intent);
            }
        });


        Button buttonSelectact2 = findViewById(R.id.buttonSelectact2);
        buttonSelectact2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Redirect to ActivityDetails2Jbeil activity
                Intent intent = new Intent(CityDetailsJbeil.this, ActivityDeatails2Jbeil.class);
                startActivity(intent);
            }
        });

    }
}