package com.example.mobileeventapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText Email;
    private EditText Password;
    private Button Login;
    private Button Register;

    private String Em = "qwerty";
    private String Pass = "pass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Email = (EditText) findViewById(R.id.emailLogin);
        Password = (EditText) findViewById(R.id.passwordLogin);
        Login = (Button) findViewById(R.id.loginButton);
        Register = (Button) findViewById(R.id.registerButton);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email.getText().toString();
                String password = Password.getText().toString();

                if(email.equals(Em) && password.equals(Pass)){
                    Intent intent = new Intent(LoginActivity.this, MainMenuActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Incorrect Email or Password",Toast.LENGTH_LONG).show();
                    Password.setText("");
                }

            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}
