package com.example.ksanchez.enapp.modelo;

import android.content.Context;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ksanchez on 20/03/2018.
 */

public class DBHelper extends SQLiteOpenHelper{
    public static int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, SQLConstantes.dbName, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_PREGUNTAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQLConstantes.SQL_DELETE_TABLA_PREGUNTAS);
        onCreate(sqLiteDatabase);
    }
}
