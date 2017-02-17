/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapp;

/**
 *
 * @author ITU
 */
public class Departement {
    private int id_departement;
    private String designation;

    public Departement(int id_departement, String designation) {
        this.id_departement = id_departement;
        this.designation = designation;
    }

    public Departement() {
    }
    
    public int getId_departement() {
        return id_departement;
    }

    public void setId_departement(int id_departement) {
        this.id_departement = id_departement;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
