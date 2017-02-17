package javaapp;

import javax.swing.*;

public class FenetreAjoutEmploye extends JFrame
{
    private JLabel enregistrer = new JLabel("**************Enregistrer un employé**************");
    
    private JLabel id_label = new JLabel("Id:");
    private JTextField id_texte = new JTextField();
    
    private JLabel matricule_label = new JLabel("N° matricule:");
    private JTextField matricule_texte = new JTextField();
    
    private JLabel nom_label = new JLabel("Nom:");
    private JTextField nom_texte = new JTextField();
    
    private JLabel prenom_label = new JLabel("Prenoms:");
    private JTextField prenom_texte = new JTextField();
    
    private JLabel emploi_du_tems = new JLabel("**************Emploi du temps**************");
    
    private JLabel entree_label = new JLabel("Heure d'entrée:");
    private JTextField entree_texte = new JTextField();
    
    private JLabel sortie_label = new JLabel("Heure de sortie:");
    private JTextField sortie_texte = new JTextField();
    
    private JButton envoyer = new JButton("Envoyer");
    private JButton annuler = new JButton("Annuler");
    
    private JLabel departement_label = new JLabel("Departement:");
    
    private JComboBox departement_box;

    
    
    

    public FenetreAjoutEmploye() throws Exception 
    {
        
        
        enregistrer.setBounds(270, 10, 350, 30);
        
        id_label.setBounds(50, 50, 150, 30);
        id_texte.setBounds(210, 50, 150, 30);
        
        matricule_label.setBounds(50, 90, 150, 30);
        matricule_texte.setBounds(210, 90, 150, 30);
        
        nom_label.setBounds(50, 130, 150, 30);
        nom_texte.setBounds(210, 130, 150, 30);
        
        prenom_label.setBounds(50, 170, 150, 30);
        prenom_texte.setBounds(210, 170, 150, 30);
        
        
        
        Fonction f=new Fonction();
        int id_emp=f.maka_max_id_employe();
        String id_emp_string=String.valueOf(id_emp);
        System.out.println(id_emp_string);
        id_texte.setText(id_emp_string);
        Departement [] listedepartement = f.poste();
        int taille = listedepartement.length;
        String[] departement = new String[taille];
        
        for(int i=0;i<taille;i++)
        {
            departement[i]=listedepartement[i].getDesignation();
        }
        departement_box = new JComboBox(departement);
        departement_label.setBounds(50, 210, 150, 30);
        departement_box.setBounds(210, 210, 150, 30);
        
        emploi_du_tems.setBounds(270, 260, 350, 30);
        
        entree_label.setBounds(50, 300, 150, 30);
        entree_texte.setBounds(210, 300, 150, 30);
        
        sortie_label.setBounds(50, 340, 150, 30);
        sortie_texte.setBounds(210, 340, 150, 30);
        
        
        annuler.setBounds(0, 400, 150, 30);
        envoyer.setBounds(650, 400, 150, 30);
        
        envoyer.addMouseListener(new EcouteurEnregistrer(this));
        annuler.addActionListener(new EcouteurAnnuler());
        
        add(departement_label);
        add(departement_box);
        add(annuler);
        add(envoyer);
        add(sortie_texte);
        add(sortie_label);
        add(entree_texte);
        add(entree_label);
        add(emploi_du_tems);
        add(prenom_texte);
        add(prenom_label);
        add(nom_texte);
        add(nom_label);
        add(matricule_texte);
        add(matricule_label);
        add(id_texte);
        add(id_label);
        add(enregistrer);
       
        this.pack();
        this.setSize(800, 480);
        this.setTitle("Ajouter un employé");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
    }
    public JTextField getId_texte() {
        return id_texte;
    }

    public void setId_texte(JTextField id_texte) {
        this.id_texte = id_texte;
    }

    public JTextField getMatricule_texte() {
        return matricule_texte;
    }

    public void setMatricule_texte(JTextField matricule_texte) {
        this.matricule_texte = matricule_texte;
    }

    public JTextField getNom_texte() {
        return nom_texte;
    }

    public void setNom_texte(JTextField nom_texte) {
        this.nom_texte = nom_texte;
    }

    public JTextField getPrenom_texte() {
        return prenom_texte;
    }

    public void setPrenom_texte(JTextField prenom_texte) {
        this.prenom_texte = prenom_texte;
    }

    public JTextField getEntree_texte() {
        return entree_texte;
    }

    public void setEntree_texte(JTextField entree_texte) {
        this.entree_texte = entree_texte;
    }

    public JTextField getSortie_texte() {
        return sortie_texte;
    }

    public void setSortie_texte(JTextField sortie_texte) {
        this.sortie_texte = sortie_texte;
    }

    public JButton getEnvoyer() {
        return envoyer;
    }

    public void setEnvoyer(JButton envoyer) {
        this.envoyer = envoyer;
    }

    public JButton getAnnuler() {
        return annuler;
    }

    public void setAnnuler(JButton annuler) {
        this.annuler = annuler;
    }

    public JComboBox getDepartement_box() {
        return departement_box;
    }

    public void setDepartement_box(JComboBox departement_box) {
        this.departement_box = departement_box;
    }
    
}
