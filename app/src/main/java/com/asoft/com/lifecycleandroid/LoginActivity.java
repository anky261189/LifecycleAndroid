
package com.asoft.com.lifecycleandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    EditText loginEmail, loginPassword;
    Button login;
    public static final String PREF_NAME = "LOGIN_PREF";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginEmail = (EditText) findViewById(R.id.edtloginEmailId);
        loginPassword = (EditText) findViewById(R.id.edtloginPwd);
        login = (Button) findViewById(R.id.btnLoginId);
    }

    @Override
    protected void onStart() {
        super.onStart();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
                String emailPref = sharedPreferences.getString("email", "");
                String pwdPref = sharedPreferences.getString("password", "");
                String email = loginEmail.getText().toString();
                String pwd = loginPassword.getText().toString();
                Toast.makeText(LoginActivity.this, "hello" + emailPref + " " + pwdPref+" "+email+" "+pwd, Toast.LENGTH_SHORT).show();


                if (email.equals(emailPref) && pwd.equals(pwdPref)) {
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putBoolean("signup",true);
                    editor.commit();
                    Intent loginIntent = new Intent(LoginActivity.this, WelcomeActivity.class);
                    startActivity(loginIntent);

                } else
                    Toast.makeText(LoginActivity.this, "Enter Correct Email and Password", Toast.LENGTH_SHORT).show();


            }
        });
    }
}
