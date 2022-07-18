package com.example.sayhi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class newAcc extends AppCompatActivity implements View.OnClickListener{

    EditText phoneBox ;
    FirebaseAuth mAuth;
    TextView userPhoneNumber;
    String number,verificationID;


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(@NonNull View v) {
        switch (v.getId()){
            case R.id.generateOTPBtn:
                continueButton();
                break;

            case R.id.logIn:
                startActivity(new Intent(this, signIn.class));
                finish();
        }

    }

    private void continueButton() {
        String phoneNumber = phoneBox.getText().toString().trim();
        if(phoneNumber.isEmpty()){
            phoneBox.setError("Enter your phone number");
            phoneBox.requestFocus();
            return;
        }
        Intent intent = new Intent(this, verifyNo.class);
        number = phoneBox.getText().toString();
        intent.putExtra("message", number);
        startActivity(intent);
    }



    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_acc);

        Objects.requireNonNull(getSupportActionBar()).hide();

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Create a new Account");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_navigate_before_24);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        TextView logIn = findViewById(R.id.logIn);
        logIn.setOnClickListener(this);

        phoneBox = findViewById(R.id.phoneBox);
        Button continueButton = findViewById(R.id.generateOTPBtn);
        continueButton.setOnClickListener(this);


    }
}