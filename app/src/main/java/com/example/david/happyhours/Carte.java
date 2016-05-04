package com.example.david.happyhours;

/**
 * Created by David on 04/05/2016.
 */
public class Carte {

    //Attributs

    private long id_biere;
    private long id_bar;
    private float tarif_50;
    private float tarif_hh_50;
    private float tarif_100;
    private float tarif_hh_100;

    // Constructeurs

    public Carte() {
        // default constructor
    }

    public Carte(long id_biere, long id_bar, float tarif_50, float tarif_100, float tarif_hh_50, float tarif_hh_100) {
        this.id_biere = id_biere;
        this.id_bar = id_bar;
        this.tarif_50 = tarif_50;
        this.tarif_100 = tarif_100;
        this.tarif_hh_50 = tarif_hh_50;
        this.tarif_hh_100 = tarif_hh_100;
    }

    // Getters & Setters

    public long getId_biere() {
        return id_biere;
    }

    public void setId_biere(long id_biere) {
        this.id_biere = id_biere;
    }

    public long getId_bar() {
        return id_bar;
    }

    public void setId_bar(long id_bar) {
        this.id_bar = id_bar;
    }

    public float getTarif_50() {
        return tarif_50;
    }

    public void setTarif_50(float tarif_50) {
        this.tarif_50 = tarif_50;
    }

    public float getTarif_hh_50() {
        return tarif_hh_50;
    }

    public void setTarif_hh_50(float tarif_hh_50) {
        this.tarif_hh_50 = tarif_hh_50;
    }

    public float getTarif_100() {
        return tarif_100;
    }

    public void setTarif_100(float tarif_100) {
        this.tarif_100 = tarif_100;
    }

    public float getTarif_hh_100() {
        return tarif_hh_100;
    }

    public void setTarif_hh_100(float tarif_hh_100) {
        this.tarif_hh_100 = tarif_hh_100;
    }

    // Méthodes

    @Override
    public String toString() {
        return "Carte{" +
                "id_biere=" + id_biere +
                ", id_bar=" + id_bar +
                ", tarif_50=" + tarif_50 +
                ", tarif_hh_50=" + tarif_hh_50 +
                ", tarif_100=" + tarif_100 +
                ", tarif_hh_100=" + tarif_hh_100 +
                '}';
    }
}
