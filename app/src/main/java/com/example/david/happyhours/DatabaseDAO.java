package com.example.david.happyhours;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by David on 02/05/2016.
 */
public class DatabaseDAO {

    // Le nom du fichier qui représente ma base
    protected static final String DATABASE_NAME = "happy_hours.db";
    // Nous sommes à la première version de la base
    // Si je décide de la mettre à jour, il faudra changer cet attribut
    protected static final int DATABASE_VERSION = 1;

    // Champs de la base de données
    protected static SQLiteDatabase database = null;
    protected DatabaseHelper dbHelper = null;

    public DatabaseDAO() {
        // default constructor
    }

    public DatabaseDAO(Context context) {
        this.dbHelper = new DatabaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public SQLiteDatabase open() throws SQLException {
        database = dbHelper.getWritableDatabase();
        return database;
    }

    public void close() {
        database.close();
    }

    public SQLiteDatabase getDatabase() {
        return database;
    }

}
