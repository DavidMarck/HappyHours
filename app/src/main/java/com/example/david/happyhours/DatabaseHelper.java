package com.example.david.happyhours;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valentin on 30/04/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private Context context;

    public static final String DATABASE_NAME = "happy_hours.db";
    public static final int DATABASE_VERSION = 1;

    // Champs de la base de données
    protected SQLiteDatabase database = null;

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    // Création de la base
    @Override
    public void onCreate(SQLiteDatabase database) {
        this.database = database;
        database.execSQL(BarDAO.CREATE_TABLE_BAR);
        this.bulkInsertBar(context);
        database.execSQL(TypeBiereDAO.CREATE_TABLE_TYPE_BIERE);
        database.execSQL(BiereDAO.CREATE_TABLE_BIERE);
        database.execSQL(CarteDAO.CREATE_TABLE_CARTE);
        database.execSQL(JourDAO.CREATE_TABLE_JOUR);
        this.bulkInsertJour(context);
        database.execSQL(OuvertureDAO.CREATE_TABLE_OUVERTURE);
        this.bulkInsertOuverture(context);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DatabaseHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL(CarteDAO.DROP_TABLE_CARTE);
        db.execSQL(OuvertureDAO.DROP_TABLE_OUVERTURE);
        db.execSQL(BarDAO.DROP_TABLE_BAR);
        db.execSQL(BiereDAO.DROP_TABLE_BIERE);
        db.execSQL(TypeBiereDAO.DROP_TABLE_TYPE_BIERE);
        db.execSQL(JourDAO.DROP_TABLE_JOUR);
        onCreate(db);
    }


    /**
     * Effectue un bulk insert des données du fichier donnees_bar.csv dans la table bar
     *
     * @param context
     */
    public void bulkInsertBar(Context context) {
        AssetManager assetManager = context.getAssets();
        InputStream inputStream = null;
        try {
            inputStream = assetManager.open(BarDAO.CSV_BAR);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream));
        String ligne = "";
        database.beginTransaction();
        try {
            while ((ligne = buffer.readLine()) != null) {
                String[] columns = ligne.split(";");
                if (columns.length != BarDAO.allColumnBar.length-1) {
                    Log.d("CSVParser", "Skipping Bad CSV Row");
                    continue;
                }
                Bar bar = new Bar();
                bar.setNom(columns[0].trim());
                bar.setAdresse(columns[1].trim());
                bar.setHoraire_ouv(columns[2].trim());
                bar.setHoraire_ferm(columns[3].trim());
                bar.setHoraire_hh_deb(columns[4].trim());
                bar.setHoraire_hh_fin(columns[5].trim());
                bar.setImage(columns[6].trim());
                bar.setEstFavori(Integer.parseInt(columns[7].trim()));
                ContentValues values = new ContentValues();
                values.put(BarDAO.COLUMN_BAR_NOM, bar.getNom());
                values.put(BarDAO.COLUMN_BAR_ADR, bar.getAdresse());
                values.put(BarDAO.COLUMN_BAR_HOR_OUV, bar.getHoraire_ouv());
                values.put(BarDAO.COLUMN_BAR_HOR_FERM, bar.getHoraire_ferm());
                values.put(BarDAO.COLUMN_BAR_HH_DEB, bar.getHoraire_hh_deb());
                values.put(BarDAO.COLUMN_BAR_HH_FIN, bar.getHoraire_hh_fin());
                values.put(BarDAO.COLUMN_BAR_IMG, bar.getImage());
                values.put(BarDAO.COLUMN_BAR_FAV, bar.getEstFavori());
                long insertId = database.insert(BarDAO.TABLE_BAR, null,
                        values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        database.setTransactionSuccessful();
        database.endTransaction();
    }

    /**
     * Effectue un bulk insert des données du fichier donnees_jour.csv dans la table jour
     *
     * @param context
     */
    public void bulkInsertJour(Context context) {
        AssetManager assetManager = context.getAssets();
        InputStream inputStream = null;
        try {
            inputStream = assetManager.open(JourDAO.CSV_JOUR);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream));
        String ligne = "";
        database.beginTransaction();
        try {
            while ((ligne = buffer.readLine()) != null) {
                String[] columns = ligne.split(";");
                if (columns.length != JourDAO.allColumnJour.length-1) {
                    Log.d("CSVParser", "Skipping Bad CSV Row");
                    continue;
                }
                Jour jour = new Jour();
                jour.setLbl(columns[0].trim());
                ContentValues values = new ContentValues();
                values.put(JourDAO.COLUMN_JOUR_LBL, jour.getLbl());
                long insertId = database.insert(JourDAO.TABLE_JOUR, null,
                        values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        database.setTransactionSuccessful();
        database.endTransaction();
    }

    /**
     * Effectue un bulk insert des données du fichier donnees_ouverture.csv dans la table ouverture
     *
     * @param context
     */
    public void bulkInsertOuverture(Context context) {
        AssetManager assetManager = context.getAssets();
        InputStream inputStream = null;
        try {
            inputStream = assetManager.open(OuvertureDAO.CSV_OUVERTURE);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream));
        String ligne = "";
        database.beginTransaction();
        try {
            while ((ligne = buffer.readLine()) != null) {
                String[] columns = ligne.split(";");
                if (columns.length != OuvertureDAO.allColumnOuverture.length-1) {
                    Log.d("CSVParser", "Skipping Bad CSV Row");
                    continue;
                }
                Ouverture ouverture = new Ouverture();
                ouverture.setId_bar(Integer.parseInt(columns[0].trim()));
                ouverture.setId_jour(Integer.parseInt(columns[1].trim()));
                ContentValues values = new ContentValues();
                values.put(OuvertureDAO.COLUMN_OUVERTURE_ID_BAR, ouverture.getId_bar());
                values.put(OuvertureDAO.COLUMN_OUVERTURE_ID_JOUR, ouverture.getId_jour());
                values.put(OuvertureDAO.COLUMN_OUVERTURE_HORAIRE_OUV, ouverture.getHoraire_ouv());
                values.put(OuvertureDAO.COLUMN_OUVERTURE_HORAIRE_FERM, ouverture.getHoraire_ferm());
                values.put(OuvertureDAO.COLUMN_OUVERTURE_HORAIRE_HH_DEB, ouverture.getHoraire_hh_deb());
                values.put(OuvertureDAO.COLUMN_OUVERTURE_HORAIRE_HH_FIN, ouverture.getHoraire_hh_deb());
                long insertId = database.insert(OuvertureDAO.TABLE_OUVERTURE, null,
                        values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        database.setTransactionSuccessful();
        database.endTransaction();
    }
}
