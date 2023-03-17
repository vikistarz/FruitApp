package com.example.mysimplelayouts.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mysimplelayouts.R;
import com.example.mysimplelayouts.appleActivity.Apple_page;

public class DashBoard_page extends AppCompatActivity {
    private View settingView;
    private TextView profileName;
    private TextView orangeView;
    private TextView watermelonView;
    private TextView pineappleView;
    private TextView pawpawView;
    private TextView mangoView;
    private TextView guavaView;
    private TextView cucumberView;
    private TextView bananaView;
    private TextView appleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_page);

        inItView();
        inItListener();

}


    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences mySharedPreference = getSharedPreferences(getString(R.string.my_preference), Context.MODE_PRIVATE);
        String uN = mySharedPreference.getString(AppConstant.username, " ");

        profileName.setText("Hi, " + uN);
    }


  public void inItView(){

        settingView = findViewById(R.id.v_setting);
        profileName = findViewById(R.id.tv_profile_name);
        watermelonView = findViewById(R.id.tv_watermelon);
        mangoView = findViewById(R.id.tv_mango);
        pawpawView = findViewById(R.id.tv_pawpaw);
        bananaView = findViewById(R.id.tv_banana);
        pineappleView = findViewById(R.id.tv_pineapple);
        guavaView = findViewById(R.id.tv_guava);
        orangeView = findViewById(R.id.tv_orange);
        appleView = findViewById(R.id.tv_apple);
        cucumberView = findViewById(R.id.tv_cucumber);
  }

  public void inItListener(){
        settingView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(DashBoard_page. this, Settings_page.class);
                startActivity(myIntent);
            }
        });

        watermelonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(DashBoard_page. this, Watermelon_page.class);
                startActivity(myIntent);
            }
        });

      mangoView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent myIntent = new Intent(DashBoard_page. this, Mango_page.class);
              startActivity(myIntent);
          }
      });

      pawpawView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent myIntent = new Intent(DashBoard_page. this, Pawpaw_page.class);
              startActivity(myIntent);
          }
      });

      bananaView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent myIntent = new Intent(DashBoard_page. this, Banana_page.class);
              startActivity(myIntent);
          }
      });

      pineappleView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent myIntent = new Intent(DashBoard_page. this, Pineapple_page.class);
              startActivity(myIntent);
          }
      });

      guavaView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent myIntent = new Intent(DashBoard_page. this, Guava_page.class);
              startActivity(myIntent);
          }
      });

      orangeView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent myIntent = new Intent(DashBoard_page. this, Orange_page.class);
              startActivity(myIntent);
          }
      });

      appleView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent myIntent = new Intent(DashBoard_page. this, Apple_page.class);
              startActivity(myIntent);
          }
      });

      cucumberView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent myIntent = new Intent(DashBoard_page. this, Cucumber_page.class);
              startActivity(myIntent);
          }
      });


  }
}