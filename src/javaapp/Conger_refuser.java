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
public class Conger_refuser {
    private int id_conger_refuser;
    private int id_conge;

    public Conger_refuser() {
    }

    public Conger_refuser(int id_conger_refuser, int id_conge) {
        this.id_conger_refuser = id_conger_refuser;
        this.id_conge = id_conge;
    }

    public int getId_conger_refuser() {
        return id_conger_refuser;
    }

    public void setId_conger_refuser(int id_conger_refuser) {
        this.id_conger_refuser = id_conger_refuser;
    }

    public int getId_conge() {
        return id_conge;
    }

    public void setId_conge(int id_conge) {
        this.id_conge = id_conge;
    }
}
