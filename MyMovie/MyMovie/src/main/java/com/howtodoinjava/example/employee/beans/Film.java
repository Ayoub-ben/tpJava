package com.howtodoinjava.example.employee.beans;

import java.util.Date;
import java.util.List;

public class Film {
    private String titre;
    private String realisateur;
    private Date sortieDate;
    private List<Acteur> acteurs;

    // Constructeur
    public Film(String titre, String realisateur, Date sortieDate, List<Acteur> acteurs) {
        this.titre = titre;
        this.realisateur = realisateur;
        this.sortieDate = sortieDate;
        this.acteurs = acteurs;
    }

    // Getters et Setters pour chaque propriété
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public Date getSortieDate() {
        return sortieDate;
    }

    public void setSortieDate(Date sortieDate) {
        this.sortieDate = sortieDate;
    }

    public List<Acteur> getActeurs() {
        return acteurs;
    }

    public void setActeurs(List<Acteur> acteurs) {
        this.acteurs = acteurs;
    }
}


