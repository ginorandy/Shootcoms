package javaapp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.lang.Object;
import java.sql.Time;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Randy
 */
public class JTableRow {
    static DefaultTableModel model = new DefaultTableModel();
    static JFrame frame = new JFrame();

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
    
    public JTableRow() throws Exception{
        // TODO code application logic here
        
        JTable table = new JTable();
        
        Object[] columns = {"Numero","N°Matricule","Nom","Prenoms","Lundi","Retard Lundi","Mardi","Retard Mardi","Mercredi","Retard Mercredi","Jeudi","Retard Jeudi","Vendredi","Retard Vendredi","Samedi","Retard Samedi","Dimanche","Retard Dimanche","Total"};
        
        /*DefaultTableModel model = new DefaultTableModel(data, title) {
                @Override
                public boolean isCellEditable(int row, int col) {
                    switch (col) {
                        case 0:
                        case 4:
                            return true;
                        default:
                            return false;
                    }
                }}*/
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        
        table.setBackground(Color.gray);
        table.setForeground(Color.white);
        
        Font font = new Font("",1,22);
        table.setFont(font);
        table.setRowHeight(30);
        
        
        JComboBox depart;
        JLabel poste = new JLabel("Departement:");
        Fonction f=new Fonction();
        
        Departement [] listedepartement = f.poste();
        int taille = listedepartement.length+1;
        int indice = 0;
        String[] departement = new String[taille];
        departement[0]="Tous";
        for(int i=1;i<taille;i++)
        {
            departement[i]=listedepartement[indice].getDesignation();
            indice++;
        }
        depart = new JComboBox(departement);
        poste.setBounds(0, 20 , 150, 30);
        depart.setBounds(170, 20, 150, 30);
        
        
        JTextField daty = new JTextField();
        JLabel semainelabel = new JLabel("Semaine du:");
        semainelabel.setBounds(0, 70, 150, 30);
        daty.setBounds(170, 70, 150, 30);
        
        JTextField matricule=new JTextField();
        JLabel matriculelabel = new JLabel("N°matricule:");
        
        JLabel type = new JLabel("Type du pointage:");
        
        TypePointage [] t = f.type();
        int size = t.length;
        System.out.println(size);
        String[] type_pointage = new String[size];
        //departement[0]="Tous";
        for(int j=0;j<size;j++)
        {
            type_pointage[j]=t[j].getDesignation();
        }
        JComboBox type_p;
        type_p = new JComboBox(type_pointage);
        
       
        
        JButton btnOkSelect = new JButton("Envoyer");
        btnOkSelect.setBounds(50, 120, 150, 30);
        type.setBounds(350, 120, 150, 30);
        type_p.setBounds(450, 120, 150, 30);
        JButton btnajouter = new JButton("Ajouter");
        matricule.setBounds(710, 20, 100, 30);
        matriculelabel.setBounds(600, 20, 100, 30);
        btnajouter.setBounds(820, 20, 120, 30);
        
        
        JButton btnOK = new JButton("Ok");
        btnOK.setBounds(400, 50, 100, 30);
        
        
        JButton btnmodele = new JButton("Enregistrer en tant que modèle");
        JButton btnimportmodele = new JButton("Importer le modèle");
        
        JButton btnpointer = new JButton("Pointer les employés");
        
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 160, 1000, 200);
        
        btnpointer.setBounds(0, 400, 180, 30);
        btnmodele.setBounds(380, 400, 230, 30);
        btnimportmodele.setBounds(790, 400, 180, 30);
        
        frame.setLayout(null);
        
        frame.add(poste);
        frame.add(depart);
        frame.add(daty);
        frame.add(matricule);
        frame.add(matriculelabel);
        frame.add(btnajouter);
        frame.add(btnOkSelect);
        frame.add(semainelabel);
        frame.add(pane);
        
        
        frame.add(btnimportmodele);
        frame.add(btnmodele);
        frame.add(btnpointer);
        
        frame.add(type);
        frame.add(type_p);
        
        Object[] row = new Object[4];
         
        btnOkSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try
                {
                    Fonction f = new Fonction();
                    String poste = (String)depart.getSelectedItem();
                    
                    int id=f.maka_id_depart(poste);
                    
                    Employe[] e=null;
                    model = new DefaultTableModel();
                     Object[] columns = {"Numero","N°Matricule","Nom","Prenoms","Lundi","Retard Lundi","Mardi","Retard Mardi","Mercredi","Retard Mercredi","Jeudi","Retard Jeudi","Vendredi","Retard Vendredi","Samedi","Retard Samedi","Dimanche","Retard Dimanche","Total"};
                    //DefaultTableModel model2 = new DefaultTableModel();
                    model.setColumnIdentifiers(columns);
                    if(poste.compareToIgnoreCase("tous")==0)
                    {
                        
                        e=f.e();
                        System.out.println(e.length);
                        for(int j=0;j<e.length;j++)
                        {
                            row[0] = e[j].getId_employe();
                            row[1] = e[j].getIdentifiant();
                            row[2] = e[j].getNom();
                            row[3] = e[j].getPrenoms();
                            model.addRow(row);
                            
                        }
                    }
                    
                    else
                    {
                        e=f.emp(id);
                        for(int j=0;j<e.length;j++)
                        {
                            row[0] = e[j].getId_employe();
                            row[1] = e[j].getIdentifiant();
                            row[2] = e[j].getNom();
                            row[3] = e[j].getPrenoms();
                            model.addRow(row);
                        }
                    }
                   
                    
                   
                    table.setModel(model);
                    
                    
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
        
        btnpointer.addActionListener(new ActionListener() {
            public void pointage() throws ParseException, Exception
            {
               
                   Pointage p =new Pointage();
                   int nombreLigne = table.getRowCount();
                   String da=daty.getText();
                   
                   Date d = p.setDaty(da);
                   
                   Calendar c= Calendar.getInstance();
                   c.setTime(d);
                   
                   System.out.println(d);
                   
                   System.out.println(d.getDate());
                   
                   
                   
                   c.add(Calendar.DAY_OF_WEEK,1);
                   Date datyMardi = c.getTime();
                   System.out.println(datyMardi);
                   c.add(Calendar.DAY_OF_WEEK,2);
                   Date datyMercredi = c.getTime();
                   c.add(Calendar.DAY_OF_WEEK,3);
                   Date datyJeudi = c.getTime();
                   c.add(Calendar.DAY_OF_WEEK,4);
                   Date datyVendredi = c.getTime();
                   c.add(Calendar.DAY_OF_WEEK,5);
                   Date datySamedi = c.getTime();
                   c.add(Calendar.DAY_OF_WEEK,5);
                   Date datyDimanche = c.getTime();
                   
                    int i=0;
                    for(i=0; i<nombreLigne; i++)
                    {
                        String type_pointage = (String)type_p.getSelectedItem();
                        int id_type_pointage = f.maka_id_type_pointage(type_pointage);
                        Integer id =(Integer) table.getValueAt(i, 0);

                        String lundi = (String)table.getValueAt(i, 4);
                        
                        System.out.println(lundi);
                        
                        String retardLundi = (String)table.getValueAt(i, 5);
                        String mardi = (String)table.getValueAt(i, 6);
                        String retardMardi = (String)table.getValueAt(i, 7);
                        String mercredi = (String)table.getValueAt(i, 8);
                        String retardMercredi = (String)table.getValueAt(i, 9);
                        String jeudi = (String)table.getValueAt(i, 10);
                        String retardJeudi = (String)table.getValueAt(i, 11);
                        String vendredi = (String)table.getValueAt(i, 12);
                        String retardVendredi = (String)table.getValueAt(i, 13);
                        String samedi = (String)table.getValueAt(i, 14);
                        String retardSamedi = (String)table.getValueAt(i, 15);
                        String dimanche = (String)table.getValueAt(i, 16);
                        String retardDimanche = (String)table.getValueAt(i, 17);

                        String total = (String)table.getValueAt(i, 18);

                        System.out.println("lundi = "+lundi+" et retard lundi = "+retardLundi);
                        System.out.println("dimanche = "+dimanche+" et retard dimanche = "+retardDimanche);
                        int totaly = 0;
                        if(lundi!=null && lundi.length()>0)
                        {
                            
                            Time time_lundi =p.setHeure(lundi) ;
                            
                            Pointage point=new Pointage();
                            point.setId_personne(id);
                            point.setHeure(time_lundi);
                            point.setDaty(d);
                            point.setType_pointage(id_type_pointage);
                            point.setJour("Lundi");
                            
                            f.pointer_employer(point);
                                
                            if(retardLundi==null)
                            {
                                Emploi[]e=f.horaire(id);
                                for(int k=0;k<e.length;k++)
                                {
                                    Time te=e[k].getEntree();
                                    if(time_lundi.getHours()>te.getHours())
                                    {
                                        int resh = time_lundi.getHours() - te.getHours();
                                        model.setValueAt(resh, i, 5);
                                        totaly+=resh;
                                    }
                                    else
                                    {
                                        int resh = 0;
                                        model.setValueAt(resh, i, 5);
                                        totaly+=resh;
                                    }

                                }
                            }
                            else
                            {
                                int retard_lundi=Integer.parseInt(retardLundi);
                                Time time_retard_lundi =new Time(retard_lundi, 0, 0) ;
                                Emploi[]e=f.horaire(id);
                                for(int k=0;k<e.length;k++)
                                {
                                    Time te = e[k].getEntree();
                                    Time entree = f.additionTime(te, time_retard_lundi);
                                    String entreepointage=entree.toString();
                                    model.setValueAt(entreepointage, i, 4);
                                    totaly+=retard_lundi;
                                }
                            }
                        }
                        else if(lundi==null)
                        {
                            if(retardLundi!=null)
                            {
                                int retard_lundi=Integer.parseInt(retardLundi);
                                Time time_retard_lundi =new Time(retard_lundi, 0, 0) ;
                                System.out.println(time_retard_lundi);
                                Emploi[]e=f.horaire(id);
                                for(int k=0;k<e.length;k++)
                                {
                                    Time te = e[k].getEntree();
                                    Time entree = f.additionTime(te, time_retard_lundi);
                                    String entreepointage=entree.toString();
                                    model.setValueAt(entreepointage, i, 4);
                                    totaly+=retard_lundi;
                                    
                                    Pointage point=new Pointage();
                                    point.setId_personne(id);
                                    point.setHeure(entree);
                                    point.setDaty(d);
                                    point.setType_pointage(id_type_pointage);
                                    point.setJour("Lundi");
                                    
                                    f.pointer_employer(point);
                                }
                                
                            }
                        }
                        if(mardi!=null && mardi.length()>0)
                        {
                            Time time_mardi =p.setHeure(mardi) ;
                            Pointage point=new Pointage();
                            point.setId_personne(id);
                            point.setHeure(time_mardi);
                            point.setDaty(datyMardi);
                            point.setType_pointage(id_type_pointage);
                            point.setJour("Mardi");
                            
                            f.pointer_employer(point);
                            if(retardMardi==null)
                            {
                                Emploi[]e=f.horaire(id);
                                for(int k=0;k<e.length;k++)
                                {
                                    Time te=e[k].getEntree();
                                    if(time_mardi.getHours()>te.getHours())
                                    {
                                        int resh = time_mardi.getHours() - te.getHours();
                                        model.setValueAt(resh, i, 7);
                                        totaly+=resh;
                                    }
                                    else
                                    {
                                        int resh = 0;
                                        model.setValueAt(resh, i, 7);
                                        totaly+=resh;
                                    }

                                }
                            }
                            else
                            {
                                int retard_mardi=Integer.parseInt(retardMardi);
                                Time time_retard_mardi =new Time(retard_mardi, 0, 0) ;
                                Emploi[]e=f.horaire(id);
                                for(int k=0;k<e.length;k++)
                                {
                                    Time te = e[k].getEntree();
                                    Time entree = f.additionTime(te, time_retard_mardi);
                                    String entreepointage=entree.toString();
                                    model.setValueAt(entreepointage, i, 6);
                                    totaly+=retard_mardi;
                                }
                            }
                            
                            
                        }
                        else if(mardi==null)
                        {
                            if(retardMardi!=null)
                            {
                                int retard_mardi=Integer.parseInt(retardMardi);
                                Time time_retard_mardi =new Time(retard_mardi, 0, 0) ;
                                Emploi[]e=f.horaire(id);
                                for(int k=0;k<e.length;k++)
                                {
                                    Time te = e[k].getEntree();
                                    Time entree = f.additionTime(te, time_retard_mardi);
                                    String entreepointage=entree.toString();
                                    model.setValueAt(entreepointage, i, 6);
                                    totaly+=retard_mardi;
                                    
                                    Pointage point=new Pointage();
                                    point.setId_personne(id);
                                    point.setHeure(entree);
                                    point.setDaty(d);
                                    point.setType_pointage(id_type_pointage);
                                    point.setJour("Mardi");
                                    
                                    f.pointer_employer(point);
                                }
                                
                            }
                        }
                        if(mercredi!=null && mercredi.length()>0)
                        {
                            Time time_mercredi =p.setHeure(mercredi) ;
                            Pointage point=new Pointage();
                            point.setId_personne(id);
                            point.setHeure(time_mercredi);
                            point.setDaty(datyMercredi);
                            point.setType_pointage(id_type_pointage);
                            point.setJour("Mercredi");
                            
                            f.pointer_employer(point);
                            if(retardMercredi==null)
                            {
                                Emploi[]e=f.horaire(id);
                                for(int k=0;k<e.length;k++)
                                {
                                    Time te=e[k].getEntree();
                                    if(time_mercredi.getHours()>te.getHours())
                                    {
                                        int resh = time_mercredi.getHours() - te.getHours();
                                        model.setValueAt(resh, i, 9);
                                        totaly+=resh;
                                    }
                                    else
                                    {
                                        int resh = 0;
                                        model.setValueAt(resh, i, 9);
                                        totaly+=resh;
                                    }

                                }
                            }
                            else
                            {
                                int retard_mercredi=Integer.parseInt(retardMercredi);
                                Time time_retard_mercredi =new Time(retard_mercredi, 0, 0) ;
                                Emploi[]e=f.horaire(id);
                                for(int k=0;k<e.length;k++)
                                {
                                    Time te = e[k].getEntree();
                                    Time entree = f.additionTime(te, time_retard_mercredi);
                                    String entreepointage=entree.toString();
                                    model.setValueAt(entreepointage, i, 8);
                                    totaly+=retard_mercredi;
                                }
                            }
                        }
                        else if(mercredi==null)
                        {
                            if(retardMercredi!=null)
                            {
                                int retard_mercredi=Integer.parseInt(retardMercredi);
                                Time time_retard_mercredi =new Time(retard_mercredi, 0, 0) ;
                                Emploi[]e=f.horaire(id);
                                for(int k=0;k<e.length;k++)
                                {
                                    Time te = e[k].getEntree();
                                    Time entree = f.additionTime(te, time_retard_mercredi);
                                    String entreepointage=entree.toString();
                                    model.setValueAt(entreepointage, i, 8);
                                    totaly+=retard_mercredi;
                                    
                                    Pointage point=new Pointage();
                                    point.setId_personne(id);
                                    point.setHeure(entree);
                                    point.setDaty(d);
                                    point.setType_pointage(id_type_pointage);
                                    point.setJour("Mercredi");
                                    
                                    f.pointer_employer(point);
                                }
                                
                            }
                        }
                        if(jeudi!=null && jeudi.length()>0)
                        {
                            Time time_jeudi =p.setHeure(jeudi) ;
                            Pointage point=new Pointage();
                            point.setId_personne(id);
                            point.setHeure(time_jeudi);
                            point.setDaty(datyJeudi);
                            point.setType_pointage(id_type_pointage);
                            point.setJour("Jeudi");
                            
                            f.pointer_employer(point);
                            if(retardJeudi==null)
                            {
                                Emploi[]e=f.horaire(id);
                                for(int k=0;k<e.length;k++)
                                {
                                    Time te=e[k].getEntree();
                                    if(time_jeudi.getHours()>te.getHours())
                                    {
                                        int resh = time_jeudi.getHours() - te.getHours();
                                        model.setValueAt(resh, i, 11);
                                        totaly+=resh;
                                    }
                                    else
                                    {
                                        int resh = 0;
                                        model.setValueAt(resh, i, 11);
                                        totaly+=resh;
                                    }

                                }
                            }
                            else
                            {
                                int retard_jeudi=Integer.parseInt(retardJeudi);
                                Time time_retard_jeudi =new Time(retard_jeudi, 0, 0) ;
                                Emploi[]e=f.horaire(id);
                                for(int k=0;k<e.length;k++)
                                {
                                    Time te = e[k].getEntree();
                                    Time entree = f.additionTime(te, time_retard_jeudi);
                                    String entreepointage=entree.toString();
                                    model.setValueAt(entreepointage, i, 10);
                                    totaly+=retard_jeudi;
                                }
                            }
                        }
                        else if(jeudi==null)
                        {
                            if(retardJeudi!=null)
                            {
                                int retard_jeudi=Integer.parseInt(retardJeudi);
                                Time time_retard_jeudi =new Time(retard_jeudi, 0, 0) ;
                                Emploi[]e=f.horaire(id);
                                for(int k=0;k<e.length;k++)
                                {
                                    Time te = e[k].getEntree();
                                    Time entree = f.additionTime(te, time_retard_jeudi);
                                    String entreepointage=entree.toString();
                                    model.setValueAt(entreepointage, i, 10);
                                    totaly+=retard_jeudi;
                                    
                                    Pointage point=new Pointage();
                                    point.setId_personne(id);
                                    point.setHeure(entree);
                                    point.setDaty(d);
                                    point.setType_pointage(id_type_pointage);
                                    point.setJour("Jeudi");
                                    
                                    f.pointer_employer(point);
                                }
                                
                            }
                        }
                        if(vendredi!=null && vendredi.length()>0)
                        {
                            Time time_vendredi =p.setHeure(vendredi) ;
                            Pointage point=new Pointage();
                            point.setId_personne(id);
                            point.setHeure(time_vendredi);
                            point.setDaty(datyVendredi);
                            point.setType_pointage(id_type_pointage);
                            point.setJour("Vendredi");
                            
                            f.pointer_employer(point);
                            
                            Emploi[]e=f.horaire(id);
                            if(retardVendredi==null)
                            {
                                for(int k=0;k<e.length;k++)
                                {
                                    Time te=e[k].getEntree();
                                    if(time_vendredi.getHours()>te.getHours())
                                    {
                                        int resh = time_vendredi.getHours() - te.getHours();
                                        model.setValueAt(resh, i, 13);
                                        totaly+=resh;
                                    }
                                    else
                                    {
                                        int resh = 0;
                                        model.setValueAt(resh, i, 13);
                                        totaly+=resh;
                                    }

                                }
                            }
                            else
                            {
                                int retard_vendredi=Integer.parseInt(retardVendredi);
                                Time time_retard_vendredi =new Time(retard_vendredi, 0, 0) ;
                                Emploi[]em=f.horaire(id);
                                for(int k=0;k<em.length;k++)
                                {
                                    Time te = em[k].getEntree();
                                    Time entree = f.additionTime(te, time_retard_vendredi);
                                    String entreepointage=entree.toString();
                                    model.setValueAt(entreepointage, i, 12);
                                    totaly+=retard_vendredi;
                                }
                            }
                            
                        }
                        else if(vendredi==null)
                        {
                            if(retardVendredi!=null)
                            {
                                int retard_vendredi=Integer.parseInt(retardVendredi);
                                Time time_retard_vendredi =new Time(retard_vendredi, 0, 0) ;
                                Emploi[]e=f.horaire(id);
                                for(int k=0;k<e.length;k++)
                                {
                                    Time te = e[k].getEntree();
                                    Time entree = f.additionTime(te, time_retard_vendredi);
                                    String entreepointage=entree.toString();
                                    model.setValueAt(entreepointage, i, 12);
                                    totaly+=retard_vendredi;
                                    
                                    Pointage point=new Pointage();
                                    point.setId_personne(id);
                                    point.setHeure(entree);
                                    point.setDaty(d);
                                    point.setType_pointage(id_type_pointage);
                                    point.setJour("Vendredi");
                                    
                                    f.pointer_employer(point);
                                }
                                
                            }
                        }
                        if(samedi!=null && samedi.length()>0)
                        {
                            Time time_samedi =p.setHeure(samedi) ;
                            Pointage point=new Pointage();
                            point.setId_personne(id);
                            point.setHeure(time_samedi);
                            point.setDaty(datySamedi);
                            point.setType_pointage(id_type_pointage);
                            point.setJour("Samedi");
                            
                            f.pointer_employer(point);
                            
                            Emploi[]e=f.horaire(id);
                            if(retardSamedi==null)
                            {
                               for(int k=0;k<e.length;k++)
                                {
                                    Time te=e[k].getEntree();
                                    if(time_samedi.getHours()>te.getHours())
                                    {
                                        int resh = time_samedi.getHours() - te.getHours();
                                        model.setValueAt(resh, i, 15);
                                        totaly+=resh;
                                    }
                                    else
                                    {
                                        int resh = 0;
                                        model.setValueAt(resh, i, 15);
                                        totaly+=resh;
                                    }

                                } 
                            }
                            else
                            {
                                int retard_samedi=Integer.parseInt(retardSamedi);
                                Time time_retard_samedi =new Time(retard_samedi, 0, 0) ;
                                Emploi[]em=f.horaire(id);
                                for(int k=0;k<em.length;k++)
                                {
                                    Time te = em[k].getEntree();
                                    Time entree = f.additionTime(te, time_retard_samedi);
                                    String entreepointage=entree.toString();
                                    model.setValueAt(entreepointage, i, 14);
                                    totaly+=retard_samedi;
                                }
                            }
                            
                        }
                        else if(samedi==null)
                        {
                            if(retardSamedi!=null)
                            {
                                int retard_samedi=Integer.parseInt(retardSamedi);
                                Time time_retard_samedi =new Time(retard_samedi, 0, 0) ;
                                Emploi[]e=f.horaire(id);
                                for(int k=0;k<e.length;k++)
                                {
                                    Time te = e[k].getEntree();
                                    Time entree = f.additionTime(te, time_retard_samedi);
                                    String entreepointage=entree.toString();
                                    model.setValueAt(entreepointage, i, 14);
                                    totaly+=retard_samedi;
                                    
                                    Pointage point=new Pointage();
                                    point.setId_personne(id);
                                    point.setHeure(entree);
                                    point.setDaty(d);
                                    point.setType_pointage(id_type_pointage);
                                    point.setJour("Samedi");
                                    
                                    f.pointer_employer(point);
                                }
                                
                            }
                        }
                        if(dimanche!=null && dimanche.length()>0)
                        {
                            Time time_dimanche =p.setHeure(dimanche) ;
                            Pointage point=new Pointage();
                            point.setId_personne(id);
                            point.setHeure(time_dimanche);
                            point.setDaty(datyDimanche);
                            point.setType_pointage(id_type_pointage);
                            point.setJour("Dimanche");
                            
                            f.pointer_employer(point);
                            
                            Emploi[]e=f.horaire(id);
                            if(dimanche==null)
                            {
                                for(int k=0;k<e.length;k++)
                                {
                                    Time te=e[k].getEntree();
                                    if(time_dimanche.getHours()>te.getHours())
                                    {
                                        int resh = time_dimanche.getHours() - te.getHours();
                                        model.setValueAt(resh, i, 17);
                                        totaly+=resh;
                                    }
                                    else
                                    {
                                        int resh = 0;
                                        model.setValueAt(resh, i, 17);
                                        totaly+=resh;
                                    }

                                }
                            }
                            else
                            {
                                int retard_dimanche=Integer.parseInt(retardDimanche);
                                Time time_retard_dimanche =new Time(retard_dimanche, 0, 0) ;
                                Emploi[]em=f.horaire(id);
                                for(int k=0;k<em.length;k++)
                                {
                                    Time te = em[k].getEntree();
                                    Time entree = f.additionTime(te, time_retard_dimanche);
                                    String entreepointage=entree.toString();
                                    model.setValueAt(entreepointage, i, 14);
                                    totaly+=retard_dimanche;
                                }
                            }
                            
                        }
                        else if(dimanche==null)
                        {
                            if(retardDimanche!=null)
                            {
                                int retard_dimanche=Integer.parseInt(retardDimanche);
                                Time time_retard_dimanche =new Time(retard_dimanche, 0, 0) ;
                                Emploi[]e=f.horaire(id);
                                for(int k=0;k<e.length;k++)
                                {
                                    Time te = e[k].getEntree();
                                    Time entree = f.additionTime(te, time_retard_dimanche);
                                    String entreepointage=entree.toString();
                                    model.setValueAt(entreepointage, i, 10);
                                    totaly+=retard_dimanche;
                                    
                                    Pointage point=new Pointage();
                                    point.setId_personne(id);
                                    point.setHeure(entree);
                                    point.setDaty(d);
                                    point.setType_pointage(id_type_pointage);
                                    point.setJour("Dimanche");
                                    
                                    f.pointer_employer(point);
                                }
                                
                            }
                        }
                        model.setValueAt(totaly, i, 18);
					
				
                    }
                    
                   
                
            }
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                try
                {
                    pointage();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                
                
            }
        });
        
        matricule.addKeyListener(new KeyListener() {
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
                    
                    String nomMatr = matricule.getText();
                    
                    
                    Employe[] emp=null;
                    model = new DefaultTableModel();
                     Object[] columns = {"Numero","N°Matricule","Nom","Prenoms","Lundi","Retard Lundi","Mardi","Retard Mardi","Mercredi","Retard Mercredi","Jeudi","Retard Jeudi","Vendredi","Retard Vendredi","Samedi","Retard Samedi","Dimanche","Retard Dimanche","Total"};
                    //DefaultTableModel model2 = new DefaultTableModel();
                    model.setColumnIdentifiers(columns);
                        
                        emp=f.emp(nomMatr);
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
                            Object[] colu = {"Numero","N°Matricule","Nom","Prenoms","Lundi","Retard Lundi","Mardi","Retard Mardi","Mercredi","Retard Mercredi","Jeudi","Retard Jeudi","Vendredi","Retard Vendredi","Samedi","Retard Samedi","Dimanche","Retard Dimanche","Total"};
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
        
        btnajouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    new FenetreAjoutEmploye();
                    frame.dispose();
                } 
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnmodele.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                
            }
        });
        /*btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int i = table.getSelectedRow();
                if(i >= 0)
                {
                    model.removeRow(i);
                }
                else
                {
                    System.out.println("Delete Error");
                }
            }
        });
        
        table.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e)
            {
                int i = table.getSelectedRow();
                textId.setText(model.getValueAt(i, 0).toString());
                textFname.setText(model.getValueAt(i, 1).toString());
                textLname.setText(model.getValueAt(i, 2).toString());
                textAge.setText(model.getValueAt(i, 3).toString());
            }

            });
        
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int i = table.getSelectedRow();
                if(i >= 0)
                {
                    model.setValueAt(textId.getText(), i, 0);
                    model.setValueAt(textFname.getText(), i, 1);
                    model.setValueAt(textLname.getText(), i, 2);
                    model.setValueAt(textAge.getText(), i, 3);
                }
                else
                {
                    System.out.println("Update Error");
                }
            }
        });*/
        
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
    
}
