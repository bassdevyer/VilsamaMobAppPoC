package com.tie_vilsama.mobapppoc.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mac on 26/2/16.
 */
public class TestDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "TestDB.db";
    public static final String TEST_TEXT = "\"Esto es una prueba\"";

    public TestDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TestDBContract.TestTable.TABLE_NAME + " (" +
                    TestDBContract.TestTable._ID + " INTEGER PRIMARY KEY," +
                    TestDBContract.TestTable.COLUMN_NAME_TEXT + " TEXT)";


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO implement upgrade behavior
    }
}
