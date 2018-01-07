package com.example.cosmic.androidappclasses;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ${cosmic} on 1/4/18.
 */

public class UserDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_USER_QUOTE = "SQLite.db";
    private static final int DATABASE_VERSION = 1;
    SQLiteDatabase db;

    public static final String DB_TABLE_USER_PROFILE_DB = "User";
    public static final String DB_COLUMN_ID = "_id";
    public static final String DB_COLUMN_USER_IMAGE = "image";
    public static final String DB_COLUMN_USER_FULLNAME = "fullname";
    public static final String DB_COLUMN_USER_NAME = "username";
    public static final String DB_COLUMN_TIMESTAMP = "timestamp";

    public UserDBHelper(Context context) {
        super(context, DATABASE_USER_QUOTE , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + DB_TABLE_USER_PROFILE_DB +
                        "(" + DB_COLUMN_ID + " INTEGER PRIMARY KEY, " +
                        DB_COLUMN_USER_IMAGE + " BLOB, " +
                        DB_COLUMN_USER_FULLNAME + " TEXT, " +
                        DB_COLUMN_USER_NAME + " TEXT, " +
                        DB_COLUMN_TIMESTAMP + " TEXT)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE_USER_PROFILE_DB);
        onCreate(db);
    }

    public boolean insertDB(byte[] image, String fullname, String username, String timestamp) {
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DB_COLUMN_USER_IMAGE, image);
        contentValues.put(DB_COLUMN_USER_FULLNAME, fullname);
        contentValues.put(DB_COLUMN_USER_NAME, username);
        contentValues.put(DB_COLUMN_TIMESTAMP, timestamp);

        db.insert(DB_TABLE_USER_PROFILE_DB, null, contentValues);
        return true;
    }

    public int numberOfRows() {
        db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, DB_TABLE_USER_PROFILE_DB);
        return numRows;
    }

    public boolean updateDB(byte[] image, Integer id, String fullname, String username, String timestamp) {
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DB_COLUMN_USER_IMAGE, image);
        contentValues.put(DB_COLUMN_USER_FULLNAME, fullname);
        contentValues.put(DB_COLUMN_USER_NAME, username);
        contentValues.put(DB_COLUMN_TIMESTAMP, timestamp);

        db.update(DB_TABLE_USER_PROFILE_DB, contentValues, DB_COLUMN_ID + " = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Integer deleteDB(Integer id) {
        db = this.getWritableDatabase();
        return db.delete(DB_TABLE_USER_PROFILE_DB,
                DB_COLUMN_ID + " = ? ",
                new String[] { Integer.toString(id) });
    }

    public Cursor getDB(int id) {
        db = this.getReadableDatabase();
        Cursor res =  db.rawQuery("SELECT * FROM " + DB_TABLE_USER_PROFILE_DB + " WHERE " +
                DB_COLUMN_ID + "=?", new String[]{Integer.toString(id)});
        return res;
    }

    public Cursor getAllDBs() {
        db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "SELECT * FROM " + DB_TABLE_USER_PROFILE_DB, null );
        return res;
    }

    public UserDBHelper openDB() {
        try {
            db = this.getWritableDatabase();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return this;
    }

    public void close() {
        try {
            db = this.getReadableDatabase();
            db.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}