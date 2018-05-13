package cnam.smb116.tp7persistanceetpartage;

/**
 * Created by ludo on 29/03/2017.
 */

public class Permanence {
    private int id;
    private String nom;
    private String prenom;
    private String courriel;

    public Permanence(String nom, String prenom, String courriel){
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.courriel = courriel;
    }

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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }
}
