package com.example.david.happyhours;

import java.util.Date;

/**
 * Created by Valentin on 30/04/2016.
 */

//La base Bar en elle même
public class Bar {

    // Attributs

    private long id;
    private String nom;
    private String adresse;
    private Date horaire_ouv;
    private Date horaire_ferm;
    private Date horaire_hh_deb;
    private Date horaire_hh_fin;
    private String image;
    private int estFavori;

    // Constructeurs

    public Bar() {
        // default constructor
    }

    public Bar(long id, String nom, String adresse, Date horaire_ouv, Date horaire_ferm, Date horaire_hh_deb, Date horaire_hh_fin, String image, int estFavori) {
        super();
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.horaire_ouv = horaire_ouv;
        this.horaire_ferm = horaire_ferm;
        this.horaire_hh_deb = horaire_hh_deb;
        this.horaire_hh_fin = horaire_hh_fin;
        this.image = image;
        this.estFavori = estFavori;
    }


    // Getters & Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getHoraire_ouv() {
        return horaire_ouv;
    }

    public void setHoraire_ouv(Date horaire_ouv) {
        this.horaire_ouv = horaire_ouv;
    }

    public Date getHoraire_ferm() {
        return horaire_ferm;
    }

    public void setHoraire_ferm(Date horaire_ferm) {
        this.horaire_ferm = horaire_ferm;
    }

    public Date getHoraire_hh_deb() {
        return horaire_hh_deb;
    }

    public void setHoraire_hh_deb(Date horaire_hh_deb) {
        this.horaire_hh_deb = horaire_hh_deb;
    }

    public Date getHoraire_hh_fin() {
        return horaire_hh_fin;
    }

    public void setHoraire_hh_fin(Date horaire_hh_fin) {
        this.horaire_hh_fin = horaire_hh_fin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getEstFavori() {
        return estFavori;
    }

    public void setEstFavori(int estFavori) {
        this.estFavori = estFavori;
    }

    // Méthodes

    @Override
    public String toString() {
        return "Bar{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", horaire_ouv=" + horaire_ouv +
                ", horaire_ferm=" + horaire_ferm +
                ", horaire_hh_deb=" + horaire_hh_deb +
                ", horaire_hh_fin=" + horaire_hh_fin +
                ", image='" + image + '\'' +
                ", estFavori=" + estFavori +
                '}';
    }
}
