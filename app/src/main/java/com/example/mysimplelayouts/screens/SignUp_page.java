package com.example.mysimplelayouts.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mysimplelayouts.R;

public class SignUp_page extends AppCompatActivity {

    //this is how to instantiate the widgets you used in your xml file;

    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText phoneNumberEditText;
    private EditText emailAddressEditText;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button signInButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_page);

      inItView();
      inItListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences mySharedPreference = getSharedPreferences(getString(R.string.my_preference), Context.MODE_PRIVATE);
        String fN = mySharedPreference.getString(AppConstant.firstName, "");
        String lN = mySharedPreference.getString(AppConstant.lastName, "");
        String pN = mySharedPreference.getString(AppConstant.phoneNumber, "");
        String eA = mySharedPreference.getString(AppConstant.emailAddress, "");
        String uN = mySharedPreference.getString(AppConstant.username, "");
        String pW = mySharedPreference.getString(AppConstant.password, "");


    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences mySharedPreference = getSharedPreferences(getString(R.string.my_preference), Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = mySharedPreference.edit();
        myEditor.putString(AppConstant.firstName, firstNameEditText.getText().toString().trim());
        myEditor.putString(AppConstant.lastName, lastNameEditText.getText().toString().trim());
        myEditor.putString(AppConstant.phoneNumber, phoneNumberEditText.getText().toString().trim());
        myEditor.putString(AppConstant.emailAddress, emailAddressEditText.getText().toString().trim());
        myEditor.putString(AppConstant.username, usernameEditText.getText().toString().trim());
        myEditor.putString(AppConstant.password, passwordEditText.getText().toString().trim());
        myEditor.apply();

    }

    public void inItView(){
        firstNameEditText = findViewById(R.id.et_first_name);
        lastNameEditText = findViewById(R.id.et_last_name);
        phoneNumberEditText = findViewById(R.id.et_phone_number);
        emailAddressEditText = findViewById(R.id.email_address);
        usernameEditText = findViewById(R.id.et_username);
        passwordEditText = findViewById(R.id.et_password);
        signInButton = findViewById(R.id.btn_sign_in);
    }

    public void inItListener(){

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(validateFirstName() & validateLastName() & validatePhoneNumber() & validateEmailAddress() & validateUsername() & validatePassword()){
                    Intent myIntent = new Intent(SignUp_page. this, LogIn_page. class);
                    startActivity(myIntent);
                }

            }
        });

    }

    private boolean validateFirstName() {
            String retrievalFirstName = firstNameEditText.getText().toString().trim();
            String acceptableAlphabets = "^([a-zA-Z]*)$";

            if (retrievalFirstName.isEmpty()) {
                firstNameEditText.setError("Can't be empty");
                return false;
            }
            else if (retrievalFirstName.length() < 3) {
                firstNameEditText.setError("Name too short");
                return false;
            } else if (!retrievalFirstName.matches(acceptableAlphabets)) {
                firstNameEditText.setError("Must only be in alphabets");
                return false;
            }
            return true;
        }

        private boolean validateLastName() {
            String retrievalLastName = lastNameEditText.getText().toString().trim();
            String acceptableAlphabets = "^([a-zA-Z]*)$";

            if (retrievalLastName.isEmpty()) {
                lastNameEditText.setError("Can't be empty");
                return false;
            }
            else if (retrievalLastName.length() < 3) {
                lastNameEditText.setError("Name too short");
                return false;
            } else if (!retrievalLastName.matches(acceptableAlphabets)) {
                lastNameEditText.setError("Must only be in alphabets");
                return false;
            }
            return true;
        }

        private boolean validatePhoneNumber() {
            String retrievalPhoneNumber = phoneNumberEditText.getText().toString().trim();
            String acceptableNumbers = "^([0-9]*)$";

            if (retrievalPhoneNumber.isEmpty()) {
                phoneNumberEditText.setError("Can't be empty");
                return false;
            }
            else if (retrievalPhoneNumber.length() < 11) {
                phoneNumberEditText.setError("Number typed invalid");
                return false;
            } else if (!retrievalPhoneNumber.matches(acceptableNumbers)) {
                phoneNumberEditText.setError("must only be numbers");
                return false;
            }
            return true;
        }

        private boolean validateEmailAddress() {
            String retrievalEmailAddress = emailAddressEditText.getText().toString().trim();
            String acceptableEmail = "^([a-zA-Z@_.com\\d]*)$";


            if (retrievalEmailAddress.isEmpty()) {
                emailAddressEditText.setError("Can't be empty");
                return false;
            }
            else if (retrievalEmailAddress.length() < 11) {
                emailAddressEditText.setError("Invalid email");
                return false;
            } else if (!retrievalEmailAddress.matches(acceptableEmail)) {
                emailAddressEditText.setError("Invalid email");
                return false;
            }
            return true;
        }


        private boolean validateUsername() {
            String retrievalUsername = usernameEditText.getText().toString().trim();
            String alphaNumericNumbers = "^([a-zA-Z][a-zA-Z$+._\\d]*)$";

            if (retrievalUsername.isEmpty()) {
                usernameEditText.setError("Can't be empty");
                return false;
            }
            else if (retrievalUsername.length() < 4) {
                usernameEditText.setError("username too short");
                return false;
            } else if (!retrievalUsername.matches(alphaNumericNumbers)) {
                usernameEditText.setError("username too weak");
                return false;
            }
            return true;
        }


        private boolean validatePassword() {
            String retrievalPassword = passwordEditText.getText().toString().trim();
            String acceptablePassword = "^([a-zA-Z@#?$+._\\d]*)$";

            if (retrievalPassword.isEmpty()) {
                passwordEditText.setError("Can't be empty");
                return false;
            }
            else if (retrievalPassword.length() < 6) {
                passwordEditText.setError("password too short");
                return false;
            } else if (!retrievalPassword.matches(acceptablePassword)) {
                passwordEditText.setError("too weak, requires letter, number or symbol");
                return false;
            }
            return true;
        }


    }















      // signInButton.setOnClickListener(new View.OnClickListener() {
          //  @Override
           // public void onClick(View view) {

             //   Intent email = new Intent(Intent.ACTION_SEND);
           //     email.putExtra(Intent.EXTRA_EMAIL, new String[]{ "emiewovictor@gmail.com"});
           //     email.putExtra(Intent.EXTRA_SUBJECT, "victor");
            //    email.putExtra(Intent.EXTRA_TEXT, "please send the attached file to Mr shawn potter.");

                //need this to prompts email client only

            //    email.setType("message/rfc822");

              //  startActivity(Intent.createChooser (email, "emiewovictor@gmail.com"));


               // Intent intent = new Intent(ACTION_VIEW, Uri.parse("https://www.google.com"));
              //  startActivity(intent);
              //// Toast.makeText(SignUP.this, "please wait", Toast.LENGTH_SHORT).show();
               /// Intent myIntent = new Intent(SignUP.this, LogIn.class);

          //  }
     //   });









