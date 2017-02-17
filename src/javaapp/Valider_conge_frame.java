package javaapp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javaapp.JTableRow.model;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Valider_conge_frame extends JFrame
{
    static DefaultTableModel model = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int col) {
                    switch (col) {
                        case 0:
                            return true;
                        default:
                            return false;
                    }
                }

                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    if (columnIndex == 0) {
                        return Boolean.class;
                    }
                    return super.getColumnClass(columnIndex);
                }
            };
    public Valider_conge_frame() throws Exception
    {
        
        JTable table = new JTable();
        JScrollPane pane = new JScrollPane(table);
        
        JButton annuler = new JButton("Annuler");
        JButton valider = new JButton("Valider");
        JButton refuser = new JButton("Refuser");
        
        Object[] columns = {"","Id_congé","Matricule","Nom","Prenoms","Remarques","Nombre d'heures"};
        
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        
        table.setBackground(Color.gray);
        table.setForeground(Color.white);
        
        Font font = new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);
        
        pane.setBounds(0, 10, 880, 500);
        annuler.setBounds(10, 600, 150, 30);
        refuser.setBounds(390, 600, 150, 30);
        valider.setBounds(730, 600, 150, 30);
        
        add(pane);
        add(annuler);
        add(refuser);
        add(valider);
        
        Object[] row = new Object[7];
        Conge[] e=null;
        Fonction f = new Fonction();
        e=f.c();
        System.out.println(e.length);
        for(int j=0;j<e.length;j++)
        {
            boolean check=false;
            row[0] = (Object)check;
            row[1] = e[j].getId_conge();
            row[2] = f.maka_matricule_employe(e[j].getId_employe());
            row[3] = f.maka_nom_employe(e[j].getId_employe());
            row[4] = f.maka_prenom_employe(e[j].getId_employe());
            row[5] = e[j].getMotif();
            row[6] = e[j].getNombre_jours();
            model.addRow(row);

        }
        table.setModel(model);
        //DefaultTableModel model = new DefaultTableModel(data, title) ;
        
        valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try 
                {
                    model = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int col) {
                    switch (col) {
                        case 0:
                            return true;
                        default:
                            return false;
                    }
                }

                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    if (columnIndex == 0) {
                        return Boolean.class;
                    }
                    return super.getColumnClass(columnIndex);
                }
            };
                    Object[] columns = {"","Id_congé","Matricule","Nom","Prenoms","Remarques","Nombre d'heures"};
                    model.setColumnIdentifiers(columns);
                    for(int i=0;i<table.getRowCount();i++)
                    {
                        if((boolean)table.getValueAt(i, 0))
                        {
                           Conger_valider c = new Conger_valider();
                           c.setId_conge((int) table.getValueAt(i, 1));
                           //f.insert_conge_valider(c);
                           
                           int idbymatricule = f.maka_id_employe((String) table.getValueAt(i, 2));
                           System.out.println(idbymatricule);
                           int nombre_conge_total = f.maka_id_nombre_jour_conge(idbymatricule);
                           System.out.println(nombre_conge_total);
                           int reste = nombre_conge_total - ((int)table.getValueAt(i, 6));
                           //f.modifier_reste_jour_conge(reste,idbymatricule);
                           System.out.println(reste);
                           //f.supprimer_conge((int) table.getValueAt(i, 1));
                           new Conge_frame();
                           
                        } 
                   }
                    table.setModel(model);
                }
                
                catch (Exception ex) 
                {
                    ex.printStackTrace();
                } 
                
            }
        });
        refuser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try 
                {
                    model = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int col) {
                    switch (col) {
                        case 0:
                            return true;
                        default:
                            return false;
                    }
                }

                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    if (columnIndex == 0) {
                        return Boolean.class;
                    }
                    return super.getColumnClass(columnIndex);
                }
            };
                    Object[] columns = {"","Id_congé","Matricule","Nom","Prenoms","Remarques","Nombre d'heures"};
                    model.setColumnIdentifiers(columns);
                    for(int i=0;i<table.getRowCount();i++)
                    {
                        if((boolean)table.getValueAt(i, 0))
                        {
                           Conger_refuser c = new Conger_refuser();
                           c.setId_conge((int) table.getValueAt(i, 1));
                           f.insert_conge_refuser(c);
                           f.supprimer_conge((int) table.getValueAt(i, 1));
                           new Conge_frame();
                        } 
                   }
                    table.setModel(model);
                }
                
                catch (Exception ex) 
                {
                    ex.printStackTrace();
                }
            }
        });
        
        this.setSize(900, 700);
        this.setTitle("Congé");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
}
