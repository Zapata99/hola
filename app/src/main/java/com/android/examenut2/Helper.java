package com.android.examenut2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Helper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "bdGruposMusicales.db";
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE IF NOT EXISTS grupos(_id integer PRIMARY KEY AUTOINCREMENT, nombre text, nacionalidad  text, genero_musical text, year_creacion integer);";

    public Helper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //creamos la tabla si no existe db.execSQL(sqlCreate);
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS grupos");
        //Se crea la nueva versión de la tabla
        db.execSQL(SQL_CREATE_ENTRIES);
    }
}
