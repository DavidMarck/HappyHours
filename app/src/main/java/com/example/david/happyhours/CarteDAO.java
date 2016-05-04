package com.example.david.happyhours;

import android.content.Context;

/**
 * Created by David on 04/05/2016.
 */
public class CarteDAO extends DatabaseDAO {

    // TABLE CARTE - colonnes et requête de création/suppression

    public static final String TABLE_CARTE = "carte";
    public static final String COLUMN_CARTE_ID_BIERE = "id_biere";
    public static final String COLUMN_CARTE_ID_BAR = "id_bar";
    public static final String COLUMN_CARTE_TARIF_50 = "tarif_50";
    public static final String COLUMN_CARTE_TARIF_HH_50 = "tarif_hh_50";
    public static final String COLUMN_CARTE_TARIF_100 = "tarif_100";
    public static final String COLUMN_CARTE_TARIF_HH_100 = "tarif_hh_100";

    public static final String CREATE_TABLE_CARTE = "create table "
            + TABLE_CARTE
            + "("
            + COLUMN_CARTE_ID_BAR + " integer not null references " + BarDAO.TABLE_BAR + "("+ BarDAO.COLUMN_BAR_ID +"), "
            + COLUMN_CARTE_ID_BIERE + " integer not null references " + BiereDAO.TABLE_BIERE + "("+ BiereDAO.COLUMN_BIERE_ID +"), "
            + COLUMN_CARTE_TARIF_50 + " real not null, "
            + COLUMN_CARTE_TARIF_HH_50 + " real not null, "
            + COLUMN_CARTE_TARIF_100 + " real not null, "
            + COLUMN_CARTE_TARIF_HH_100 + " real not null, "
            + "PRIMARY KEY (" + COLUMN_CARTE_ID_BAR + "," + COLUMN_CARTE_ID_BIERE + ")"
            + ");";

    public static final String DROP_TABLE_CARTE = "DROP IF EXISTS " + TABLE_CARTE;

    private String[] allColumnTypeBiere = {
            COLUMN_CARTE_ID_BAR, COLUMN_CARTE_ID_BIERE, COLUMN_CARTE_TARIF_50,
            COLUMN_CARTE_TARIF_HH_50, COLUMN_CARTE_TARIF_100, COLUMN_CARTE_TARIF_HH_100
    };

    /**
     * Constructeur
     *
     * @param context
     */
    public CarteDAO (Context context) {
        super(context);
    }
}
