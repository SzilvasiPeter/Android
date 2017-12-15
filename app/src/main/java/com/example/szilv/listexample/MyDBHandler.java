package com.example.szilv.listexample;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "foodDB.db";
    public static final String TABLE_FOODS = "foods";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_DESCRIPTION = "_description";

    //We need to pass database information along to superclass
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_FOODS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_DESCRIPTION + " TEXT " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOODS);
        onCreate(db);
    }

    //Delete all comment from the databse
    public void deleteFoods(){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_FOODS);
    }

    //Add a new row to the database
    public void addFood(Foods food){
        ContentValues values = new ContentValues();
        values.put(COLUMN_DESCRIPTION, food.get_description());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_FOODS, null, values);
        db.close();
    }

    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_FOODS;

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();
        if(c.getCount()>0) {
            //Position after the last row means the end of the results
            while (!c.isAfterLast()) {
                if (c.getString(c.getColumnIndex("_description")) != null) {
                    dbString += c.getString(c.getColumnIndex("_description"));
                    dbString += "\n";
                }
                c.moveToNext();
            }
        }
        c.close();
        db.close();
        return dbString;
    }
}
