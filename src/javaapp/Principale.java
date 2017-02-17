package javaapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Principale extends JFrame
{
    private JButton pointage = new JButton("Pointage");
    private JButton conge = new JButton("Congé");

    public Principale() throws Exception 
    {
        pointage.setBounds(70, 40, 100, 30);
        conge.setBounds(70, 110, 100, 30);
        
        pointage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                   JTableRow row = new JTableRow();
                    row.frame.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                
            }
        });
        
        conge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try
                {
                    new Conge_frame();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
        
        add(pointage);
        add(conge);
        
       
        this.setSize(200, 200);
        this.setTitle("Fenetre principale");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
    }

    public JButton getPointage() {
        return pointage;
    }

    public void setPointage(JButton pointage) {
        this.pointage = pointage;
    }

    public JButton getConge() {
        return conge;
    }

    public void setConge(JButton conge) {
        this.conge = conge;
    }
    
    
}
