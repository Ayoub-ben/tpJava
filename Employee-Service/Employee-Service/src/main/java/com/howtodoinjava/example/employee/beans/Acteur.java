package com.howtodoinjava.example.employee.beans;

import java.util.Date;
import java.util.List;

public class Acteur {
    private String firstName;
    private String lastName;
    private Date anniv;
    private List<Film> films;

    // Constructeur
    public Acteur(String firstName, String lastName, Date anniv, List<Film> films) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.anniv = anniv;
        this.films = films;
    }

    // Getters et Setters pour chaque propriété
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getAnniv() {
        return anniv;
    }

    public void setAnniv(Date anniv) {
        this.anniv = anniv;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}

