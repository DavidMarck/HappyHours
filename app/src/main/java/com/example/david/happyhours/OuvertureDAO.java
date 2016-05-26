package com.example.david.happyhours;

import android.content.Context;

/**
 * Created by David on 26/05/2016.
 */
public class OuvertureDAO extends DatabaseDAO {

    // nom du fichier .csv contenant les données à entrer dans la table ouverture
    public static final String CSV_OUVERTURE = "donnees_ouverture.csv";

    // TABLE OUVERTURE - colonnes et requêtes de création/suppresion

    public static final String TABLE_OUVERTURE = "ouverture";
    public static final String COLUMN_OUVERTURE_HORAIRE_OUV = "horaire_ouv";
    public static final String COLUMN_OUVERTURE_HORAIRE_FERM = "horaire_ferm";
    public static final String COLUMN_OUVERTURE_HORAIRE_HH_DEB = "horaire_hh_deb";
    public static final String COLUMN_OUVERTURE_HORAIRE_HH_FIN = "horaire_hh_fin";
    public static final String COLUMN_OUVERTURE_ID_BAR = "id_bar";
    public static final String COLUMN_OUVERTURE_ID_JOUR = "id_jour";

    public static final String CREATE_TABLE_OUVERTURE = "create table "
            + TABLE_OUVERTURE
            + "("
            + COLUMN_OUVERTURE_ID_BAR + " integer not null references " + BarDAO.TABLE_BAR + "("+ BarDAO.COLUMN_BAR_ID +"), "
            + COLUMN_OUVERTURE_ID_JOUR + " integer not null references " + JourDAO.TABLE_JOUR+ "("+ JourDAO.COLUMN_JOUR_ID +"), "
            + COLUMN_OUVERTURE_HORAIRE_OUV + " text not null, "
            + COLUMN_OUVERTURE_HORAIRE_FERM + " text not null, "
            + COLUMN_OUVERTURE_HORAIRE_HH_DEB + " text not null, "
            + COLUMN_OUVERTURE_HORAIRE_HH_FIN + " text not null, "
            + "PRIMARY KEY (" + COLUMN_OUVERTURE_ID_BAR + "," + COLUMN_OUVERTURE_ID_JOUR + ")"
            + ");";

    public static final String DROP_TABLE_OUVERTURE = "DROP IF EXISTS " + TABLE_OUVERTURE;

    private String[] allColumnOuverture = {
            COLUMN_OUVERTURE_ID_BAR, COLUMN_OUVERTURE_ID_JOUR, COLUMN_OUVERTURE_HORAIRE_OUV,
            COLUMN_OUVERTURE_HORAIRE_FERM, COLUMN_OUVERTURE_HORAIRE_HH_DEB, COLUMN_OUVERTURE_HORAIRE_HH_FIN
    };

    public OuvertureDAO (Context context) {
        super(context);
    }
}
