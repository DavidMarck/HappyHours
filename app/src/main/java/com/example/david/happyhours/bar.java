package com.example.david.happyhours;

/**
 * Created by Valentin on 30/04/2016.
 */

//La base bar en elle même
public class bar {

    int id;
    String nom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public bar(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
}
