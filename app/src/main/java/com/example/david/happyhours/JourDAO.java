package com.example.david.happyhours;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 26/05/2016.
 */
public class JourDAO extends DatabaseDAO {

    // nom du fichier .csv contenant les données à entrer dans la table jour
    public static final String CSV_JOUR = "donnees_jour.csv";

    // TABLE JOUR - colonnes et requêtes de création/suppresion

    public static final String TABLE_JOUR = "jour";
    public static final String COLUMN_JOUR_ID = "_id";
    public static final String COLUMN_JOUR_LBL = "lbl_jour";

    public static final String CREATE_TABLE_JOUR = "create table "
            + TABLE_JOUR
            + "("
            + COLUMN_JOUR_ID + " integer primary key autoincrement, "
            + COLUMN_JOUR_LBL + " text not null "
            + ");";

    public static final String DROP_TABLE_JOUR = "DROP IF EXISTS " + TABLE_JOUR;

    public static final String[] allColumnJour = {
            COLUMN_JOUR_ID, COLUMN_JOUR_LBL
    };

    public JourDAO (Context context) {
        super(context);
    }

    /**
     * Obtention de la table Jour sous forme de List
     *
     * @return liste des entrées enregistrées dans la table jour
     */
    public List<Jour> getAllJour() {
        List<Jour> tousLesJours = new ArrayList<Jour>();

        Cursor cursor = database.query(TABLE_JOUR, allColumnJour, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Jour jour = cursorToJour(cursor);
            tousLesJours.add(jour);
            cursor.moveToNext();
        }
        cursor.close();
        return tousLesJours;
    }

    /**
     * Convertit un objet de type Cursor en un objet de type Jour
     *
     * @param cursor
     * @return
     */
    private Jour cursorToJour(Cursor cursor) {
        Jour jour = new Jour();
        jour.setId(cursor.getLong(0));
        jour.setLbl(cursor.getString(1));
        return jour;
    }
}
