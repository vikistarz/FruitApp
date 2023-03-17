package com.example.mysimplelayouts.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.mysimplelayouts.R;

public class Activation_page extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner mySpinner;
    private EditText emailEditText;
    private Button activationButton;
    private View backArrow;

    String activation [] = {"Select", "Deactivate", "Reactivate"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activation_page);

        inItView();
        adapter();
        inItListener();
    }

    public void inItView(){
        mySpinner = findViewById(R.id.spinner);
        backArrow = findViewById(R.id.arrow_back);
    }
    public void inItListener(){
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Activation_page.this, LogIn_page.class);
                startActivity(myIntent);
            }
        });

    }

    public void adapter(){

        ArrayAdapter myArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, activation);
        myArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myArrayAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}