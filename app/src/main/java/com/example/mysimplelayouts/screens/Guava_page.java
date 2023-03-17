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

public class Guava_page extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner mySpinner;
    private View backArrow, descriptionArrow;
    private Button decrementButton, incrementButton, cart;
    private TextView quantityTextView, guavaPriceTextView, guavaTextView;

    int quantity = 1;

    String lagos [] = {"Select", "Agege", "Alimosho", "Ajeromi/Ifelodun", "Amuwo Odofin", "Apapa", "Badagry",
            "Epe", "Eti Osa", "Ibeju Lekki", "Ifako/Ijaye", "Ikeja", "Ikorudu", "Kosofe", "Lagos Island",
            "Lagos Mainland", "Mushin", "Ojo", "Oshodi/Isolo", "Shomolu", "Surulere"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guava_page);
        inItView();
        inItListener();
        adapter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences mySharedPreference = getSharedPreferences(getString(R.string.my_preference), Context.MODE_PRIVATE);
        String guavaText = mySharedPreference.getString(AppConstant.guavaText, "");
        int guavaPrice = mySharedPreference.getInt(AppConstant.guavaPrice, 0);

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences mySharedPreference = getSharedPreferences(getString(R.string.my_preference), Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = mySharedPreference.edit();
        myEditor.putString(AppConstant.guavaText, guavaTextView.getText().toString());
        myEditor.putInt(AppConstant.guavaPrice, quantity * 100);
        myEditor.apply();
    }

    private void inItView() {
        backArrow = findViewById(R.id.arrow_back);
        decrementButton = findViewById(R.id.btn_decrement);
        incrementButton = findViewById(R.id.btn_increment);
        quantityTextView = findViewById(R.id.tv_quantity);
        descriptionArrow = findViewById(R.id.description_arrow);
        mySpinner = findViewById(R.id.spinner);
        cart = findViewById(R.id.btn_catalogue);
        guavaPriceTextView = findViewById(R.id.tv_guava_price);
        guavaTextView = findViewById(R.id.tv_guava);
    }

    public void inItListener(){
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Guava_page.this, DashBoard_page.class);
                startActivity(myIntent);
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Guava_page.this, Cart_page.class);
                startActivity(myIntent);
            }
        });

        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity = quantity - 1;
                displayQuantity(quantity);
                displayPrice( quantity * 150);

            }
        });

        descriptionArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Guava_page.this, GuavaDescription.class);
                startActivity(myIntent);
            }
        });

        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity = quantity + 1;
                displayQuantity(quantity);
                displayPrice( quantity * 150);


            }
        });
    }
    public void displayQuantity(int number){

        quantityTextView.setText(" " + number);
    }

    public void displayPrice(int number){
        guavaPriceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
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
