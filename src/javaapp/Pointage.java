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
public class Pointage {
    private int id_pointage;
    private int id_personne;
    private Time heure;
    private Date daty;
    private int type_pointage;
    private String jour;

   public Pointage() {
    }
   
   public Pointage(int id_pointage, int id_personne, Time heure, Date daty, int type_pointage, String jour) {
        this.id_pointage = id_pointage;
        this.id_personne = id_personne;
        this.heure = heure;
        this.daty = daty;
        this.type_pointage = type_pointage;
        this.jour = jour;
    }
    
    

    public int getId_pointage() {
        return id_pointage;
    }

    public void setId_pointage(int id_pointage) {
        this.id_pointage = id_pointage;
    }

    public int getId_personne() {
        return id_personne;
    }

    public void setId_personne(int id_personne) {
        this.id_personne = id_personne;
    }

    public Time getHeure() {
        return heure;
    }

    public Time setHeure(String heure) {
        Time heurePoint=Time.valueOf(heure);
        return heurePoint;
    }

    public void setHeure(Time heure) {
        this.heure = heure;
    }
    
    
    
    public Date getDaty() {
        return daty;
    }

    public Date setDaty(String daty) throws ParseException {
        Date d=null;
        Fonction f=new Fonction();
        String da = f.formatDate(daty);
        SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd");
        d = sdf.parse(da);
        return d;
    }
    
     public void setDaty(Date daty) {
        this.daty = daty;
    }

    public int getType_pointage() {
        return type_pointage;
    }

    public void setType_pointage(int type_pointage) {
        this.type_pointage = type_pointage;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    
    
    
    
    
}
