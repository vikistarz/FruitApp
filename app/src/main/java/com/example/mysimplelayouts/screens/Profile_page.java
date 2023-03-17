package com.example.mysimplelayouts.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mysimplelayouts.R;

public class Profile_page extends AppCompatActivity {

    private EditText firstNameEditText, lastNameEditText, phoneNumberEditText, emailAddressEditText, usernameEditText;
    private Button saveChangeButton;
    private View backArrow;

    private String fN, lN, pN, eA, uN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);

        inItView();
        inItListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences mySharedPreference = getSharedPreferences(getString(R.string.my_preference), Context.MODE_PRIVATE);
        String fN = mySharedPreference.getString(AppConstant.firstName, " ");
        String lN = mySharedPreference.getString(AppConstant.lastName, " ");
        String pN = mySharedPreference.getString(AppConstant.phoneNumber, " ");
        String eA = mySharedPreference.getString(AppConstant.emailAddress, " ");
        String uN = mySharedPreference.getString(AppConstant.username, " ");


        firstNameEditText.setText(fN);
        lastNameEditText.setText(lN);
        phoneNumberEditText.setText(pN);
        emailAddressEditText.setText(eA);
        usernameEditText.setText(uN);
    }

    public void inItView() {
        backArrow = findViewById(R.id.arrow_back);
        firstNameEditText = findViewById(R.id.et_first_name);
        lastNameEditText = findViewById(R.id.et_last_name);
        phoneNumberEditText = findViewById(R.id.et_phone_number);
        emailAddressEditText = findViewById(R.id.et_email_address);
        usernameEditText = findViewById(R.id.et_username);
        saveChangeButton = findViewById(R.id.btn_save_change);
    }

    public void inItListener() {
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Profile_page.this, Settings_page.class);
                startActivity(myIntent);
            }
        });

        saveChangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveData();
                Toast.makeText(Profile_page.this, "Data Saved", Toast.LENGTH_SHORT).show();
            }
        });

        loadData();
        updateData();

    }
     public void saveData(){
        SharedPreferences mySharedPreference = getSharedPreferences(getString(R.string.my_preference), Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = mySharedPreference.edit();
        myEditor.putString(AppConstant.firstName, firstNameEditText.getText().toString().trim());
        myEditor.putString(AppConstant.lastName, lastNameEditText.getText().toString().trim());
        myEditor.putString(AppConstant.phoneNumber, phoneNumberEditText.getText().toString().trim());
        myEditor.putString(AppConstant.emailAddress, emailAddressEditText.getText().toString().trim());
        myEditor.putString(AppConstant.username, usernameEditText.getText().toString().trim());
        myEditor.apply();

    }

    public void loadData(){
        SharedPreferences mySharedPreference = getSharedPreferences(getString(R.string.my_preference), Context.MODE_PRIVATE);
         fN = mySharedPreference.getString(AppConstant.firstName, " ");
         lN = mySharedPreference.getString(AppConstant.lastName, " ");
         pN = mySharedPreference.getString(AppConstant.phoneNumber, " ");
         eA = mySharedPreference.getString(AppConstant.emailAddress, " ");
         uN = mySharedPreference.getString(AppConstant.username, " ");
    }

    public void updateData(){
        firstNameEditText.setText(fN);
        lastNameEditText.setText(lN);
        phoneNumberEditText.setText(pN);
        emailAddressEditText.setText(eA);
        usernameEditText.setText(uN);
    }


}

