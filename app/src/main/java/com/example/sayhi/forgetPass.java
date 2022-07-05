package com.example.sayhi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

public class forgetPass extends AppCompatActivity implements View.OnClickListener{

    EditText phoneBox1 ;
    String number1;
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(@NonNull View v) {
        if (v.getId() == R.id.continueBtn) {
            continueBtn();
        }

    }

    private void continueBtn() {
        String phoneNumber1 = phoneBox1.getText().toString().trim();
        if(phoneNumber1.isEmpty()){
            phoneBox1.setError("Enter your phone number!");
            phoneBox1.requestFocus();
            return;
        }
        Intent intent = new Intent(this, verifyNo.class);
        number1 = phoneBox1.getText().toString();
        intent.putExtra("message", number1);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);

        Objects.requireNonNull(getSupportActionBar()).hide();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Forget Password");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_navigate_before_24);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        phoneBox1 = findViewById(R.id.phoneBox1);
        Button continueBtn = findViewById(R.id.continueBtn);
        continueBtn.setOnClickListener(this);
    }
}