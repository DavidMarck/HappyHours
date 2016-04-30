package com.example.david.happyhours;

/**
 * Created by Valentin on 30/04/2016.
 */

//La base bar en elle même
public class bar {

    private long id;
    private String nom;

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


    @Override
    public String toString() {
        return nom;
    }
}
