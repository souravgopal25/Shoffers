package com.shoffers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText email,pass;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.pass);
        db=new DatabaseHelper(this);
    }

    public void login(View view) {
        String mEmail=email.getText().toString();
        String mPass=pass.getText().toString();
        if(db.login(mEmail,mPass)){
            startActivity(new Intent(this,navdrawer.class));

        }else {
            Toast.makeText(this, "INVALID CREDENTIALS", Toast.LENGTH_SHORT).show();

        }

    }

    public void signup(View view) {
        startActivity(new Intent(this,Signup.class));
    }
}
