/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapp;

import java.sql.Time;

/**
 *
 * @author ITU
 */
public class Emploi {
    private int id_emploi;
    private int id_personne;
    private Time entree;
    private Time sortie;

    public Emploi(int id_emploi, int id_personne, Time entree, Time sortie) {
        this.id_emploi = id_emploi;
        this.id_personne = id_personne;
        this.entree = entree;
        this.sortie = sortie;
    }

    public Emploi() {
    }

    public int getId_emploi() {
        return id_emploi;
    }

    public void setId_emploi(int id_emploi) {
        this.id_emploi = id_emploi;
    }

    public int getId_personne() {
        return id_personne;
    }

    public void setId_personne(int id_personne) {
        this.id_personne = id_personne;
    }

    public Time getEntree() {
        return entree;
    }

    public void setEntree(Time entree) {
        this.entree = entree;
    }
    
    public Time setEntree(String entree) {
        Time heurePoint=Time.valueOf(entree);
        return heurePoint;
    }
    
    public Time getSortie() {
        return sortie;
    }

    public void setSortie(Time sortie) {
        this.sortie = sortie;
    }
    
    public Time setSortie(String sortie) {
        Time heurePoint=Time.valueOf(sortie);
        return heurePoint;
    }
}
