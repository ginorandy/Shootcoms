/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapp;

import java.util.Date;

/**
 *
 * @author ITU
 */
public class Employe {
    private int id_employe;
    private String identifiant;
    private String nom;
    private int departement;
    private String prenoms;
    private Date date_embauche;

    public Employe(int id_employe, String identifiant, String nom, int departement, String prenoms, Date date_embauche) {
        this.id_employe = id_employe;
        this.identifiant = identifiant;
        this.nom = nom;
        this.departement = departement;
        this.prenoms = prenoms;
        this.date_embauche = date_embauche;
    }
    

    public Employe() {
    }

    public int getId_employe() {
        return id_employe;
    }

    public void setId_employe(int id_employe) {
        this.id_employe = id_employe;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDepartement() {
        return departement;
    }

    public void setDepartement(int departement) {
        this.departement = departement;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    public Date getDate_embauche() {
        return date_embauche;
    }

    public void setDate_embauche(Date date_embauche) {
        this.date_embauche = date_embauche;
    }
    
    
    
    
}
