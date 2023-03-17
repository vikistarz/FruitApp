package com.example.mysimplelayouts.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mysimplelayouts.R;

import java.text.NumberFormat;

public class Cucumber_page extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner mySpinner;
    private View backArrow, descriptionArrow;
    private Button decrementButton, incrementButton, cart;
    private TextView quantityTextView, cucumberPriceTextView, cucumberTextView;

    int quantity = 1;

    String lagos [] = {"Select", "Agege", "Alimosho", "Ajeromi/Ifelodun", "Amuwo Odofin", "Apapa", "Badagry",
            "Epe", "Eti Osa", "Ibeju Lekki", "Ifako/Ijaye", "Ikeja", "Ikorudu", "Kosofe", "Lagos Island",
            "Lagos Mainland", "Mushin", "Ojo", "Oshodi/Isolo", "Shomolu", "Surulere"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cucumber_page);

        inItView();
        inItListener();
        adapter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences mySharedPreference = getSharedPreferences(getString(R.string.my_preference), Context.MODE_PRIVATE);
        String cucumberText = mySharedPreference.getString(AppConstant.cucumberText, "");
        int cucumberPrice = mySharedPreference.getInt(AppConstant.cucumberPrice, 0);


    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences mySharedPreference = getSharedPreferences(getString(R.string.my_preference), Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = mySharedPreference.edit();
        myEditor.putString(AppConstant.cucumberText, cucumberTextView.getText().toString());
        myEditor.putInt(AppConstant.cucumberPrice, quantity * 200);
        myEditor.apply();

    }

    private void inItView(){
        backArrow = findViewById(R.id.arrow_back);
        decrementButton = findViewById(R.id.btn_decrement);
        incrementButton = findViewById(R.id.btn_increment);
        quantityTextView = findViewById(R.id.tv_quantity);
        descriptionArrow = findViewById(R.id.description_arrow);
        mySpinner = findViewById(R.id.spinner);
        cart = findViewById(R.id.btn_catalogue);
        cucumberPriceTextView = findViewById(R.id.tv_cucumber_price);
        cucumberTextView = findViewById(R.id.tv_cucumber);
    }

    public void inItListener(){
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Cucumber_page.this, DashBoard_page.class);
                startActivity(myIntent);
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Cucumber_page.this, Cart_page.class);
                startActivity(myIntent);
            }
        });

        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity = quantity - 1;
                displayQuantity(quantity);
                displayPrice( quantity * 200);

            }
        });

        descriptionArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Cucumber_page.this, CucumberDescription.class);
                startActivity(myIntent);
            }
        });

        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity = quantity + 1;
                displayQuantity(quantity);
                displayPrice( quantity * 200);


            }
        });
    }
    public void displayQuantity(int number){

        quantityTextView.setText(" " + number);
    }

    public void displayPrice(int number){
        cucumberPriceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    public void adapter(){

        ArrayAdapter myArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lagos);
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
