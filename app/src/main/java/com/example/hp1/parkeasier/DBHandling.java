package com.example.hp1.parkeasier;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Hp1 on 25/01/2018.
 */

public class DBHandling extends SQLiteOpenHelper{

    private static DBHandling sInstance;

    public static final int DATABASE_VERSION = 1;

    //database name
    public static final String DATABASE_NAME = "rate.db";

    //data table name
    public static final String TABLE_RATE = "rate";

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
        String query = " CREATE TABLE " + TABLE_RATE
                + "(" + COL_ID + " INTGER PRIMARY KEY AUTOINCREMENT, "
                + COL_CARNUM + " TEXT, "
                + COL_DATE + " TEXT, "
                + COL_RATE + " REAL, "
                + COL_PARKINPNUM + " INTEGER, "
                + COL_FLOORNUM + " INTEGER "
                +");";
        Log.d("QUERY",query);
        try {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_RATE);
            db.execSQL(query);
        }catch (Exception e){
            e.printStackTrace();

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RATE);
        onCreate(db);

    }
    //add user to the database method
    public void addRate(Rate rate){
        //create ContentValue containning values to be inserted/updated in database in this case only on column
        ContentValues values = new ContentValues();

        values.put(COL_CARNUM, rate.getCarnum());
        values.put(COL_DATE, rate.getDate());
        values.put(COL_RATE, rate.getRate());
        values.put(COL_PARKINPNUM, rate.getParkingnum());
        values.put(COL_FLOORNUM, rate.getFloornum());

        //create SQLiteDatabase object to enable writing/reading in database
        SQLiteDatabase db = getWritableDatabase();
        long id = db.insert(TABLE_RATE, null, values);
        rate.setId(id);//update the user ID according to the auto incremented id in the DB

        //logging for debugging purposes
        Log.d("ID ", "Category id: "+id+" added to DB");

        //close connection to database
        db.close();
    }
    //search data from DB
    public ArrayList<Rate> getData(){
        String[] r = new String[6];
        int[] col = new int[6];
        String query = "SELECT * FROM "+ TABLE_RATE ;//+ " WHERE " + COL_USERNAME+"='"+username+"'";

        ArrayList<Rate> rates= new ArrayList<Rate>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        col[0]=c.getColumnIndex(COL_ID);
        col[1]=c.getColumnIndex(COL_CARNUM);
        col[2]=c.getColumnIndex(COL_DATE);
        col[3]=c.getColumnIndex(COL_RATE);
        col[4]=c.getColumnIndex(COL_PARKINPNUM);
        col[5]=c.getColumnIndex(COL_FLOORNUM);

        while(!c.isAfterLast()){
            for(int i=0;i<col.length;i++){
                r[i]=c.getString(col[i]);
            }
            rates.add(new Rate((long) Double.parseDouble(r[3]),r[2],r[1],Long.parseLong(r[0]),Integer.parseInt(r[4]),Integer.parseInt(r[5])));
            c.moveToNext();
        }
        return rates;
    }

}
