package com.example.mysimplelayouts.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mysimplelayouts.R;

public class Notifications_page extends AppCompatActivity {
    private View backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications_page);

        inItView();
        inItListener();
    }
    public void inItView() {
        backArrow = findViewById(R.id.arrow_back);
    }
    public void inItListener(){
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Notifications_page.this, Settings_page.class);
                startActivity(myIntent);
            }
        });


    }
}