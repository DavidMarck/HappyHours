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
     * @param horaire_ouv
     * @param horaire_ferm
     * @param horaire_hh_deb
     * @param horaire_hh_fin
     * @param image
     * @param estFavori
     */
    public Bar(long id, String nom, String adresse, String horaire_ouv, String horaire_ferm, String horaire_hh_deb, String horaire_hh_fin, String image, int estFavori) {
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
