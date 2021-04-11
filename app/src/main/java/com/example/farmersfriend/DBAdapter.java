package com.example.farmersfriend;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;

public class DBAdapter extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "SMS1.db";

    // User table name
    private static final String TABLE_USER = "user";

    // User Table Columns names
    private static final String COLUMN_USER_ID= "user_id";
    private static final String COLUMN_FIRST_NAME="first_name";
    private static final String COLUMN_LAST_NAME="last_name";
    private static final String COLUMN_MOBILE_NUMBER= "mobile_number";
    private static final String COLUMN_USER_NAME= "user_name";
    private static final String COLUMN_LOCAL_ADDRESS= "local_address";
    private static final String COLUMN_USER_PASSWORD = "user_password";

    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_FIRST_NAME + " TEXT,"
            + COLUMN_LAST_NAME + " TEXT," + COLUMN_MOBILE_NUMBER + " TEXT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_LOCAL_ADDRESS + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")";

    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;
    private String DROP_CROP_TABLE = "DROP TABLE IF EXISTS  CROP_TABLE";

    /**
     * Constructor
     *
     * @param context
     */
    public DBAdapter(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_USER_TABLE);
            String crop_water="CREATE TABLE if not exists CROP_WATER (crop_id INTEGER PRIMARY KEY AUTOINCREMENT, crop_name text not null, CROP_WATER_NEED_MIN real not null,CROP_WATER_NEED_MAX real not null)";
            Log.d("crop_water", crop_water);
            db.execSQL(crop_water);
            String ins = "insert into CROP_WATER(crop_name,CROP_WATER_NEED_MIN,CROP_WATER_NEED_MAX) values('Wheat',410,800);";
            db.execSQL(ins);
            ins = "insert into CROP_WATER(crop_name,CROP_WATER_NEED_MIN,CROP_WATER_NEED_MAX) values('Alfalfa',800,1600);";
            db.execSQL(ins);
            ins = "insert into CROP_WATER(crop_name,CROP_WATER_NEED_MIN,CROP_WATER_NEED_MAX) values('Banana',1200,2200);";
            db.execSQL(ins);
            ins = "insert into CROP_WATER(crop_name,CROP_WATER_NEED_MIN,CROP_WATER_NEED_MAX) values('Barley',450,650);";
            db.execSQL(ins);
            ins = "insert into CROP_WATER(crop_name,CROP_WATER_NEED_MIN,CROP_WATER_NEED_MAX) values('Oats',450,650);";
            db.execSQL(ins);
            ins = "insert into CROP_WATER(crop_name,CROP_WATER_NEED_MIN,CROP_WATER_NEED_MAX) values('Wheat',450,650);";
            db.execSQL(ins);
            ins = "insert into CROP_WATER(crop_name,CROP_WATER_NEED_MIN,CROP_WATER_NEED_MAX) values('Bean',300,500);";
            db.execSQL(ins);
            ins = "insert into CROP_WATER(crop_name,CROP_WATER_NEED_MIN,CROP_WATER_NEED_MAX) values('Cabbage',350,500);";
            db.execSQL(ins);
            ins = "insert into CROP_WATER(crop_name,CROP_WATER_NEED_MIN,CROP_WATER_NEED_MAX) values('Citrus',900,1200);";
            db.execSQL(ins);
            ins = "insert into CROP_WATER(crop_name,CROP_WATER_NEED_MIN,CROP_WATER_NEED_MAX) values('Cotton',700,1300);";
            db.execSQL(ins);
            ins = "insert into CROP_WATER(crop_name,CROP_WATER_NEED_MIN,CROP_WATER_NEED_MAX) values('Maize',500,800);";
            db.execSQL(ins);
            ins = "insert into CROP_WATER(crop_name,CROP_WATER_NEED_MIN,CROP_WATER_NEED_MAX) values('Melon',400,600);";
            db.execSQL(ins);
            ins = "insert into CROP_WATER(crop_name,CROP_WATER_NEED_MIN,CROP_WATER_NEED_MAX) values('Onion',350,550);";
            db.execSQL(ins);
            ins = "insert into CROP_WATER(crop_name,CROP_WATER_NEED_MIN,CROP_WATER_NEED_MAX) values('Peanut',500,700);";
            db.execSQL(ins);
            ins = "insert into CROP_WATER(crop_name,CROP_WATER_NEED_MIN,CROP_WATER_NEED_MAX) values('Pea',350,500);";
            db.execSQL(ins);
            ins = "insert into CROP_WATER(crop_name,CROP_WATER_NEED_MIN,CROP_WATER_NEED_MAX) values('Pepper',600,900);";
            db.execSQL(ins);
            ins = "insert into CROP_WATER(crop_name,CROP_WATER_NEED_MIN,CROP_WATER_NEED_MAX) values('Potato',500,700);";
            db.execSQL(ins);
            ins = "insert into CROP_WATER(crop_name,CROP_WATER_NEED_MIN,CROP_WATER_NEED_MAX) values('Rice',450,700);";
            db.execSQL(ins);
            ins = "insert into CROP_WATER(crop_name,CROP_WATER_NEED_MIN,CROP_WATER_NEED_MAX) values('Millet',450,650);";
            db.execSQL(ins);
            ins = "insert into CROP_WATER(crop_name,CROP_WATER_NEED_MIN,CROP_WATER_NEED_MAX) values('Sorghum',450,650);";
            db.execSQL(ins);
            ins = "insert into CROP_WATER(crop_name,CROP_WATER_NEED_MIN,CROP_WATER_NEED_MAX) values('Cotton',700,1300);";
            db.execSQL(ins);
            ins = "insert into CROP_WATER(crop_name,CROP_WATER_NEED_MIN,CROP_WATER_NEED_MAX) values('Sugarcane',1500,2500);";
            db.execSQL(ins);
            ins = "insert into CROP_WATER(crop_name,CROP_WATER_NEED_MIN,CROP_WATER_NEED_MAX) values('Sunflower',600,1000);";
            db.execSQL(ins);



            String s = "CREATE TABLE if not exists CROP_TABLE (crop_id INTEGER PRIMARY KEY AUTOINCREMENT, crop_name text not null, crop_initial real not null,crop_mid real not null,crop_late real not null)";
            Log.d("s", s);
            db.execSQL(s);
             ins = "insert into CROP_TABLE(crop_name,crop_initial,crop_mid,crop_late) values('Wheat',0.55,1.15,0.3);";
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

        } catch (Exception e1) {
            e1.printStackTrace();
            Log.e("Exception", e1.getMessage());

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        db.execSQL(DROP_USER_TABLE);
        db.execSQL(DROP_CROP_TABLE);

        // Create tables again
        onCreate(db);

    }

    public void addUser(Farmerbean user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_FIRST_NAME, user.getfarmer_firstname());
        values.put(COLUMN_LAST_NAME, user.getfarmer_lastname());
        values.put(COLUMN_MOBILE_NUMBER, user.getfarmer_mobilenumber());
        values.put(COLUMN_LOCAL_ADDRESS, user.getfarmer_address());
        values.put(COLUMN_USER_NAME, user.getfarmer_username());
        values.put(COLUMN_USER_PASSWORD, user.getfarmer_password());

        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();
    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<Farmerbean> getAllUser() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID,
                COLUMN_FIRST_NAME,
                COLUMN_LAST_NAME,
                COLUMN_LOCAL_ADDRESS,
                COLUMN_LOCAL_ADDRESS,
                COLUMN_USER_NAME,
                COLUMN_USER_PASSWORD
        };
        // sorting orders
        String sortOrder =
                COLUMN_USER_NAME + " ASC";
        List<Farmerbean> userList = new ArrayList<Farmerbean>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Farmerbean user = new Farmerbean();
                user.setfarmer_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID))));
                user.setfarmer_firstname(cursor.getString(cursor.getColumnIndex(COLUMN_FIRST_NAME)));
                user.setfarmer_lastname(cursor.getString(cursor.getColumnIndex(COLUMN_LAST_NAME)));
                user.setfarmer_mobilenumber(cursor.getString(cursor.getColumnIndex(COLUMN_MOBILE_NUMBER)));
                user.setfarmer_address(cursor.getString(cursor.getColumnIndex(COLUMN_LOCAL_ADDRESS)));
                user.setfarmer_username(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID)));
                user.getfarmer_password();
                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userList;
    }

    /**
     * This method to update user record
     *
     * @param user
     */
    public void updateUser(Farmerbean user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_ID, user.getfarmer_id());
        values.put(COLUMN_FIRST_NAME, user.getfarmer_firstname());
        values.put(COLUMN_LAST_NAME, user.getfarmer_lastname());
        values.put(COLUMN_MOBILE_NUMBER, user.getfarmer_mobilenumber());
        values.put(COLUMN_LOCAL_ADDRESS, user.getfarmer_address());
        values.put(COLUMN_USER_NAME, user.getfarmer_username());
        values.put(COLUMN_USER_PASSWORD, user.getfarmer_password());

        // updating row
        db.update(TABLE_USER, values, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getfarmer_id())});
        db.close();
    }

    /**
     * This method is to delete user record
     *
     * @param user
     */
    public void deleteUser(Farmerbean user) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_USER, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getfarmer_id())});
        db.close();
    }

    public Cursor getCropDetails(String cr) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from CROP_TABLE where crop_name='"+cr+"'",null);
        return res;
    }
    public Cursor getCropWaterDetails(String cr) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from CROP_WATER where crop_name='"+cr+"'",null);
        return res;
    }
    public Cursor getFarmerDetails(String m) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from user where mobile_number='"+m+"'",null);
        return res;
    }
    public boolean checkUser(String username) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_FIRST_NAME + " = ?";

        // selection argument
        String[] selectionArgs = {};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE username = 'ash';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    /**
     * This method to check user exist or not
     *
     * @param username
     * @param password
     * @return true/false
     */
    public boolean checkUser(String username, String password) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_MOBILE_NUMBER + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {username, password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE username = 'ash' AND user_password = '123';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }
}
