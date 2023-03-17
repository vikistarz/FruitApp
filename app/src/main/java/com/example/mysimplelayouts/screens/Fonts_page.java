package com.example.mysimplelayouts.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mysimplelayouts.R;

public class Fonts_page extends AppCompatActivity {

    private Button playStoreButton;
    private View backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.font_page);

        inItView();
        inItListener();

    }
   public void inItView(){
        playStoreButton = findViewById(R.id.btn_play_store_app);
        backArrow = findViewById(R.id.arrow_back);
   }

   public void inItListener(){
        playStoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_VIEW);
                myIntent.setData(Uri.parse("http://play.google.com/store/apps/details?id=my"));
                startActivity(myIntent);
            }
        });

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Fonts_page.this, Settings_page.class);
                startActivity(myIntent);
            }
        });
   }
}