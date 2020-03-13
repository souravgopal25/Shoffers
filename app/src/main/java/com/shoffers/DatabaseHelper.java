package com.shoffers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    //DATABASE NAME
    private static final String DATABASE_NAME="Shoffers.db";

    //TABLE NAME
    private static final String TABLE_PROFILE = "PROFILE";

    //COLOUMN NAME OF TABLE 1
    private static final String KEY_ID="ID";
    private static final String NAME="NAME";
    private static final String MOBILE="MOBILE";
    private static final String EMAIL="EMAIL";
    private static final String PASSWORD="PASSWORD";
    private static final String ADDRESS="ADDRESS";
    private static final String STATE="STATE";


    // Table Create Statements
    private static final String CREATE_TABLE_PROFILE="CREATE TABLE "+ TABLE_PROFILE + " ("+
            " KEY_ID"+" INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE,"+ NAME+" TEXT,"+ MOBILE +" TEXT, "+
            EMAIL +" TEXT UNIQUE,"+ PASSWORD+" TEXT,"+ ADDRESS+" TEXT,"+STATE+" TEXT)";


    public DatabaseHelper(@Nullable Context context) {

        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PROFILE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_PROFILE);
        onCreate(db);

    }
    public Boolean signup(UserProfile user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(NAME,user.getName());
        contentValues.put(MOBILE,user.getMobile());
        contentValues.put(EMAIL,user.getEmail());
        contentValues.put(PASSWORD,user.getPassword());
        contentValues.put(ADDRESS,user.getAddress());
        contentValues.put(STATE,user.getState());
        long result =db.insert(TABLE_PROFILE,null,contentValues);
        if (result==-1){
            return false;
        }else {
            return true;
        }
        //TODO add your table and things respectively
    }
}
