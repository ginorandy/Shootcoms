/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Randy
 */
public class EcouteurEnregistrer implements MouseListener
{
    
    FenetreAjoutEmploye frame;
    public EcouteurEnregistrer() throws Exception 
    {
    }

    public EcouteurEnregistrer(FenetreAjoutEmploye f) throws Exception {
        frame = f;
    }

            


    @Override
    public void mouseClicked(MouseEvent me) {
        try 
            {
                Fonction f = new Fonction();
                frame.getId_texte().getText();
                int id_personne=Integer.parseInt(frame.getId_texte().getText());
                frame.getMatricule_texte().getText();
                frame.getNom_texte().getText();

                frame.getDepartement_box().getSelectedItem();
                int departement=f.maka_id_depart((String) frame.getDepartement_box().getSelectedItem());
                frame.getPrenom_texte().getText();
                
                frame.getEntree_texte().getText();
                frame.getSortie_texte().getText();
                
                

                System.out.println(frame.getId_texte().getText());
                System.out.println(frame.getMatricule_texte().getText());
                System.out.println(frame.getNom_texte().getText());
                System.out.println(frame.getDepartement_box().getSelectedItem());
                System.out.println(departement);
                System.out.println(frame.getPrenom_texte().getText());
                
                Employe emp=new Employe();
                Emploi temps=new Emploi();
                        
                Time entree=temps.setEntree(frame.getEntree_texte().getText());
                Time sortie=temps.setSortie(frame.getSortie_texte().getText());
                
                System.out.println(entree);
                System.out.println(sortie);
                        
                emp.setIdentifiant(frame.getMatricule_texte().getText());
                emp.setNom(frame.getNom_texte().getText());
                emp.setDepartement(departement);
                emp.setPrenoms(frame.getPrenom_texte().getText());
                
                temps.setId_personne(id_personne);
                temps.setEntree(entree);
                temps.setSortie(sortie);
                
                f.insert_employe(emp);
                f.insert_emploi_du_temps(temps);
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
}
