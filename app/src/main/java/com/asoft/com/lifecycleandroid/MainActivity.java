package com.asoft.com.lifecycleandroid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,email,mobile;
    Button signUp;
    public static final String PREF_NAME="LOGIN_PREF";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.edtName);
        email=(EditText)findViewById(R.id.edtEmail);
        mobile=(EditText)findViewById(R.id.edtMobile);
        signUp=(Button)findViewById(R.id.btnSignUp);



        Toast.makeText(MainActivity.this, "App created", Toast.LENGTH_SHORT).show();
    }

    /* onStart Method*/

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this, "App started", Toast.LENGTH_SHORT).show();
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name1= name.getText().toString();
                String email1=email.getText().toString();
                String mobile1=mobile.getText().toString();

                SharedPreferences sharedPreferences=getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("name",name1);
                editor.putString("email",email1);
                editor.putString("mobile",mobile1);
                editor.commit();

                    Intent createPwdIntent=new Intent(MainActivity.this,WelcomeActivity.class);
                    startActivity(createPwdIntent);


            }
        });





    }



    /* onResume Method*/
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this, "App resumed", Toast.LENGTH_SHORT).show();
    }


      /* onPause Method*/
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this, "App paused", Toast.LENGTH_SHORT).show();
    }


      /* onStop Method*/
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this, "App stopped", Toast.LENGTH_SHORT).show();
    }

      /* onRestart Method*/

    @Override
    protected void onRestart() {
        super.onRestart();

        Toast.makeText(MainActivity.this, "App restarted", Toast.LENGTH_SHORT).show();
    }

      /* onDestroy Method*/

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(MainActivity.this, "App Destroyed", Toast.LENGTH_SHORT).show();
    }


}
