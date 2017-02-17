/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Randy
 */
public class EcouteurAnnuler implements ActionListener{
    public EcouteurAnnuler()
    {
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        try 
        {
          JTableRow  row = new JTableRow();
            row.frame.setVisible(true);
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
        
    }
    
}
