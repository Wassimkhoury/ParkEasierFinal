package com.example.hp1.parkeasier;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Hp1 on 25/01/2018.
 */

public class DBHandling extends SQLiteOpenHelper{

    private static DBHandling sInstance;

    public static final int DATABASE_VERSION = 1;

    //database name
    public static final String DATABASE_NAME = "rate.db";

    //data table name
    public static final String TABLE_ALC = "rate";

    //column names
    public static final String COL_ID ="id";
    public static final String COL_CARNUM ="carnumber";
    public static final String COL_DATE ="date";
    public static final String COL_RATE ="rate";
    public static final String COL_PARKINPNUM ="parkinpnum";
    public static final String COL_FLOORNUM = "floornum";

    //constructor
    public DBHandling(Context context) {
        super(context,DATABASE_NAME, null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
String query = " CREATE TABLE " + TABLE_ALC
        + "(" + COL_ID + " INTGER PRIMARY KEY AUTOINCREMENT, "
        + COL_CARNUM + " INTEGER "
        + COL_DATE + " TEXT "
        + COL_RATE + " REAL "
        + COL_PARKINPNUM + " INTEGER "
        + COL_FLOORNUM + " INTEGER "
        +");";
    Log.d("QUERY",query);
        try {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_ALC);
            db.execSQL(query);
        }catch (Exception e){
            e.printStackTrace();

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ALC);
        onCreate(db);

    }
}
