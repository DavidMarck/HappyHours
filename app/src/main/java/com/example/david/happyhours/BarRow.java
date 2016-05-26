package com.example.david.happyhours;

/**
 * Created by David on 23/05/2016.
 *
 * Classe objet modèle contenant les informations affichées
 * dans la ListView de l'activité accueil.
 */
public class BarRow {

    private String nom,happy_hours,adresse,horaires;

    /**
     * Constructeur
     *
     * @param nom
     * @param hh_deb
     * @param hh_fin
     * @param adresse
     * @param hor_ouv
     * @param hor_ferm
     */
    public BarRow(String nom, String hh_deb, String hh_fin, String adresse, String hor_ouv, String hor_ferm) {
        this.nom = nom;
        this.happy_hours = hh_deb.equals("null") ? "Pas d'Happy Hours" : hh_deb + " - " + hh_fin;
        this.adresse = adresse;
        this.horaires = hor_ouv + " - " + hor_ferm;
    }

    // Getters & Setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getHappy_hours() {
        return happy_hours;
    }

    public void setHappy_hours(String happy_hours) {
        this.happy_hours = happy_hours;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getHoraires() {
        return horaires;
    }

    public void setHoraires(String horaires) {
        this.horaires = horaires;
    }
}
