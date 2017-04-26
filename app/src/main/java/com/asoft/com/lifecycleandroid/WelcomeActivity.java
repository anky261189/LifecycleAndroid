package com.asoft.com.lifecycleandroid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {

    public static final String PREF_NAME="LOGIN_PREF";
    private boolean doubleBackToExitPressedOnce;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        SharedPreferences sharedPreferences=getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
       String name=sharedPreferences.getString("name","name");
      String email=sharedPreferences.getString("email","email");
      String mobile=sharedPreferences.getString("mobile","mobile");
      String password=sharedPreferences.getString("password","password");

        Toast.makeText(WelcomeActivity.this, "Name : "+name+"\n"+email+"\n"+mobile+"\n"+password, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();

            Intent intent=new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();


            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();


        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;


            }


        },2000);

    }
}
