package com.example.rishab.muzikkk;

/**
 * Created by Rishab on 31-07-2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class UserDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "userinfo";
    public static final String TABLE_NAME = "registration";
    public static final String COL_USERNAME = "username";
    public static final String COL_PASSWORD = "password";
    public static final String COL_NAME = "name";
    public static final String COL_EMAIL = "email";
    public static final String COL_CONTACT = "contactno";

    public UserDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {


        String CREATE_REGISTRATION_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COL_USERNAME + " TEXT PRIMARY KEY," + COL_PASSWORD + " TEXT,"
                + COL_EMAIL + " TEXT," + COL_NAME + " TEXT," + COL_CONTACT + " TEXT" + ")";
        db.execSQL(CREATE_REGISTRATION_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean add_user(String uname, String pwd, String email, String name, String contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_USERNAME, uname);
        values.put(COL_PASSWORD, pwd);
        values.put(COL_EMAIL, email);
        values.put(COL_NAME, name);
        values.put(COL_CONTACT, contact);

        long i = db.insert(TABLE_NAME, null, values);
        db.close();
        if (i > 0)
            return true;
        return false;
    }

    public ArrayList<String> getUserDetail(String uname, String pwd) {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] colname = {COL_NAME, COL_EMAIL};
        String where =COL_USERNAME + "=? AND " + COL_PASSWORD + "=?";
        String[] wherecolname = {uname, pwd};
        Cursor cursor = db.query(TABLE_NAME, colname, where, wherecolname, null, null, null, null);

        ArrayList<String> values = new ArrayList<String>();

        if (cursor != null) {
            cursor.moveToFirst();
            values.add(cursor.getString(cursor.getColumnIndexOrThrow(COL_NAME)));
            values.add(cursor.getString(cursor.getColumnIndexOrThrow(COL_EMAIL)));
        }


        db.close();
        return values;
    }
}
