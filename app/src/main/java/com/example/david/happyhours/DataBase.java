package com.example.david.happyhours;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Valentin on 30/04/2016.
 */
public class DataBase extends SQLiteOpenHelper {

    // Création de la base
    String sqltable = "create table bar (id INT NOT NULL PRIMARY KEY, Nom TEXT NOT NULL)";
    public DataBase(Context context, String name, SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(sqltable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
