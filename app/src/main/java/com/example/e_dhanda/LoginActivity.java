package com.example.e_dhanda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText usrname,pass;
    Button butnlogin;
    TextView signup;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);
        usrname = (EditText)findViewById(R.id.et_Email);
        pass = (EditText)findViewById(R.id.Password);
        butnlogin = (Button) findViewById(R.id.Login_btn);
        signup = (TextView) findViewById(R.id.SignUp);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(registerIntent);
            }
        });
            butnlogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String usr = usrname.getText().toString().trim();
                    String pwd = pass.getText().toString().trim()
                    Boolean res = db.checkUser(usr,pwd);

                    if (res){
                        Toast.makeText(LoginActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(LoginActivity.this,"Login Error",Toast.LENGTH_SHORT).show();
                }
            });
    }
}