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
public class TypePointage {
    private int id_type;
    private String designation;

    public TypePointage(int id_type, String designation) {
        this.id_type = id_type;
        this.designation = designation;
    }

    public TypePointage() {
        
    }

    public int getId_type() {
        return id_type;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    
    
}
