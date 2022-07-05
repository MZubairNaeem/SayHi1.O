package com.example.sayhi;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Objects;

public class verifyNo extends AppCompatActivity {

    TextView userPhoneNumber;
    String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_no);

        Objects.requireNonNull(getSupportActionBar()).hide();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Verify Number");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_navigate_before_24);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        userPhoneNumber = findViewById(R.id.userPhoneNumber);
        number=getIntent().getExtras().getString("message");
        userPhoneNumber.setText(number);
    }
}