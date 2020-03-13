package com.shoffers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    EditText name,email,pass,cpass,state,addr,mobile;
    String mName,mEmail,mPass,mCpass,mState,mAddr,mMobile;
    UserProfile user;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.pass);
        cpass=findViewById(R.id.cpass);
        state=findViewById(R.id.state);
        addr=findViewById(R.id.add);
        mobile=findViewById(R.id.mobile);
        db=new DatabaseHelper(this);


    }

    public void add(View view) {
        mName=name.getText().toString();
        mEmail=email.getText().toString();
        mPass=pass.getText().toString();
        mCpass=cpass.getText().toString();
        mState=state.getText().toString();
        mAddr=addr.getText().toString();
        mMobile=mobile.getText().toString();
        if (TextUtils.isEmpty(mName)){
            name.setError("NAME REQUIRED");
            return;
        }
        if (TextUtils.isEmpty(mEmail)){
            email.setError("EMAIL REQUIRED");
            return;
        }
        if (TextUtils.isEmpty(mMobile)){
            mobile.setError("NAME REQUIRED");
            return;
        }
        if (TextUtils.isEmpty(mAddr)){
            addr.setError("NAME REQUIRED");
            return;
        }
        if (TextUtils.isEmpty(mState)){
            state.setError("NAME REQUIRED");
            return;
        }
        if (TextUtils.isEmpty(mPass)){
            pass.setError("PASSWORD REQUIRED");
            return;
        }
        if (TextUtils.isEmpty(mCpass)){
            pass.setError("PASSWORD REQUIRED");
            return;
        }
        if (!mPass.equals(mCpass)){
            Toast.makeText(this, "PASSWORD Does not matches", Toast.LENGTH_SHORT).show();
            return;
        }
        user=new UserProfile(mName,mMobile,mEmail,mPass,mAddr,mState);
       if(db.signup(user)){
           //TODO SUCCESSFULL
           Toast.makeText(this, "SUCEESS", Toast.LENGTH_SHORT).show();
       }
       else {
           //TODO UNSUCESSFULL
           Toast.makeText(this, "FAILED", Toast.LENGTH_SHORT).show();
       }

    }
}
