package com.example.david.happyhours;

/**
 * Created by David on 04/05/2016.
 */
public class TypeBiere {

    // Attributs

    private long id;
    private String lbl;

    // Constructeurs

    public TypeBiere() {
        // default constructor
    }

    public TypeBiere(long id, String lbl) {
        this.id = id;
        this.lbl = lbl;
    }

    // Getters & Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLbl() {
        return lbl;
    }

    public void setLbl(String lbl) {
        this.lbl = lbl;
    }

    // Méthodes

    @Override
    public String toString() {
        return "TypeBiere{" +
                "id=" + id +
                ", lbl='" + lbl + '\'' +
                '}';
    }
}
