package com.example.hp1.parkeasier;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

    public DBHandling(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
