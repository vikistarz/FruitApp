package com.example.mysimplelayouts.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.mysimplelayouts.R;

public class LogIn_page extends AppCompatActivity {

    private EditText emailAddressEditText, passwordEditText;
    private Button  logInButton;
    private TextView forgetPassword, createNewAccount, reviveOrDestroyAcct;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_page);

        inItView();
        inItListener();

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences mySharedPreference = getSharedPreferences(getString(R.string.my_preference), Context.MODE_PRIVATE);
        String email = mySharedPreference.getString(AppConstant.emailAddress, " ");
        String password = mySharedPreference.getString(AppConstant.password," ");


        emailAddressEditText.setText(email);
        passwordEditText.setText(password);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences mySharedPreference = getSharedPreferences(getString(R.string.my_preference), Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = mySharedPreference.edit();
        myEditor.putString(AppConstant.emailAddress, emailAddressEditText.getText().toString().trim());
        myEditor.putString(AppConstant.password, passwordEditText.getText().toString().trim());
        myEditor.apply();
    }

    private void inItView(){
        emailAddressEditText = findViewById(R.id.et_email_address);
        passwordEditText = findViewById(R.id.et_password);
        logInButton = findViewById(R.id.btn_log_in);
        forgetPassword = findViewById(R.id.tv_forget_password);
        createNewAccount = findViewById(R.id.tv_create_new_account);
        reviveOrDestroyAcct = findViewById(R.id.tv_acct_revival_destroy);
    }

    private void inItListener(){
        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(validateEmailAddress() & validatePassword()){
                    Intent myIntent = new Intent(LogIn_page. this, DashBoard_page. class);
                    startActivity(myIntent);
                }

            }
        });

        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent weIntent = new Intent(LogIn_page.this, ForgetPassword_page.class);
                startActivity(weIntent);

            }
        });


        createNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent herIntent = new Intent(LogIn_page. this, SignUp_page. class);
                startActivity(herIntent);


            }
        });
        reviveOrDestroyAcct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  soIntent = new Intent(LogIn_page. this, Activation_page. class);
                startActivity(soIntent);

            }
        });
    }

    private boolean validateEmailAddress() {
        String retrievalEmailAddress = emailAddressEditText.getText().toString().trim();
        if (retrievalEmailAddress.isEmpty()) {
            emailAddressEditText.setError("Can't be empty");
            return false;
        }
//        else if (AppConstant.emailAddress != retrievalEmailAddress) {
//            emailAddressEditText.setError("Invalid email");
//            return false;
//        }
        return true;
    }

    private boolean validatePassword() {
        String retrievalPassword = passwordEditText.getText().toString().trim();
        if (retrievalPassword.isEmpty()) {
            passwordEditText.setError("Can't be empty");
            return false;
        }
//        else if(AppConstant.password != retrievalPassword){
//            passwordEditText.setError("invalid password");
//            return false;
//        }
        return true;
    }


}
