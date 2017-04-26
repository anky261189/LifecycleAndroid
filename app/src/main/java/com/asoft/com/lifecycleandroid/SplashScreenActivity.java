package com.asoft.com.lifecycleandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPreferences=getSharedPreferences(MainActivity.PREF_NAME,MODE_PRIVATE);
        Boolean isSignUp=sharedPreferences.getBoolean("signup",false);
        if ((isSignUp)){
            Intent createPwdIntent=new Intent(SplashScreenActivity.this,WelcomeActivity.class);
            startActivity(createPwdIntent);
        }else {
            Intent createPwdIntent = new Intent(SplashScreenActivity.this, MainActivity.class);
            startActivity(createPwdIntent);
        }
    }
}
