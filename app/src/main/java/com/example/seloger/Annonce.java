package com.example.seloger;

import java.io.Serializable;

public class Annonce implements Serializable {

    //Colones de la table Client
    private  String  id;
    private  String typeB;
    private  String typeA ;
    private  String gouvernerat;
    private  String ville ;
    private  String adresse;
    private  Integer superficie;
    private  Integer prix;
    private  String date;
    private  String description;
    private  Integer nbc ;
    private  String etat ;
    private  byte[] img ;

    public Annonce(String id, String typeB, String typeA, String gouvernerat, String ville, String adresse, Integer superficie, Integer prix, String date, String description, Integer nbc, String etat) {
        this.id = id;
        this.typeB = typeB;
        this.typeA = typeA;
        this.gouvernerat = gouvernerat;
        this.ville = ville;
        this.adresse = adresse;
        this.superficie = superficie;
        this.prix = prix;
        this.date = date;
        this.description = description;
        this.nbc = nbc;
        this.etat = etat;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeB() {
        return typeB;
    }

    public void setTypeB(String typeB) {
        this.typeB = typeB;
    }

    public String getTypeA() {
        return typeA;
    }

    public void setTypeA(String typeA) {
        this.typeA = typeA;
    }

    public String getGouvernerat() {
        return gouvernerat;
    }

    public void setGouvernerat(String gouvernerat) {
        this.gouvernerat = gouvernerat;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Integer getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Integer superficie) {
        this.superficie = superficie;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNbc() {
        return nbc;
    }

    public void setNbc(Integer nbc) {
        this.nbc = nbc;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
}
