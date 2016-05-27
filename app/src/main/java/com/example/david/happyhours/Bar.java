package com.example.david.happyhours;

/**
 * Created by Valentin on 30/04/2016.
 */

//La base Bar en elle même
public class Bar {

    // Attributs

    private long id;
    private String nom;
    private String adresse;
    private String horaire_ouv;
    private String horaire_ferm;
    private String horaire_hh_deb;
    private String horaire_hh_fin;
    private String image;
    private int estFavori;

    // Constructeurs

    /**
     * Constructeur par défaut
     *
     * @see DatabaseHelper > bulkInsertBar()
     */
    public Bar() {
    }

    /**
     * Constructeur de Bar
     * @param id
     * @param nom
     * @param adresse
     * @param image
     * @param estFavori
     */
    public Bar(long id, String nom, String adresse, String image, int estFavori) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
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
                ", image='" + image + '\'' +
                ", estFavori=" + estFavori +
                '}';
    }
}
