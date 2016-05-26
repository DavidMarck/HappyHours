package com.example.david.happyhours;

/**
 * Created by David on 26/05/2016.
 */
public class Jour {

    // Attributs

    private long id;
    private String lbl;

    /**
     * Constructeur par défaut
     *
     * @see DatabaseHelper > bulkInsertJour()
     */
    public Jour() {
    }

    /**
     * Constructeur de Jour
     *
     * @param id
     * @param lbl
     */
    public Jour(long id, String lbl){
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

    @Override
    public String toString() {
        return "Jour{" +
                "id=" + id +
                ", lbl='" + lbl + '\'' +
                '}';
    }
}
