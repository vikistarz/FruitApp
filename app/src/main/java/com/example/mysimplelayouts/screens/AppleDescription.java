package com.example.mysimplelayouts.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mysimplelayouts.R;
import com.example.mysimplelayouts.appleActivity.Apple_page;

public class AppleDescription extends AppCompatActivity {

    private View backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apple_description);

        inItView();
        inItListener();

    }
    private void inItView() {
        backArrow = findViewById(R.id.arrow_back);
    }
    public void inItListener() {
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(AppleDescription.this, Apple_page.class);
                startActivity(myIntent);
            }
        });

    }

}