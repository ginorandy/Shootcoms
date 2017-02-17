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
public class Conger_valider {
    private int id_conger_valider;
    private int id_conge;

    public Conger_valider() {
    }

    public Conger_valider(int id_conger_valider, int id_conge) {
        this.id_conger_valider = id_conger_valider;
        this.id_conge = id_conge;
    }

    public int getId_conger_valider() {
        return id_conger_valider;
    }

    public void setId_conger_valider(int id_conger_valider) {
        this.id_conger_valider = id_conger_valider;
    }

    public int getId_conge() {
        return id_conge;
    }

    public void setId_conge(int id_conge) {
        this.id_conge = id_conge;
    }
    
    
}
