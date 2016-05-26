package com.example.david.happyhours;

/**
 * Created by David on 26/05/2016.
 */
public class Ouverture {

    // Attributs

    private String horaire_ouv, horaire_ferm, horaire_hh_deb, horaire_hh_fin;
    private long id_bar, id_jour;

    /**
     * Constructeur par défaut
     *
     * @see DatabaseHelper > bulkInsertOuverture()
     */
    public Ouverture() {

    }

    /**
     * Constructeur de Ouverture
     * @param horaire_ouv
     * @param horaire_ferm
     * @param horaire_hh_deb
     * @param horaire_hh_fin
     * @param id_bar
     * @param id_jour
     */
    public Ouverture(String horaire_ouv, String horaire_ferm, String horaire_hh_deb, String horaire_hh_fin, long id_bar, long id_jour) {
        this.horaire_ouv = horaire_ouv;
        this.horaire_ferm = horaire_ferm;
        this.horaire_hh_deb = horaire_hh_deb;
        this.horaire_hh_fin = horaire_hh_fin;
        this.id_bar = id_bar;
        this.id_jour = id_jour;
    }

    // Getters & Setters

    public String getHoraire_ouv() {
        return horaire_ouv;
    }

    public void setHoraire_ouv(String horaire_ouv) {
        this.horaire_ouv = horaire_ouv;
    }

    public String getHoraire_ferm() {
        return horaire_ferm;
    }

    public void setHoraire_ferm(String horaire_ferm) {
        this.horaire_ferm = horaire_ferm;
    }

    public String getHoraire_hh_deb() {
        return horaire_hh_deb;
    }

    public void setHoraire_hh_deb(String horaire_hh_deb) {
        this.horaire_hh_deb = horaire_hh_deb;
    }

    public String getHoraire_hh_fin() {
        return horaire_hh_fin;
    }

    public void setHoraire_hh_fin(String horaire_hh_fin) {
        this.horaire_hh_fin = horaire_hh_fin;
    }

    public long getId_bar() {
        return id_bar;
    }

    public void setId_bar(long id_bar) {
        this.id_bar = id_bar;
    }

    public long getId_jour() {
        return id_jour;
    }

    public void setId_jour(long id_jour) {
        this.id_jour = id_jour;
    }

    @Override
    public String toString() {
        return "Ouverture{" +
                "horaire_ouv='" + horaire_ouv + '\'' +
                ", horaire_ferm='" + horaire_ferm + '\'' +
                ", horaire_hh_deb='" + horaire_hh_deb + '\'' +
                ", horaire_hh_fin='" + horaire_hh_fin + '\'' +
                ", id_bar=" + id_bar +
                ", id_jour=" + id_jour +
                '}';
    }
}
