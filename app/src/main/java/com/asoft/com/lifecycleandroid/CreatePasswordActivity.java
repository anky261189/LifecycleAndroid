package com.asoft.com.lifecycleandroid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreatePasswordActivity extends AppCompatActivity {

    EditText password;
    Button submit;
    public static final String PREF_NAME="LOGIN_PREF";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_password);
        password=(EditText)findViewById(R.id.edtPasswordId);
        submit=(Button)findViewById(R.id.btnCreateSubmit);
    }

    @Override
    protected void onStart() {
        super.onStart();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String pwd=password.getText().toString();
                SharedPreferences sharedPreferences=getSharedPreferences(PREF_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("password",pwd);
                editor.commit();


                Intent submitIntent=new Intent(CreatePasswordActivity.this,LoginActivity.class);
                startActivity(submitIntent);
            }
        });

    }
}
