package com.example.david.happyhours;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Settings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valentin on 30/04/2016.
 */

public class BarManager {

    private SQLiteDatabase database;
    private DataBase dbBar;
    private String[] allBars = { DataBase.BAR_ID, DataBase.BAR_NOM};

    public void BarDataSource(Context context){
        dbBar = new DataBase(context);
    }

    public void open() throws SQLException {
        database = dbBar.getWritableDatabase();
    }

    public void close() {
        dbBar.close();
    }

    public bar createBar(String nom) {
        ContentValues values = new ContentValues();
        values.put(DataBase.BAR_NOM, nom);
        long insertId = database.insert(DataBase.TABLE_BAR, null,
                values);
        Cursor cursor = database.query(DataBase.TABLE_BAR,
                allBars, DataBase.BAR_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        bar newBar = cursorToBar(cursor);
        cursor.close();
        return newBar;
    }

    public void deleteBar(bar bar) {
        long id = bar.getId();
        System.out.println("Bar deleted with id = " + id);
        database.delete(DataBase.TABLE_BAR, DataBase.BAR_ID + " = " + id, null);
    }

    public List<bar> getAllBar() {
        List<bar> ToutLesBar = new ArrayList<bar>();

        Cursor cursor = database.query(DataBase.TABLE_BAR, allBars, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            bar Bar = cursorToBar(cursor);
            ToutLesBar.add(Bar);
            cursor.moveToNext();
        }
        cursor.close();
        return ToutLesBar;
    }

    private bar cursorToBar(Cursor cursor) {
        bar Bar = new bar();
        Bar.setId(cursor.getLong(0));
        Bar.setNom(cursor.getString(1));
        return Bar;
    }
}
