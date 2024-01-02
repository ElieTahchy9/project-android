package com.example.journeyleb;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "journeyLeb.db";
    private static final int DATABASE_VERSION = 1;

    // Constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create your tables here
        db.execSQL("CREATE TABLE IF NOT EXISTS Client ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "client_name TEXT,"
                + "client_username TEXT,"
                + "client_phone TEXT,"
                + "client_email TEXT,"
                + "client_password TEXT"
                + ");");


    }






    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle upgrades if needed
        // Example: db.execSQL("DROP TABLE IF EXISTS Client");
        // Then call onCreate(db);
    }
}

