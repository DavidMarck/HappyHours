package com.example.david.happyhours;

import android.content.Context;

/**
 * Created by David on 04/05/2016.
 */
public class BiereDAO extends DatabaseDAO {

    // TABLE BIERE - colonnes et requête de création/suppression

    public static final String TABLE_BIERE = "biere";
    public static final String COLUMN_BIERE_ID = "_id";
    public static final String COLUMN_BIERE_NOM = "nom";
    public static final String COLUMN_BIERE_DESCR = "descr";
    public static final String COLUMN_BIERE_TYPE = "id_type";

    public static final String CREATE_TABLE_BIERE = "create table "
            + TABLE_BIERE
            + "("
            + COLUMN_BIERE_ID + " integer primary key autoincrement, "
            + COLUMN_BIERE_NOM + " text not null, "
            + COLUMN_BIERE_DESCR + " text not null, "
            + COLUMN_BIERE_TYPE + " text not null, "
            + "FOREIGN KEY (" + COLUMN_BIERE_TYPE + ") REFERENCES " + TypeBiereDAO.TABLE_TYPE_BIERE + "(" + TypeBiereDAO.COLUMN_TYPE_BIERE_ID + ")"
            + ");";

    public static final String DROP_TABLE_BIERE = "DROP TABLE IF EXISTS " + TABLE_BIERE;

    private String[] allColumnTypeBiere = {
            COLUMN_BIERE_ID, COLUMN_BIERE_NOM, COLUMN_BIERE_DESCR, COLUMN_BIERE_TYPE
    };

    /**
     * Constructeur
     *
     * @param context
     */
    public BiereDAO (Context context) {
        super(context);
    }

    public void bulkInsert(Context context) {

    }
}
