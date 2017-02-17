package javaapp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.text.ParseException;
import java.util.Date;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javaapp.JTableRow.model;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Conge_frame extends JFrame
{
    static DefaultTableModel model = new DefaultTableModel();
    public Conge_frame()
    {
        JTable table = new JTable();
        
        JLabel nom_prenom_label = new JLabel("Tapez le nom des employés ici:");
        JTextField nom_prenom_texte = new JTextField();
        
        JLabel daty_label = new JLabel("Date d'aujourd'hui:");
        JTextField daty_texte = new JTextField();
        
        JScrollPane pane = new JScrollPane(table);
        
        JLabel nomPrenom_label = new JLabel("Nom et prenoms(s):");
        JTextField nom_texte = new JTextField();
        JTextField prenom_texte = new JTextField();
        JLabel matricule_label = new JLabel("N°matricule:");
        JTextField matricule_texte = new JTextField();
        
        JLabel date_debut_label=new JLabel("Date debut de congé:");
        JTextField date_debut_texte = new JTextField();
        
        JLabel heure_debut_label = new JLabel("Heure debut de congé:");
        JTextField heure_debut_texte = new JTextField();
        
        JLabel date_fin_label=new JLabel("Date fin de congé:");
        JTextField date_fin_texte = new JTextField();
        
        JLabel heure_fin_label = new JLabel("Heure fin de congé:");
        JTextField heure_fin_texte = new JTextField();
        
        JLabel motif_label = new JLabel("Remarques:");
        JTextField motif_texte = new JTextField();
        
        JButton insert_conge = new JButton("Inserer congé");
        JButton valider_conge = new JButton("Valider congé");
        JButton reliquat = new JButton("Voir le reliquat");
        
        Object[] columns = {"Numero","N°Matricule","Nom","Prenoms","Debut dernière congé","Fin dernière congé"};
        
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        
        table.setBackground(Color.gray);
        table.setForeground(Color.white);
        
        Font font = new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);
        
        
        nom_prenom_label.setBounds(10, 20, 200, 30);
        nom_prenom_texte.setBounds(220, 20, 150, 30);
        daty_label.setBounds(550, 20, 150, 30);
        daty_texte.setBounds(670, 20, 150, 30);
        pane.setBounds(0, 70, 880, 100);
        nomPrenom_label.setBounds(10, 180, 150, 30);
        nom_texte.setBounds(160, 180, 150, 30);
        prenom_texte.setBounds(350, 180, 150, 30);
        matricule_label.setBounds(540, 180, 150, 30);
        matricule_texte.setBounds(730, 180, 150, 30);
        
        date_debut_label.setBounds(10, 220, 150, 30);
        date_debut_texte.setBounds(160, 220, 150, 30);
        heure_debut_label.setBounds(350, 220, 150, 30);
        heure_debut_texte.setBounds(540, 220, 150, 30);
        
        date_fin_label.setBounds(10, 260, 150, 30);
        date_fin_texte.setBounds(160, 260, 150, 30);
        heure_fin_label.setBounds(350, 260, 150, 30);
        heure_fin_texte.setBounds(540, 260, 150, 30);
        
        motif_label.setBounds(10, 300, 150, 30);
        motif_texte.setBounds(160, 300, 700, 100);
        
        reliquat.setBounds(10, 500, 150, 30);
        valider_conge.setBounds(710, 500, 150, 30);
        insert_conge.setBounds(400, 450, 150, 30);
        
        add(nom_prenom_label);
        add(nom_prenom_texte);
        add(daty_label);
        add(daty_texte);
        add(pane);
        add(nomPrenom_label);
        add(nom_texte);
        add(prenom_texte);
        add(matricule_label);
        add(matricule_texte);
        add(date_debut_label);
        add(date_debut_texte);
        add(heure_debut_label);
        add(heure_debut_texte);
        add(date_fin_label);
        add(date_fin_texte);
        add(heure_fin_label);
        add(heure_fin_texte);
        add(motif_label);
        add(motif_texte);
        add(reliquat);
        add(valider_conge);
        add(insert_conge);
        
        nom_prenom_texte.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                try
                {
                    Fonction f = new Fonction();
                    
                    String nom = nom_prenom_texte.getText();
                    
                    
                    Employe[] emp=null;
                    model = new DefaultTableModel();
                     Object[] columns = {"Numero","N°Matricule","Nom","Prenoms","Debut dernière congé","Fin dernière congé"};
                    //DefaultTableModel model2 = new DefaultTableModel();
                    model.setColumnIdentifiers(columns);
                        
                        emp=f.emp(nom);
                        System.out.println(emp.length);
                        if(emp.length>0)
                        {
                           Object[] row = new Object[4];
                            for(int j=0;j<emp.length;j++)
                            {
                                row[0] = emp[j].getId_employe();
                                row[1] = emp[j].getIdentifiant();
                                row[2] = emp[j].getNom();
                                row[3] = emp[j].getPrenoms();
                                model.addRow(row);
                                

                            }
                            table.setModel(model);
                        }
                        else
                        {
                            model = new DefaultTableModel();
                            Object[] colu = {"Numero","N°Matricule","Nom","Prenoms","Debut dernière congé","Fin dernière congé"};
                           //DefaultTableModel model2 = new DefaultTableModel();
                           model.setColumnIdentifiers(colu);
                           table.setModel(model);
                        }
                        
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
                
            }
        });
        
        table.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e)
            {
                int i = table.getSelectedRow();
                nom_texte.setText(model.getValueAt(i, 2).toString());
                prenom_texte.setText(model.getValueAt(i, 3).toString());
                matricule_texte.setText(model.getValueAt(i, 1).toString());
            }

            });
        
        insert_conge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try 
                {
                    Fonction f = new Fonction();
                    Conge c = new Conge();
                    Date d_now=c.setDaty(daty_texte.getText());
                    Date d_debut=c.setDaty(date_debut_texte.getText());
                    Date d_fin=c.setDaty(date_fin_texte.getText());
                    
                    Time c_debut=c.setheure(heure_debut_texte.getText());
                    Time c_fin=c.setheure(heure_fin_texte.getText());
                    
                    Timestamp debut = new Timestamp(d_debut.getYear(), d_debut.getMonth(), d_debut.getDate(), c_debut.getHours(), c_debut.getMinutes(), c_debut.getSeconds(), 0);
                    Timestamp fin = new Timestamp(d_fin.getYear(), d_fin.getMonth(), d_fin.getDate(), c_fin.getHours(), c_fin.getMinutes(), c_fin.getSeconds(), 0);
                    
                    long ms=fin.getTime()-debut.getTime();
                    System.out.println(ms);
                    long seconde = ms/1000;
                    long minute = seconde/60;
                    long heure = minute/60;
                    
                    int heure_int=(int)heure;
                    
                    //System.out.println(d_now);
                    System.out.println(heure_int);
                    /*System.out.println(d_fin);
                    System.out.println(c_debut);
                    System.out.println(c_fin);*/
                    int id_emp=f.maka_id_employe(matricule_texte.getText());
                    //System.out.println(d_debut);
                    //int heure = 0;
                    
                    c.setId_employe(id_emp);
                    c.setDaty_now(d_now);
                    c.setDaty_debut(d_debut);
                    c.setDaty_fin(d_fin);
                    c.setHeure_debut(c_debut);
                    c.setHeure_fin(c_fin);
                    c.setMotif(motif_texte.getText());
                    c.setNombre_jours(heure_int);
                    
                    f.insert_conge(c);
                    
                    
                } 
                catch (Exception ex) 
                {
                    ex.printStackTrace();
                }
                
                
            }
        });
        
        valider_conge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Valider_conge_frame();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        this.setSize(900, 600);
        this.setTitle("Congé");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
}
