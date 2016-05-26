package com.example.david.happyhours;

import android.content.Context;

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

    private String[] allColumnJour = {
            COLUMN_JOUR_ID, COLUMN_JOUR_LBL
    };

    public JourDAO (Context context) {
        super(context);
    }
}
