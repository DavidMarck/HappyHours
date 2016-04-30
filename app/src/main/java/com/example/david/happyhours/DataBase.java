package com.example.david.happyhours;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Valentin on 30/04/2016.
 */
public class DataBase extends SQLiteOpenHelper {

    public static final String TABLE_BAR = "bar";
    public static final String BAR_ID = "_id";
    public static final String BAR_NOM = "nom";

    private static final String DATABASE_NAME = "bar.db";
    private static final int DATABASE_VERSION = 1;

    // Commande SQL pour la création de la BDD
    private static final String DATABASE_CREATE = "create table " + TABLE_BAR + "(" + BAR_ID + " integer primary key autoincrement, " + BAR_NOM + " text not null);";

    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    // Création de la base

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DataBase.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BAR);
        onCreate(db);
    }

}
