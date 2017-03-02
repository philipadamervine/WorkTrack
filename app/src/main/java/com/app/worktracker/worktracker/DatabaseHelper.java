package com.app.worktracker.worktracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by Philip on 27/02/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "work_track.db";
    private static final String TABLE_NAME = "employee";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_SNAME = "surname";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_JOB = "job title";
    private static final String COLUMN_TEL = "telephone no.";
    private static final String COLUMN_START = "start time";
    private static final String COLUMN_FINISH = "finish time";
    private static final String COLUMN_RATE = "hourly rate";
    private static final String COLUMN_PASS = "password";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table employee (id integer primary key not null , " +
            "name text not null , surname text not null , email text not null , job title text not null , telephone no. text not null ," +
            "start time text not null , finish time text not null , hourly rate text not null , pass text not null );";

    public DatabaseHelper(Context context)
    {
        super(context , DATABASE_NAME , null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public void insertEmployee(Employee e){

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from employee";
        Cursor cursor = db.rawQuery(query , null);
        int count = cursor.getCount();


        values.put(COLUMN_ID , count);
        values.put(COLUMN_NAME , e.getName());
        values.put(COLUMN_SNAME , e.getSName());
        values.put(COLUMN_EMAIL , e.getEmail());
        values.put(COLUMN_JOB , e.getJob());
        values.put(COLUMN_TEL , e.getTel());
        values.put(COLUMN_START , e.getStart());
        values.put(COLUMN_FINISH , e.getFinish());
        values.put(COLUMN_RATE , e.getRate());
        values.put(COLUMN_PASS , e.getPass());

        db.insert(TABLE_NAME , null , values);
        db.close();
    }

    public String searchPass(String email){

        db = this.getReadableDatabase();
        String query = "select email, pass from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query , null);

        String a, b;
        b = "not found";
        if(cursor.moveToFirst())
        {
            do{
                a = cursor.getString(0);
                b = cursor.getString(1);

                if(a.equals(email))
                {
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }

        return b;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
