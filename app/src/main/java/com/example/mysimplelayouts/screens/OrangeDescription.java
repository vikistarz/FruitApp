package com.example.mysimplelayouts.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mysimplelayouts.R;

public class OrangeDescription extends AppCompatActivity {

    private View backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orange_description);

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
                Intent myIntent = new Intent(OrangeDescription.this, Orange_page.class);
                startActivity(myIntent);
            }
        });

    }

}