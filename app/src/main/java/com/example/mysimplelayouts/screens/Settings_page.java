package com.example.mysimplelayouts.screens;

import static android.content.Intent.ACTION_VIEW;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mysimplelayouts.R;

public class Settings_page extends AppCompatActivity {

    private TextView accountProfile,backgroundMode, notification, invite, support, sounds, fonts, appUpdate, aboutUs;
    private View backArrow;
    private SwitchCompat switcherCheck;
    private LinearLayout colorChange;
    private Button logOutButton;

    boolean switchNight;
    SharedPreferences mySharedPreferences;
    SharedPreferences.Editor myEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_page);


        inItView();
        inItListener();
    }

    public void inItView() {
        backArrow = findViewById(R.id.arrow_back);
        accountProfile = findViewById(R.id.tv_account_profile);
        backgroundMode = findViewById(R.id.tv_background_mode);
        notification = findViewById(R.id.tv_notify);
        invite = findViewById(R.id.tv_invite);
        support = findViewById(R.id.tv_support);
        sounds = findViewById(R.id.tv_sounds);
        fonts = findViewById(R.id.tv_fonts);
        appUpdate = findViewById(R.id.tv_update);
        aboutUs = findViewById(R.id.tv_about);
        switcherCheck = findViewById(R.id.switcher);
        colorChange = findViewById(R.id.colors);
        logOutButton = findViewById(R.id.btn_log_out);

    }

    public void inItListener() {
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Settings_page.this, DashBoard_page.class);
                startActivity(myIntent);
            }
        });

        switcherCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switchNight){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    SharedPreferences.Editor myEditor = mySharedPreferences.edit();
                    myEditor.putBoolean(AppConstant.nightMode, false);
                }

                else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    SharedPreferences.Editor myEditor = mySharedPreferences.edit();
                    myEditor.putBoolean(AppConstant.nightMode, true);
                }
                myEditor.apply();
            }
        });


        fonts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Settings_page.this, Fonts_page.class);
                startActivity(myIntent);
            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hisIntent = new Intent(Settings_page.this, Notifications_page.class);
                startActivity(hisIntent);

            }
        });

        accountProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent yourIntent = new Intent(Settings_page.this, Profile_page.class);
                startActivity(yourIntent);
            }
        });

        invite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(myIntent, 1);
            }
        });

        support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ACTION_VIEW, Uri.parse("https://www.google.com"));
                startActivity(intent);
            }
        });

        appUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_VIEW);
                myIntent.setData(Uri.parse("http://play.google.com/store/apps/details?id=my"));
                startActivity(myIntent);
            }
        });

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Settings_page.this, LogIn_page.class);
                startActivity(myIntent);

            }
        });

        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Settings_page.this, AboutUs_page.class);
                startActivity(myIntent);

            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences mySharedPreferences = getSharedPreferences(getString(R.string.my_preference), Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = mySharedPreferences.edit();
        myEditor.putBoolean(AppConstant.nightMode, switcherCheck.isChecked());
        myEditor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences mySharedPreferences = getSharedPreferences(getString(R.string.my_preference), Context.MODE_PRIVATE);
        switchNight = mySharedPreferences.getBoolean(AppConstant.nightMode, false); //light mode is by default

        if (switchNight){
            switcherCheck.setChecked(true);
        }




    }







}
