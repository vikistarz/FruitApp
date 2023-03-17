package com.example.mysimplelayouts.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mysimplelayouts.R;

public class PawPawDescription extends AppCompatActivity {

    private View backArrow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paw_paw_description);

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
                Intent myIntent = new Intent(PawPawDescription.this, Pawpaw_page.class);
                startActivity(myIntent);
            }
        });

    }

}