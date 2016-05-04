package com.example.david.happyhours;

/**
 * Created by David on 04/05/2016.
 */
public class Biere {

    // Attributs

    private long id;
    private String nom;
    private String descr;
    private long id_type;

    // Constructeurs

    public Biere() {
        // default constructor
    }

    public Biere(long id, String nom, String descr, long id_type) {
        this.id = id;
        this.nom = nom;
        this.descr = descr;
        this.id_type = id_type;
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

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public long getId_type() {
        return id_type;
    }

    public void setId_type(long id_type) {
        this.id_type = id_type;
    }

    // Méthodes

    @Override
    public String toString() {
        return "Biere{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", descr='" + descr + '\'' +
                ", id_type=" + id_type +
                '}';
    }
}
