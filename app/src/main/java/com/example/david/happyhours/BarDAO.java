package com.example.david.happyhours;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Valentin on 30/04/2016.
 */

public class BarDAO extends DatabaseDAO {

    // TABLE BAR - colonnes et requêtes de création/suppresion

    public static final String TABLE_BAR = "Bar";
    public static final String COLUMN_BAR_ID = "_id";
    public static final String COLUMN_BAR_NOM = "nom_bar";
    public static final String COLUMN_BAR_ADR = "adr_bar";
    public static final String COLUMN_BAR_HOR_OUV = "horaire_ouverture_bar";
    public static final String COLUMN_BAR_HOR_FERM = "horaire_fermeture_bar";
    public static final String COLUMN_BAR_HH_DEB = "hh_debut_bar";
    public static final String COLUMN_BAR_HH_FIN = "hh_fin_bar";
    public static final String COLUMN_BAR_IMG = "image_bar";
    public static final String COLUMN_BAR_FAV = "estFavori";

    public static final String CREATE_TABLE_BAR = "create table "
            + TABLE_BAR
            + "("
            + COLUMN_BAR_ID + " integer primary key autoincrement, "
            + COLUMN_BAR_NOM + " text not null, "
            + COLUMN_BAR_ADR + " text not null, "
            + COLUMN_BAR_HOR_OUV + " text not null, "
            + COLUMN_BAR_HOR_FERM + " text not null, "
            + COLUMN_BAR_HH_DEB + " text not null, "
            + COLUMN_BAR_HH_FIN + " text not null, "
            + COLUMN_BAR_IMG + " text not null, "
            + COLUMN_BAR_FAV + " integer not null"
            + ");";

    public static final String DROP_TABLE_BAR = "DROP TABLE IF EXISTS " + TABLE_BAR;

    private String[] allColumnBar = {
            COLUMN_BAR_ID, COLUMN_BAR_NOM, COLUMN_BAR_ADR, COLUMN_BAR_HOR_OUV,
            COLUMN_BAR_HOR_FERM, COLUMN_BAR_HH_DEB, COLUMN_BAR_HH_FIN,
            COLUMN_BAR_IMG, COLUMN_BAR_FAV
    };

    /**
     * Constructeur
     *
     * @param context
     */
    public BarDAO (Context context) {
        super(context);
    }

    /**
     * Insertion d'un bar dans la bdd
     *
     * @param bar
     * @return l'entrée tout juste insérée dans la bdd
     */
    public Bar insertBar(Bar bar) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_BAR_NOM, bar.getNom());
        values.put(COLUMN_BAR_ADR, bar.getAdresse());
        values.put(COLUMN_BAR_HOR_OUV, bar.getHoraire_ouv().toString());
        values.put(COLUMN_BAR_HOR_FERM, bar.getHoraire_ferm().toString());
        values.put(COLUMN_BAR_HH_DEB, bar.getHoraire_hh_deb().toString());
        values.put(COLUMN_BAR_HH_FIN, bar.getHoraire_hh_fin().toString());
        values.put(COLUMN_BAR_IMG, bar.getImage());
        values.put(COLUMN_BAR_FAV, bar.getEstFavori());
        long insertId = database.insert(TABLE_BAR, null,
                values);
        Cursor cursor = database.query(TABLE_BAR,
                allColumnBar, COLUMN_BAR_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Bar newBar = cursorToBar(cursor);
        cursor.close();
        return newBar;
    }

    /**
     * Suppression d'un bar dans la bdd
     *
     * @param Bar
     */
    public void deleteBar(Bar Bar) {
        long id = Bar.getId();
        System.out.println("Bar deleted with id = " + id);
        database.delete(TABLE_BAR, COLUMN_BAR_ID + " = " + id, null);
    }

    /**
     * Obtention de la table bar
     *
     * @return liste des bars enregistrés dans la table bar
     */
    public List<Bar> getAllBar() {
        List<Bar> tousLesBar = new ArrayList<Bar>();

        Cursor cursor = database.query(TABLE_BAR, allColumnBar, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Bar Bar = cursorToBar(cursor);
            tousLesBar.add(Bar);
            cursor.moveToNext();
        }
        cursor.close();
        return tousLesBar;
    }

    // Cette méthode permet de convertir un cursor en un livre
    private Bar cursorToBar(Cursor cursor) {
        Bar Bar = new Bar();
        Bar.setId(cursor.getLong(0));
        Bar.setNom(cursor.getString(1));
        return Bar;
    }
}
