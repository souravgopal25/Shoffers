package com.shoffers;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton view;
    DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb=new DatabaseHelper(this);
       // startActivity(new Intent(this,Login.class));
        view=findViewById(R.id.view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor viewAll= myDb.getData();
                if (viewAll.getCount()==0){
                    showMessage("ERROR","NOTHING FOUND");
                }
                StringBuffer buffer=new StringBuffer();
                while (viewAll.moveToNext()){
                    buffer.append("ID :"+ viewAll.getString(0)+"\n");
                    buffer.append("NAME : "+viewAll.getString(1)+"\n");
                    buffer.append("MOBILE : "+viewAll.getString(2)+"\n");
                    buffer.append("EMAIL : "+viewAll.getString(3)+"\n");
                    buffer.append("PASSWORD : "+viewAll.getString(4)+"\n");
                    buffer.append("ADDRESS : "+viewAll.getString(5)+"\n");
                    buffer.append("STATE : "+viewAll.getString(6)+"\n\n");

                }
                showMessage("DATA ",buffer.toString());
            }
        });
    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }
}
