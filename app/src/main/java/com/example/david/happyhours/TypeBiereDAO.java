package com.example.david.happyhours;

import android.content.Context;

/**
 * Created by David on 04/05/2016.
 */
public class TypeBiereDAO extends DatabaseDAO {

    // TABLE TYPE_BIERE - colonnes et requête de création/suppression

    public static final String TABLE_TYPE_BIERE = "type_biere";
    public static final String COLUMN_TYPE_BIERE_ID = "_id";
    public static final String COLUMN_TYPE_BIERE_LBL = "lbl_type_biere";

    public static final String CREATE_TABLE_TYPE_BIERE = "create table "
            + TABLE_TYPE_BIERE
            + "("
            + COLUMN_TYPE_BIERE_ID + " integer primary key autoincrement, "
            + COLUMN_TYPE_BIERE_LBL + " text not null"
            + ");";

    public static final String DROP_TABLE_TYPE_BIERE = "DROP TABLE IF EXISTS " + TABLE_TYPE_BIERE;

    private String[] allColumnTypeBiere = {
        COLUMN_TYPE_BIERE_ID, COLUMN_TYPE_BIERE_LBL
    };

    /**
     * Constructeur
     *
     * @param context
     */
    public TypeBiereDAO (Context context) {
        super(context);
    }

    @Override
    public void bulkInsert(Context context) {

    }
}
