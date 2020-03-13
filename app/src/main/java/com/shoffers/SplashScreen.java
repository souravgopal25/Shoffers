package com.shoffers;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Thread.sleep;

public class SplashScreen extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        startActivity(new Intent(this,MainActivity.class));
    }
}
