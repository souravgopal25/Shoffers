package com.shoffers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    //DATABASE NAME
    private static final String DATABASE_NAME="Shoffers.db";

    //TABLE NAME
    private static final String TABLE_PROFILE = "PROFILE";
    private static final String ITEM = "ITEM";

    //COLOUMN NAME OF TABLE 1
    private static final String KEY_ID="ID";
    private static final String NAME="NAME";
    private static final String MOBILE="MOBILE";
    private static final String EMAIL="EMAIL";
    private static final String PASSWORD="PASSWORD";
    private static final String ADDRESS="ADDRESS";
    private static final String STATE="STATE";




    //COLUMN NAME OF TABLE 2
    private static final String KEY_ID1="ID";
    private static final String ITEM_NAME="ITEM_NAME";
    private static final String PRICE="PRICE";
    private static final String SEX="SEX";
    private static final String CATEGORY="CATEGORY";
    private static final String SUB_CATEGORY="SUB_CATEGORY";




    // Table Create Statements
    private static final String CREATE_TABLE_PROFILE="CREATE TABLE "+ TABLE_PROFILE + " ("+
            " KEY_ID"+" INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE,"+ NAME+" TEXT,"+ MOBILE +" TEXT, "+
            EMAIL +" TEXT UNIQUE,"+ PASSWORD+" TEXT,"+ ADDRESS+" TEXT,"+STATE+" TEXT)";

    private static final String CREATE_TABLE_ITEM="CREATE TABLE "+TABLE_PROFILE+" ("+" KEY_ID1"+" INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE,"+ITEM_NAME+" TEXT,"+
            PRICE+" INTEGER,"+SEX+" INTEGER," +
            "\t\"CATEGORY\"\tTEXT,\n" +
            "\t\"SUB_CATEGORY\"\tTEXT\n" +
            ")"


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
    //FUNCTION TO SIGNUP
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

    }
    //TO GET DATA
    public Cursor getData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("SELECT * from "+TABLE_PROFILE,null);
        return res;
    }

    //FUNCTION FOR LOGIN
    public boolean login(String email, String password) {
      // array of columns to fetch
        String[] columns = {EMAIL};
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = EMAIL + " = ?" + " AND " + PASSWORD + " = ?";
        // selection arguments
        String[] selectionArgs = {email, password};
        Cursor cursor = db.query(TABLE_PROFILE, columns,selection, selectionArgs,null, null, null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    public boolean checkUser(String email) {
        // array of columns to fetch
        String[] columns = {EMAIL};
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = EMAIL + " = ?";
        // selection argument
        String[] selectionArgs = {email};
        Cursor cursor = db.query(TABLE_PROFILE, columns,selection, selectionArgs,null, null, null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }




}
