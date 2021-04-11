package com.example.farmersfriend;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;

public class CropBean extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "UserManager1.db";

    // User table name
    private static final String TABLE_USER = "user";

    // User Table Columns names
    private static final String COLUMN_CROP_ID = "crop_id";
    private static final String COLUMN_CROP_NAME = "crop_name";
    private static final String COLUMN_CROP_INITIAL = "crop_initial";
    private static final String COLUMN_CROP_MID = "crop_mid";
    private static final String COLUMN_CROP_LATE = "crop_late";



    // create table sql query

    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    /**
     * Constructor
     *
     * @param context
     */
    public CropBean(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //  String d="drop table DROP_TABLE";
        //   db.execSQL(d);
        try {
            String s = "CREATE TABLE if not exists CROP_TABLE (crop_id INTEGER PRIMARY KEY AUTOINCREMENT, crop_name text not null, crop_initial real not null,crop_mid real not null,crop_late real not null)";
            Log.d("s", s);
            db.execSQL(s);
            String ins = "insert into CROP_TABLE(crop_name,crop_initial,crop_mid,crop_late) values('Wheat',0.55,1.15,0.3);";
            db.execSQL(ins);
            ins = "insert into CROP_TABLE(crop_name,crop_initial,crop_mid,crop_late) values('Maize',0.3,1.2,0.35);";
            db.execSQL(ins);
            ins = "insert into CROP_TABLE(crop_name,crop_initial,crop_mid,crop_late) values('Millet',0.3,1.00,0.3);";
            db.execSQL(ins);
            ins = "insert into CROP_TABLE(crop_name,crop_initial,crop_mid,crop_late) values('Sorghum',0.3,1.00,0.55);";
            db.execSQL(ins);
            ins = "insert into CROP_TABLE(crop_name,crop_initial,crop_mid,crop_late) values('Barley',0.3,1.15,0.25);";
            db.execSQL(ins);
            ins = "insert into CROP_TABLE(crop_name,crop_initial,crop_mid,crop_late) values('Tomato',0.6,1.15,0.8);";
            db.execSQL(ins);
            ins = "insert into CROP_TABLE(crop_name,crop_initial,crop_mid,crop_late) values('Potato',0.5,1.15,0.75);";
            db.execSQL(ins);
            ins = "insert into CROP_TABLE(crop_name,crop_initial,crop_mid,crop_late) values('Vegetables',0.7,1.05,0.95);";
            db.execSQL(ins);
            ins = "insert into CROP_TABLE(crop_name,crop_initial,crop_mid,crop_late) values('Alfalfa',0.4,0.95,0.7);";
            db.execSQL(ins);
            ins = "insert into CROP_TABLE(crop_name,crop_initial,crop_mid,crop_late) values('Dates',0.9,0.95,0.45);";
            db.execSQL(ins);
            ins = "insert into CROP_TABLE(crop_name,crop_initial,crop_mid,crop_late) values('Citrus',0.7,0.65,0.3);";
            db.execSQL(ins);
            ins = "insert into CROP_TABLE(crop_name,crop_initial,crop_mid,crop_late) values('Grapes',0.3,0.7,0.3);";
            db.execSQL(ins);





        }
        catch (Exception e) {
            e.printStackTrace();
            Log.e("Exception", e.getMessage());
        }


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {
            String s = "CREATE TABLE if not exists CROP_TABLE (crop_id INTEGER PRIMARY KEY AUTOINCREMENT, crop_name text not null, crop_initial real not null,crop_mid real not null,crop_late real not null)";
            Log.d("s", s);
            db.execSQL(s);
            String ins = "insert into CROP_TABLE(crop_name,crop_growth) values('Wheat',45);";
            db.execSQL(ins);


        }
        catch (Exception e) {
            e.printStackTrace();
            Log.e("Exception", e.getMessage());
        }

    }

    public Cursor getAllCrops(String s) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from crop_table where crop_name='"+s+"'",null);
        return res;
    }



}

