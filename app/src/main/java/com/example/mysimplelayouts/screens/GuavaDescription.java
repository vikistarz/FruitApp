package com.example.mysimplelayouts.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mysimplelayouts.R;

public class GuavaDescription extends AppCompatActivity {

    private View backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guava_description);
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
                Intent myIntent = new Intent(GuavaDescription.this, Guava_page.class);
                startActivity(myIntent);
            }
        });

    }
}
