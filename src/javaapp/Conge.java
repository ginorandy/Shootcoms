/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapp;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ITU
 */
public class Conge {
    private int id_conge;
    private int id_employe;
    private Date daty_now;
    private Date daty_debut;
    private Time heure_debut;
    private Date daty_fin;
    private Time heure_fin;
    private String motif;
    private int nombre_jours;

    public Conge() {
    }

    public Conge(int id_conge, int id_employe, Date daty_now, Date daty_debut, Time heure_debut, Date daty_fin, Time heure_fin, String motif, int nombre_jours) {
        this.id_conge = id_conge;
        this.id_employe = id_employe;
        this.daty_now = daty_now;
        this.daty_debut = daty_debut;
        this.heure_debut = heure_debut;
        this.daty_fin = daty_fin;
        this.heure_fin = heure_fin;
        this.motif = motif;
        this.nombre_jours = nombre_jours;
    }
    
    
    
    public int getId_conge() {
        return id_conge;
    }

    public void setId_conge(int id_conge) {
        this.id_conge = id_conge;
    }

    public int getId_employe() {
        return id_employe;
    }

    public void setId_employe(int id_employe) {
        this.id_employe = id_employe;
    }

    public Date getDaty_now() {
        return daty_now;
    }

    public void setDaty_now(Date daty_now) {
        this.daty_now = daty_now;
    }

    public Date getDaty_debut() {
        return daty_debut;
    }

    public void setDaty_debut(Date daty_debut) {
        this.daty_debut = daty_debut;
    }

    public Time getHeure_debut() {
        return heure_debut;
    }

    public void setHeure_debut(Time heure_debut) {
        this.heure_debut = heure_debut;
    }

    public Date getDaty_fin() {
        return daty_fin;
    }

    public void setDaty_fin(Date daty_fin) {
        this.daty_fin = daty_fin;
    }

    public Time getHeure_fin() {
        return heure_fin;
    }

    public void setHeure_fin(Time heure_fin) {
        this.heure_fin = heure_fin;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }
    
    public Time setheure(String heure) {
        Time heurePoint=Time.valueOf(heure);
        return heurePoint;
    }
    
    public Date setDaty(String daty) throws ParseException {
        Date d=null;
        Fonction f=new Fonction();
        String da = f.formatDate(daty);
        SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd");
        d = sdf.parse(da);
        return d;
    }

    public int getNombre_jours() {
        return nombre_jours;
    }

    public void setNombre_jours(int nombre_jours) {
        this.nombre_jours = nombre_jours;
    }
}
