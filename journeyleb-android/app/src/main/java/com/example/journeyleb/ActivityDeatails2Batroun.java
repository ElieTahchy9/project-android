package com.example.journeyleb;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ActivityDeatails2Batroun extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deatails2_batroun);

        Button buttonRegister = findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Redirect to RegisterActivityForm activity
                Intent intent = new Intent(ActivityDeatails2Batroun.this, RegisterActivityForm.class);
                startActivity(intent);
            }
        });


    }
}