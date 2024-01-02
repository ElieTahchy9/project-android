package com.example.journeyleb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;

import android.view.View;
import android.widget.Button;

public class ActivityDeatailsJbeil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deatails_jbeil);



        Button buttonRegister = findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Redirect to RegisterActivityForm activity
                Intent intent = new Intent(ActivityDeatailsJbeil.this, RegisterActivityForm.class);
                startActivity(intent);
            }
        });
    }
}