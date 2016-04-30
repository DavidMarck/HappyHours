package com.example.david.happyhours;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Valentin on 30/04/2016.
 */

public class BarManager {
    DataBase dbm;
    SQLiteDatabase db;

    public BarManager(Context ctx) {
        dbm = new DataBase(ctx, "mabase", null, 1);
    }

    public void open(){
       db = dbm.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    public long AddBar(bar b){
        ContentValues vals = new ContentValues();
        vals.put("id", b.getId());
        vals.put("nom", b.getNom());
        return db.insert("bar",null,vals);
    }
}
