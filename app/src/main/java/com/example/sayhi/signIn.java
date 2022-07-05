package com.example.sayhi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class signIn extends AppCompatActivity implements View.OnClickListener{

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.forgetPass:
                startActivity(new Intent(this, forgetPass.class));
                break;

            case R.id.newAcc:
                startActivity(new Intent(this, newAcc.class));
                break;


        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        getSupportActionBar().hide();

        TextView forgetPass  = findViewById(R.id.forgetPass);
        forgetPass.setOnClickListener((View.OnClickListener) this);

        TextView newAcc  = findViewById(R.id.newAcc);
        newAcc.setOnClickListener((View.OnClickListener) this);

    }
}