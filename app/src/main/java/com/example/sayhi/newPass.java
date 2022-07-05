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

public class newPass extends AppCompatActivity implements View.OnClickListener {

    EditText password,confirmPass;

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(@NonNull View v) {
        if (v.getId() == R.id.continueBtn2) {
            continueBtn2();
        }

    }

    private void continueBtn2() {
        String pass = password.getText().toString().trim();
        String confirmPassword = confirmPass.getText().toString().trim();
        if(pass.isEmpty()){
            password.setError("Enter 8 character password!");
            password.requestFocus();
            return;
        }
        if(pass.length()<8){
            password.setError("Password must be at least 8 characters!");
            password.requestFocus();
            return;
        }
        if(confirmPassword.isEmpty()){
            confirmPass.setError("Enter confirm password!");
            confirmPass.requestFocus();
            return;
        }
        if(!pass.equals(confirmPassword)){
            confirmPass.setError("Confirm password doesn't match!");
            confirmPass.requestFocus();
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_pass);

        Objects.requireNonNull(getSupportActionBar()).hide();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Set Password");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_navigate_before_24);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        password = findViewById(R.id.pass);
        confirmPass = findViewById(R.id.confirmPass);

        Button button = findViewById(R.id.continueBtn2);
        button.setOnClickListener(this);

    }
}