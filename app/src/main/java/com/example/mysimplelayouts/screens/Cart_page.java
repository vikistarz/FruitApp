package com.example.mysimplelayouts.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mysimplelayouts.R;
import com.example.mysimplelayouts.utils.AppPreferenceHelper;

import java.text.NumberFormat;

public class Cart_page extends AppCompatActivity {
    private View backArrow;
    private TextView subtotalPrice, applePriceTextView, appleTextView, bananaPriceTextView, bananaTextView, guavaPriceTextView, guavaTextView;
    private TextView cucumberPriceTextView, cucumberTextView, mangoPriceTextView, mangoTextView, orangePriceTextView, orangeTextView;
    private TextView pawpawPriceTextView, pawpawTextView, pineapplePriceTextView, pineappleTextView, watermelonPriceTextView, watermelonTextView;
    private Button checkList, clearButtonOne, clearButtonTwo, clearButtonThree, clearButtonFour, clearButtonFive;
    private Button clearButtonSix, clearButtonSeven, clearButtonEight, clearButtonNine;

   private int apple, banana, cucumber, guava, mango, orange, pineapple, pawpaw, watermelon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_page);
        inItView();
        displaySubtotal();
        inItListener();
    }

    public void inItView() {
        backArrow = findViewById(R.id.arrow_back);
        subtotalPrice = findViewById(R.id.tv_totalPrice);
        applePriceTextView = findViewById(R.id.tv_apple_price);
        appleTextView = findViewById(R.id.tv_apple);
        bananaPriceTextView = findViewById(R.id.tv_banana_price);
        bananaTextView = findViewById(R.id.tv_banana);
        cucumberPriceTextView = findViewById(R.id.tv_cucumber_price);
        cucumberTextView = findViewById(R.id.tv_cucumber);
        guavaPriceTextView = findViewById(R.id.tv_guava_price);
        guavaTextView = findViewById(R.id.tv_guava);
        mangoPriceTextView = findViewById(R.id.tv_mango_price);
        mangoTextView = findViewById(R.id.tv_mango);
        orangePriceTextView = findViewById(R.id.tv_orange_price);
        orangeTextView = findViewById(R.id.tv_orange);
        pawpawPriceTextView = findViewById(R.id.tv_pawpaw_price);
        pawpawTextView = findViewById(R.id.tv_pawpaw);
        pineapplePriceTextView = findViewById(R.id.tv_pineapple_price);
        pineappleTextView = findViewById(R.id.tv_pineapple);
        watermelonPriceTextView = findViewById(R.id.tv_watermelon_price);
        watermelonTextView = findViewById(R.id.tv_watermelon);
        checkList = findViewById(R.id.btn_checkout);
        clearButtonOne = findViewById(R.id.btn_clear1);
        clearButtonTwo = findViewById(R.id.btn_clear2);
        clearButtonThree = findViewById(R.id.btn_clear3);
        clearButtonFour = findViewById(R.id.btn_clear4);
        clearButtonFive = findViewById(R.id.btn_clear5);
        clearButtonSix = findViewById(R.id.btn_clear6);
        clearButtonSeven = findViewById(R.id.btn_clear7);
        clearButtonEight = findViewById(R.id.btn_clear8);
        clearButtonNine = findViewById(R.id.btn_clear9);
    }

    public void inItListener() {

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Cart_page.this, DashBoard_page.class);
                startActivity(myIntent);
            }
        });


        clearButtonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pawpawPriceTextView.setText("");
                pawpawTextView.setText("");
                AppPreferenceHelper.clearPrefValue(Cart_page.this, AppConstant.pawpawPrice);
                AppPreferenceHelper.clearPrefValue(Cart_page.this, AppConstant.pawpawText);
//AppPreferenceHelper.savePrefValue(Cart_page.this,AppConstant.pawpawText,"sdjfklsdj");
            }
        });

        clearButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mangoPriceTextView.setText("");
                mangoTextView.setText("");
                AppPreferenceHelper.clearPrefValue(Cart_page.this, AppConstant.mangoPrice);
                AppPreferenceHelper.clearPrefValue(Cart_page.this, AppConstant.mangoText);
            }
        });

        clearButtonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                watermelonPriceTextView.setText("");
                watermelonTextView.setText("");
                AppPreferenceHelper.clearPrefValue(Cart_page.this, AppConstant.watermelonPrice);
                AppPreferenceHelper.clearPrefValue(Cart_page.this, AppConstant.watermelonText);
            }
        });

        clearButtonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pineapplePriceTextView.setText("");
                pineappleTextView.setText("");
                AppPreferenceHelper.clearPrefValue(Cart_page.this, AppConstant.pineapplePrice);
                AppPreferenceHelper.clearPrefValue(Cart_page.this, AppConstant.pineappleText);
            }
        });

        clearButtonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bananaPriceTextView.setText("");
                bananaTextView.setText("");
                AppPreferenceHelper.clearPrefValue(Cart_page.this, AppConstant.bananaPrice);
                AppPreferenceHelper.clearPrefValue(Cart_page.this, AppConstant.bananaText);
            }
        });

        clearButtonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guavaPriceTextView.setText("");
                guavaTextView.setText("");
                AppPreferenceHelper.clearPrefValue(Cart_page.this, AppConstant.guavaPrice);
                AppPreferenceHelper.clearPrefValue(Cart_page.this, AppConstant.guavaText);
            }
        });

        clearButtonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cucumberPriceTextView.setText("");
                cucumberTextView.setText("");
                AppPreferenceHelper.clearPrefValue(Cart_page.this, AppConstant.cucumberPrice);
                AppPreferenceHelper.clearPrefValue(Cart_page.this, AppConstant.cucumberText);
            }
        });

        clearButtonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applePriceTextView.setText("");
                appleTextView.setText("");
                AppPreferenceHelper.clearPrefValue(Cart_page.this, AppConstant.applePrice);
                AppPreferenceHelper.clearPrefValue(Cart_page.this, AppConstant.appleText);
            }
        });

        clearButtonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orangePriceTextView.setText("");
                orangeTextView.setText("");
                AppPreferenceHelper.clearPrefValue(Cart_page.this, AppConstant.orangePrice);
                AppPreferenceHelper.clearPrefValue(Cart_page.this, AppConstant.orangeText);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences mySharedPreference = getSharedPreferences(getString(R.string.my_preference), Context.MODE_PRIVATE);
        String appleText = mySharedPreference.getString(AppConstant.appleText, "");
        int applePrice = mySharedPreference.getInt(AppConstant.applePrice, 0);
        String bananaText = mySharedPreference.getString(AppConstant.bananaText, "");
        int bananaPrice = mySharedPreference.getInt(AppConstant.bananaPrice, 0);
        String cucumberText = mySharedPreference.getString(AppConstant.cucumberText, "");
        int cucumberPrice = mySharedPreference.getInt(AppConstant.cucumberPrice, 0);
        String guavaText = mySharedPreference.getString(AppConstant.guavaText, "");
        int guavaPrice = mySharedPreference.getInt(AppConstant.guavaPrice, 0);
        String mangoText = mySharedPreference.getString(AppConstant.mangoText, "");
        int mangoPrice = mySharedPreference.getInt(AppConstant.mangoPrice, 0);
        String orangeText = mySharedPreference.getString(AppConstant.orangeText, "");
        int orangePrice = mySharedPreference.getInt(AppConstant.orangePrice, 0);
        String pawpawText = mySharedPreference.getString(AppConstant.pawpawText, "");
        int pawpawPrice = mySharedPreference.getInt(AppConstant.pawpawPrice, 0);
        String pineappleText = mySharedPreference.getString(AppConstant.pineappleText, "");
        int pineapplePrice = mySharedPreference.getInt(AppConstant.pineapplePrice, 0);
        String watermelonText = mySharedPreference.getString(AppConstant.watermelonText, "");
        int watermelonPrice = mySharedPreference.getInt(AppConstant.watermelonPrice, 0);
        int totalPrice = mySharedPreference.getInt(AppConstant.totalPrice, 0);
//        int result = mySharedPreference.getInt("key", 0);


        appleTextView.setText(appleText);
        applePriceTextView.setText(applePrice);
        bananaTextView.setText(bananaText);
        bananaPriceTextView.setText(bananaPrice);
        cucumberTextView.setText(cucumberText);
        cucumberPriceTextView.setText(cucumberPrice);
        guavaTextView.setText(guavaText);
        guavaPriceTextView.setText(guavaPrice);
        mangoTextView.setText(mangoText);
        mangoPriceTextView.setText(mangoPrice);
        orangeTextView.setText(orangeText);
        orangePriceTextView.setText(orangePrice);
        pawpawTextView.setText(pawpawText);
        pawpawPriceTextView.setText(pawpawPrice);
        pineappleTextView.setText(pineappleText);
        pineapplePriceTextView.setText(pineapplePrice);
        watermelonTextView.setText(watermelonText);
        watermelonPriceTextView.setText(watermelonPrice);
        subtotalPrice.setText(totalPrice);

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences mySharedPreference = getSharedPreferences(getString(R.string.my_preference), Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = mySharedPreference.edit();
        myEditor.putInt(AppConstant.totalPrice, apple + banana + cucumber + guava + mango + orange + pawpaw + pineapple + watermelon);
        myEditor.apply();
    }

    public void displaySubtotal(){
        String acceptableValues = "^([a-zA-Z@#₦?$+._\\d]*)$";

        if (applePriceTextView.getText().toString().trim()!=null){
            apple = Integer.parseInt(applePriceTextView.getText().toString());
        }
        else if (applePriceTextView.getText().toString().trim().length()>2){
            apple  = Integer.parseInt(applePriceTextView.getText().toString());
        }
        else if (applePriceTextView.getText().toString().trim().matches(acceptableValues)){
            apple = Integer.parseInt(applePriceTextView.getText().toString());
        }
        else {
            apple = 0;
        }


        if (bananaPriceTextView.getText().toString().trim()!=null){
            banana = Integer.parseInt(bananaPriceTextView.getText().toString());
        }
        else if (bananaPriceTextView.getText().toString().trim().length()>2){
            banana  = Integer.parseInt(bananaPriceTextView.getText().toString());
        }
        else if (bananaPriceTextView.getText().toString().trim().matches(acceptableValues)){
            banana = Integer.parseInt(bananaPriceTextView.getText().toString());
        }
        else {
            banana = 0;
        }


        if (cucumberPriceTextView.getText().toString().trim()!=null){
            cucumber = Integer.parseInt(cucumberPriceTextView.getText().toString());
        }
        else if (cucumberPriceTextView.getText().toString().trim().length()>2){
        }
        else if (cucumberPriceTextView.getText().toString().trim().matches(acceptableValues)){
            cucumber = Integer.parseInt(cucumberPriceTextView.getText().toString());
        }

        else {
            cucumber = 0;
       }



        if (guavaPriceTextView.getText().toString().trim()!=null){
            guava = Integer.parseInt(guavaPriceTextView.getText().toString());
        }
        else if (guavaPriceTextView.getText().toString().trim().length()>2){
            guava  = Integer.parseInt(guavaPriceTextView.getText().toString());
        }
        else if (guavaPriceTextView.getText().toString().trim().matches(acceptableValues)){
            guava = Integer.parseInt(guavaPriceTextView.getText().toString());
        }
        else {
            guava = 0;
        }


        if (mangoPriceTextView.getText().toString().trim()!=null){
            mango = Integer.parseInt(mangoPriceTextView.getText().toString());
       }

        else if (mangoPriceTextView.getText().toString().trim().length()>2){
            mango  = Integer.parseInt(mangoPriceTextView.getText().toString());
        }
        else if (mangoPriceTextView.getText().toString().trim().matches(acceptableValues)){
            mango = Integer.parseInt(mangoPriceTextView.getText().toString());
        }
        else {
            mango = 0;
        }


        if (orangePriceTextView.getText().toString().trim()!=null){
                orange = Integer.parseInt(orangePriceTextView.getText().toString());
            }
        else if (orangePriceTextView.getText().toString().trim().length()>2){
           orange  = Integer.parseInt(orangePriceTextView.getText().toString());
       }
        else if (orangePriceTextView.getText().toString().trim().matches(acceptableValues)){
            orange = Integer.parseInt(orangePriceTextView.getText().toString());
        }
        else {
                orange = 0;
            }



        if (pawpawPriceTextView.getText().toString().trim()!=null){
            pawpaw = Integer.parseInt(pawpawPriceTextView.getText().toString());
        }
        else if (pawpawPriceTextView.getText().toString().trim().length()>2){
            pawpaw  = Integer.parseInt(pawpawPriceTextView.getText().toString());
        }
        else if (pawpawPriceTextView.getText().toString().trim().matches(acceptableValues)){
            pawpaw = Integer.parseInt(pawpawPriceTextView.getText().toString());
        }
        else {
            pawpaw = 0;
        }



        if (pineapplePriceTextView.getText().toString().trim()!=null){
            pineapple = Integer.parseInt(pineapplePriceTextView.getText().toString());
        }
        else if (pineapplePriceTextView.getText().toString().trim().length()>2){
            pineapple  = Integer.parseInt(pineapplePriceTextView.getText().toString());
        }
        else if (pineapplePriceTextView.getText().toString().trim().matches(acceptableValues)){
            pineapple = Integer.parseInt(pineapplePriceTextView.getText().toString());
        }
          else {
            pineapple = 0;
    }


        if (watermelonPriceTextView.getText().toString().trim()!=null){
            watermelon = Integer.parseInt(watermelonPriceTextView.getText().toString());
        }
        else if (watermelonPriceTextView.getText().toString().trim().length()>2){
            watermelon  = Integer.parseInt(watermelonPriceTextView.getText().toString());
        }
        else if (watermelonPriceTextView.getText().toString().trim().matches(acceptableValues)){
            watermelon = Integer.parseInt(watermelonPriceTextView.getText().toString());
        }
        else {
            watermelon = 0;
        }

       int sum = apple + banana + cucumber + guava + mango + orange + pawpaw + pineapple + watermelon;

    subtotalPrice.setText(String.valueOf(sum));
    }

}