package com.example.user.app1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;

public class Databasehelper extends SQLiteOpenHelper {
    public static  final  String DATABASE_NAME="user11.db";
    public static  final  String TABLE_NAME="user_table2";
    public static  final  String TABLE_NAME2="user_table3";
    public static  final  String TABLE_NAME3="user_table4";
    public static  final  String COL_1="ID";
    public static  final  String COL_2="IV";
    public static  final  String COL_3="IG";
    public Databasehelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID TEXT)");
        db.execSQL("create table " + TABLE_NAME2 + " (IV TEXT)");
        db.execSQL("create table " + TABLE_NAME3 + " (IG TEXT)");
        //db.execSQL( "CREATE TABLE " + TABLE_NAME + " (" + COL_1+ " TEXT PRIMARY KEY , " + COL_2 + " TEXT, " + COL_3 + " INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS"+ TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS"+ TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS"+ TABLE_NAME3);
        onCreate(db);

    }

    public  boolean insertData(String s)
    {
        long result=0;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res1 = db.rawQuery("Select * from " + TABLE_NAME,null);
        ContentValues contentValues = new ContentValues();


        if(res1.getCount()>0)
        {


        } else {
            contentValues.put(COL_1,s);
            result=db.insert(TABLE_NAME, null, contentValues);
        }

        //db.close();
        if (result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

        //return true;
    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res1 = db.rawQuery("Select * from " + TABLE_NAME,null);
        return  res1;


    }



    public  boolean insertData1(String s)
    {
        long result=0;
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        Cursor res1 = db.rawQuery("Select * from " + TABLE_NAME2,null);
        if(res1.getCount()>0)
        {


        } else {
            contentValues.put(COL_2,s);
            result=db.insert(TABLE_NAME2, null, contentValues);
        }

        db.close();
        if (result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

        //return true;
    }
    public Cursor getAllData1(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("Select * from " + TABLE_NAME2,null);
        return  res;
    }
    public  boolean insertData2(String s)
    {
        long result=0;
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        Cursor res1 = db.rawQuery("Select * from " + TABLE_NAME3,null);
        if(res1.getCount()>0)
        {


        } else {
            contentValues.put(COL_3,s);
            result=db.insert(TABLE_NAME3, null, contentValues);
        }

        db.close();
        if (result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

        //return true;
    }
    public Cursor getAllData2(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("Select * from " + TABLE_NAME3,null);
        return  res;
    }
}
