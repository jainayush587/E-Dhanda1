package com.example.e_dhanda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    EditText usrname,pass,cnfpass;
    Button butnreg;
    TextView login;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        db = new DatabaseHelper(this);
        usrname = (EditText)findViewById(R.id.et_Email);
        pass = (EditText)findViewById(R.id.Password);
        cnfpass=(EditText)findViewById(R.id.Retype_pwd_regt) ;
        butnreg = (Button) findViewById(R.id.Register_btn);
        login = (TextView) findViewById(R.id.Login_r);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent = new Intent(RegistrationActivity.this,LoginActivity.class);
                startActivity(LoginIntent);
            }
        });
            butnreg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String usr = usrname.getText().toString().trim();
                    String pwd = pass.getText().toString().trim();
                    String cnf_pwd = cnfpass.getText().toString().trim();

                    if (pwd.equals(cnf_pwd))
                    {
                        long val = db.addUser(usr,pwd);
                        if (val > 0)
                        {
                            Toast.makeText(RegistrationActivity.this,"Registeration Successful",Toast.LENGTH_SHORT).show();
                            Intent movetoLogin = new Intent(RegistrationActivity.this,LoginActivity.class);
                            startActivity(movetoLogin);
                        }
                        else {
                            Toast.makeText(RegistrationActivity.this,"Registeration Error",Toast.LENGTH_SHORT).show();
                        }

                    }
                    else {
                        Toast.makeText(RegistrationActivity.this,"Password didn't matched",Toast.LENGTH_SHORT).show();
                    }

                }
            });
    }
}