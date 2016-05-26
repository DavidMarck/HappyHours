package com.example.david.happyhours;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 26/05/2016.
 */
public class OuvertureDAO extends DatabaseDAO {

    // nom du fichier .csv contenant les données à entrer dans la table ouverture
    public static final String CSV_OUVERTURE = "donnees_ouverture.csv";

    // TABLE OUVERTURE - colonnes et requêtes de création/suppresion

    public static final String TABLE_OUVERTURE = "ouverture";
    public  static final String COLUMN_OUVERTURE_ID = "_id";
    public static final String COLUMN_OUVERTURE_HORAIRE_OUV = "horaire_ouv";
    public static final String COLUMN_OUVERTURE_HORAIRE_FERM = "horaire_ferm";
    public static final String COLUMN_OUVERTURE_HORAIRE_HH_DEB = "horaire_hh_deb";
    public static final String COLUMN_OUVERTURE_HORAIRE_HH_FIN = "horaire_hh_fin";
    public static final String COLUMN_OUVERTURE_ID_BAR = "id_bar";
    public static final String COLUMN_OUVERTURE_ID_JOUR = "id_jour";
    public static final String CREATE_TABLE_OUVERTURE = "create table "
            + TABLE_OUVERTURE
            + "("
            + COLUMN_OUVERTURE_ID + " integer primary key autoincrement, "
            + COLUMN_OUVERTURE_ID_BAR + " integer not null CONSTRAINT fk_ouverture_bar references " + BarDAO.TABLE_BAR + "("+ BarDAO.COLUMN_BAR_ID +"), "
            + COLUMN_OUVERTURE_ID_JOUR + " integer not null CONSTRAINT fk_ouverture_jour references " + JourDAO.TABLE_JOUR+ "("+ JourDAO.COLUMN_JOUR_ID +"), "
            + COLUMN_OUVERTURE_HORAIRE_OUV + " text not null, "
            + COLUMN_OUVERTURE_HORAIRE_FERM + " text not null, "
            + COLUMN_OUVERTURE_HORAIRE_HH_DEB + " text default null, "
            + COLUMN_OUVERTURE_HORAIRE_HH_FIN + " text default null"
            + ");";

    public static final String DROP_TABLE_OUVERTURE = "DROP IF EXISTS " + TABLE_OUVERTURE;

    public static final String[] allColumnOuverture = {
            COLUMN_OUVERTURE_ID, COLUMN_OUVERTURE_ID_BAR, COLUMN_OUVERTURE_ID_JOUR,
            COLUMN_OUVERTURE_HORAIRE_OUV, COLUMN_OUVERTURE_HORAIRE_FERM, COLUMN_OUVERTURE_HORAIRE_HH_DEB,
            COLUMN_OUVERTURE_HORAIRE_HH_FIN
    };

    public OuvertureDAO (Context context) {
        super(context);
    }

    /**
     * Obtention de la table Ouverture sous forme de List
     *
     *
     * @return liste des entrées enregistrées dans la table ouverture correspondant à la recherche
     */
    public List<Ouverture> getAllOuverture(long idBar, long idJour) {
        List<Ouverture> toutesLesOuvertures = new ArrayList<Ouverture>();

        Cursor cursor = database.query(TABLE_OUVERTURE, allColumnOuverture, COLUMN_OUVERTURE_ID_BAR + " = ? AND " + COLUMN_OUVERTURE_ID_JOUR + " = ? ", new String[]{Long.toString(idBar),Long.toString(idJour)}, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Ouverture ouverture = cursorToOuverture(cursor);
            toutesLesOuvertures.add(ouverture);
            cursor.moveToNext();
        }
        cursor.close();
        return toutesLesOuvertures;
    }

    /**
     * Convertit un objet de type Cursor en un objet de type Ouverture
     *
     * @param cursor
     * @return
     */
    private Ouverture cursorToOuverture(Cursor cursor) {
        Ouverture ouverture = new Ouverture();
        ouverture.setId(cursor.getLong(0));
        ouverture.setId_bar(cursor.getLong(1));
        ouverture.setId_jour(cursor.getLong(2));
        ouverture.setHoraire_ouv(cursor.getString(3));
        ouverture.setHoraire_ferm(cursor.getString(4));
        ouverture.setHoraire_hh_deb(cursor.getString(5));
        ouverture.setHoraire_hh_fin(cursor.getString(6));
        return ouverture;
    }
}
