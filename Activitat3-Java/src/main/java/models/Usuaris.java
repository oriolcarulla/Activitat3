package models;

import org.bson.Document;

public class Usuaris {
    private String nom_usuari;
    private int seguidors;
    private boolean verificat;

    public Usuaris(String nom_usuari, int seguidors, boolean verificat) {
        this.nom_usuari = nom_usuari;
        this.seguidors = seguidors;
        this.verificat = verificat;
    }
    //Getters and Setters
    public String getNom_usuari() {
        return nom_usuari;
    }
    public int getSeguidors() {
        return seguidors;
    }
    public boolean isVerificat() {
        return verificat;
    }

    public void setNom_usuari(String nom_usuari) {
        this.nom_usuari = nom_usuari;
    }
    public void setSeguidors(int seguidors) {
        this.seguidors = seguidors;
    }
    public void setVerificat(boolean verificat) {
        this.verificat = verificat;
    }

    public Document toDocument(){
        Document document = new Document();
        document.append("nom_usuari", this.nom_usuari)
                .append("seguidors", this.seguidors)
                .append("verificat", this.verificat);
        return document;
    }

    @Override
    public String toString() {
        return "Usuaris{" + "nom_usuari=" + nom_usuari + ", seguidors=" + seguidors + ", verificat=" + verificat + '}';
    }
}
