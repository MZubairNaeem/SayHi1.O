package com.example.sayhi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import java.util.Arrays;

public class signIn extends AppCompatActivity implements View.OnClickListener{

    View facebookLogin;

    CallbackManager callbackManager;
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

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        getSupportActionBar().hide();
        callbackManager = CallbackManager.Factory.create();

        callbackManager = CallbackManager.Factory.create();

            AccessToken accessToken = AccessToken.getCurrentAccessToken();
            if (accessToken!=null && accessToken.isExpired()==false){
                startActivity(new Intent(signIn.this,profileSettings.class));
                finish();
            }
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        startActivity(new Intent(signIn.this,profileSettings.class));
                        finish();
                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                    }
                });

        TextView forgetPass  = findViewById(R.id.forgetPass);
        forgetPass.setOnClickListener((View.OnClickListener) this);

        TextView newAcc  = findViewById(R.id.newAcc);
        newAcc.setOnClickListener((View.OnClickListener) this);

        facebookLogin = findViewById(R.id.facebookLogin);
        facebookLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LoginManager.getInstance().logInWithReadPermissions(signIn.this, Arrays.asList("public_profile"));
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}