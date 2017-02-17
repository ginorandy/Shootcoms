/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

public class Fonction {
    
    public void Fonction()
    {
        
    }
    public Connection getConnectionPostgres() throws ClassNotFoundException, SQLException
    {
		Class.forName("org.postgresql.Driver");
		Connection connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pointage","postgres","itu");
		return connect;
    }
    public int getTableSize(String table) throws ClassNotFoundException, SQLException, Exception
    {
        PreparedStatement preparar=null;
        Connection conn = this.getConnectionPostgres();
        Statement stmt=null;
        //this.conexion=connection.getConnexion();
        int status=0;
        Integer i;
        try
        {   stmt=conn.createStatement();
            String requete="SELECT Count(*) FROM "+table+"";
            preparar=conn.prepareStatement(requete);
            ResultSet rs=preparar.executeQuery();  
            while(rs.next())
            {
                i=Integer.parseInt(rs.getString(1));
                status=i;
            }
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
    public Departement[] poste() throws Exception
    {
        PreparedStatement preparar=null;
        Connection conn = this.getConnectionPostgres();
        
        Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        
        String requete="select * from departement";
        ResultSet rs=stmt.executeQuery(requete);
        rs.last();
        int taille=rs.getRow();
        Departement[] a=new Departement[taille];
        for(int j=0;j<taille;j++)
        {
            a[j]=new Departement();
        }
        rs.beforeFirst();
        int i=0;
        while(rs.next())
        {

            a[i].setId_departement(rs.getInt("id_departement"));
            a[i].setDesignation(rs.getString("designation"));
            i++;
        }
        
        return a;
    }
    public int maka_id_depart(String nom) throws Exception
    {
        PreparedStatement preparar=null;
        Connection conn = this.getConnectionPostgres();
        Statement stmt=null;
        int status=0;
        try
        {
            stmt=conn.createStatement();
            String requete="select id_departement as id from departement where designation ='"+nom+"'";
            preparar = conn.prepareStatement(requete);
            ResultSet rs=preparar.executeQuery();
            while(rs.next())
            {
                status = rs.getInt("id");
            }
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
    
    public int maka_id_type_pointage(String nom) throws Exception
    {
        PreparedStatement preparar=null;
        Connection conn = this.getConnectionPostgres();
        Statement stmt=null;
        int status=0;
        try
        {
            stmt=conn.createStatement();
            String requete="select id_type as id from typepointage where designation ='"+nom+"'";
            preparar = conn.prepareStatement(requete);
            ResultSet rs=preparar.executeQuery();
            while(rs.next())
            {
                status = rs.getInt("id");
            }
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
    
    public Employe[] emp(int departement) throws Exception
    {
        PreparedStatement preparar=null;
        Connection conn = this.getConnectionPostgres();
        
        Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        
        String requete="select * from employe where departement = "+departement+"";
        ResultSet rs=stmt.executeQuery(requete);
        
        ArrayList<Employe> arrEmp = new ArrayList<>();
        
        while(rs.next())
        {
            Employe ee = new Employe(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),rs.getDate(6));
            arrEmp.add(ee);
        }
        
        Employe[] val = new Employe[arrEmp.size()];
        int i=0;
        for(i=0; i<arrEmp.size(); i++)
        {
            val[i]=arrEmp.get(i);
        }
       
        return val;
    }
    public Employe[] emp(String nom) throws Exception
    {
        PreparedStatement preparar=null;
        Connection conn = this.getConnectionPostgres();
        
        Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        
        String requete="select * from employe where nom ILIKE '%"+nom+"%'";
        ResultSet rs=stmt.executeQuery(requete);
        
        ArrayList<Employe> arrEmp = new ArrayList<>();
        
        while(rs.next())
        {
            Employe ee = new Employe(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),rs.getDate(6));
            arrEmp.add(ee);
        }
        
        Employe[] val = new Employe[arrEmp.size()];
        int i=0;
        for(i=0; i<arrEmp.size(); i++)
        {
            val[i]=arrEmp.get(i);
        }
       
        return val;
    }
    public Employe[] e() throws Exception
    {
        PreparedStatement preparar=null;
        Connection conn = this.getConnectionPostgres();
        
        Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        
        String requete="select * from employe";
        ResultSet rs=stmt.executeQuery(requete);
        rs.last();
        int taille=rs.getRow();
        Employe[] a=new Employe[taille];
        for(int j=0;j<taille;j++)
        {
            a[j]=new Employe();
        }
        rs.beforeFirst();
        int i=0;
        while(rs.next())
        {

            a[i].setId_employe(rs.getInt("id_emp"));
            a[i].setIdentifiant(rs.getString("identifiant"));
            a[i].setNom(rs.getString("nom"));
            a[i].setDepartement(rs.getInt("departement"));
            a[i].setPrenoms(rs.getString("prenoms"));
            i++;
        }
        
        return a;
    }
    public Conge[] c() throws Exception
    {
        PreparedStatement preparar=null;
        Connection conn = this.getConnectionPostgres();
        
        Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        
        String requete="select * from conge";
        ResultSet rs=stmt.executeQuery(requete);
        rs.last();
        int taille=rs.getRow();
        Conge[] a=new Conge[taille];
        for(int j=0;j<taille;j++)
        {
            a[j]=new Conge();
        }
        rs.beforeFirst();
        int i=0;
        while(rs.next())
        {
            a[i].setId_conge(rs.getInt("id_conge"));
            a[i].setId_employe(rs.getInt("id_employe"));
            a[i].setDaty_now(rs.getDate("daty_now"));
            a[i].setDaty_debut(rs.getDate("daty_debut"));
            a[i].setHeure_debut(rs.getTime("heure_debut"));
            a[i].setDaty_fin(rs.getDate("daty_fin"));
            a[i].setHeure_fin(rs.getTime("heure_fin"));
            a[i].setMotif(rs.getString("motif"));
            a[i].setNombre_jours(rs.getInt("nombre_jour_conge"));
            i++;
        }
        
        return a;
    }
    public Departement[] departement() throws Exception
    {
        PreparedStatement preparar=null;
        Connection conn = this.getConnectionPostgres();
        
        Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        
        String requete="select * from departement";
        ResultSet rs=stmt.executeQuery(requete);
        rs.last();
        int taille=rs.getRow();
        Departement[] a=new Departement[taille];
        for(int j=0;j<taille;j++)
        {
            a[j]=new Departement();
        }
        rs.beforeFirst();
        int i=0;
        while(rs.next())
        {

            a[i].setId_departement(rs.getInt("id_departement"));
            a[i].setDesignation(rs.getString("designation"));
            i++;
        }
        
        return a;
    }
    public TypePointage[] type() throws Exception
    {
        PreparedStatement preparar=null;
        Connection conn = this.getConnectionPostgres();
        
        Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        
        String requete="select * from typepointage";
        ResultSet rs=stmt.executeQuery(requete);
        rs.last();
        int taille=rs.getRow();
        TypePointage[] a=new TypePointage[taille];
        for(int j=0;j<taille;j++)
        {
            a[j]=new TypePointage();
        }
        rs.beforeFirst();
        int i=0;
        while(rs.next())
        {

            a[i].setId_type(rs.getInt("id_type"));
            a[i].setDesignation(rs.getString("designation"));
            i++;
        }
        
        return a;
    }
    public String formatDate(String daty)
    {
        daty = daty.replace(".", "-");
        daty = daty.replace("/", "-");
        daty = daty.replace("_", "-");
        daty = daty.replace(" ", "-");
        daty = daty.replace(";", "-");
        daty = daty.replace("?", "-");
        if(!daty.startsWith("20"))
        {
            daty = "20"+daty;
        }
        return daty;
    }
    public String formatHeure(String heure)
    {
        heure = heure.replace(" ", ":");
        heure = heure.replace("h", ":");
        heure = heure.replace(".", ":");
        heure = heure.replace("-", ":");
        heure = heure.replace("/", ":");
        heure = heure.replace("_", ":");
        heure = heure.replace("m", ":");
        return heure;
    }
    public void pointer_employer(Pointage p) throws ClassNotFoundException, SQLException
    {
        PreparedStatement preparar=null;
        Connection conn = this.getConnectionPostgres();
        try
        {
            String requete="insert into \"pointage\" values(nextval('pointage_id_pointage_seq'),"+p.getId_personne()+",'"+p.getHeure()+"','"+p.getDaty()+"',"+p.getType_pointage()+",'"+p.getJour()+"');";
            preparar=conn.prepareStatement(requete);
            preparar.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public Emploi[] horaire(int id_emp) throws Exception
    {
        PreparedStatement preparar=null;
        Connection conn = this.getConnectionPostgres();
        Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        
        String requete="select * from emploidutemps where employe="+id_emp;
        ResultSet rs=stmt.executeQuery(requete);
        rs.last();
        int taille=rs.getRow();
        Emploi[] a=new Emploi[taille];
        for(int j=0;j<taille;j++)
        {
            a[j]=new Emploi();
        }
        rs.beforeFirst();
        int i=0;
        while(rs.next())
        {

            a[i].setEntree(rs.getTime("entree"));
            a[i].setSortie(rs.getTime("sortie"));
            i++;
        }
        
        return a;
    }
    public Time additionTime(Time heure1,Time heure2)
    {
        int heure=(heure1.getHours()*3600)+(heure2.getHours()*3600);
        int minute=(heure1.getMinutes()*60)+(heure2.getMinutes()*60);
        
        return new Time(0, 0, heure+minute);
    }
    public int maka_max_id_employe() throws Exception
    {
        PreparedStatement preparar=null;
        Connection conn = this.getConnectionPostgres();
        Statement stmt=null;
        int status=0;
        int valiny=0;
        try
        {
            stmt=conn.createStatement();
            String requete="select max(id_emp) as id from employe";
            preparar = conn.prepareStatement(requete);
            ResultSet rs=preparar.executeQuery();
            while(rs.next())
            {
                status = rs.getInt("id");
            }
            valiny=status+1;
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return valiny;
    }
    public int maka_id_employe(String matricule) throws Exception
    {
        PreparedStatement preparar=null;
        Connection conn = this.getConnectionPostgres();
        Statement stmt=null;
        int status=0;
        try
        {
            stmt=conn.createStatement();
            String requete="select id_emp as id from employe where identifiant='"+matricule+"'";
            preparar = conn.prepareStatement(requete);
            ResultSet rs=preparar.executeQuery();
            while(rs.next())
            {
                status = rs.getInt("id");
            }
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
    public int maka_id_nombre_jour_conge(int id_employe) throws Exception
    {
        PreparedStatement preparar=null;
        Connection conn = this.getConnectionPostgres();
        Statement stmt=null;
        int status=0;
        try
        {
            stmt=conn.createStatement();
            String requete="select total_conge as total from reliquat_employe where id_employe="+id_employe+"";
            preparar = conn.prepareStatement(requete);
            ResultSet rs=preparar.executeQuery();
            while(rs.next())
            {
                status = rs.getInt("total");
            }
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
    public void insert_employe(Employe emp) throws ClassNotFoundException, SQLException
    {
        PreparedStatement preparar=null;
        Connection conn = this.getConnectionPostgres();
        try
        {
            String requete="insert into \"employe\" values(nextval('employe_id_emp_seq'),'"+emp.getIdentifiant()+"','"+emp.getNom()+"',"+emp.getDepartement()+",'"+emp.getPrenoms()+"');";
            preparar=conn.prepareStatement(requete);
            preparar.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void insert_emploi_du_temps(Emploi temps) throws ClassNotFoundException, SQLException
    {
        PreparedStatement preparar=null;
        Connection conn = this.getConnectionPostgres();
        try
        {
            String requete="insert into \"emploidutemps\" values(nextval('emploidutemps_id_emploi_seq'),"+temps.getId_personne()+",'"+temps.getEntree()+"','"+temps.getSortie()+"');";
            preparar=conn.prepareStatement(requete);
            preparar.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void import_modele()
    {
        
    }
    public void export_modele()
    {
        
    }
    public void insert_conge(Conge c) throws ClassNotFoundException, SQLException
    {
        PreparedStatement preparar=null;
        Connection conn = this.getConnectionPostgres();
        try
        {
            String requete="insert into \"conge\" values(nextval('conge_id_conge_seq'),"+c.getId_employe()+",'"+c.getDaty_now()+"','"+c.getDaty_debut()+"','"+c.getHeure_debut()+"','"+c.getDaty_fin()+"','"+c.getHeure_fin()+"','"+c.getMotif()+"',"+c.getNombre_jours()+");";
            preparar=conn.prepareStatement(requete);
            preparar.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void insert_conge_valider(Conger_valider c) throws ClassNotFoundException, SQLException
    {
        PreparedStatement preparar=null;
        Connection conn = this.getConnectionPostgres();
        try
        {
            String requete="insert into \"conger_valider\" values(nextval('conger_valider_id_conger_valider_seq'),"+c.getId_conge()+");";
            preparar=conn.prepareStatement(requete);
            preparar.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void insert_conge_refuser(Conger_refuser c) throws ClassNotFoundException, SQLException
    {
        PreparedStatement preparar=null;
        Connection conn = this.getConnectionPostgres();
        try
        {
            String requete="insert into \"conger_refuser\" values(nextval('conger_refuser_id_conger_refuser_seq'),"+c.getId_conge()+");";
            preparar=conn.prepareStatement(requete);
            preparar.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void supprimer_conge(int id) throws SQLException, ClassNotFoundException
    {
        PreparedStatement preparar=null;
        Connection conn = this.getConnectionPostgres();
        String requete="delete from \"conge\" where id_conge= "+id+"";
        preparar=conn.prepareStatement(requete);
        preparar.executeUpdate();
    }
    public void modifier_reste_jour_conge(int reste_conge,int id_employe) throws SQLException, ClassNotFoundException
    {
        PreparedStatement preparar=null;
        Connection conn = this.getConnectionPostgres();
        String requete="update \"reliquat_employe\" set reste_conge = "+reste_conge+" where id_employe= "+id_employe+"";
        preparar=conn.prepareStatement(requete);
        preparar.executeUpdate();
    }
    public String maka_nom_employe(int id) throws Exception
    {
        PreparedStatement preparar=null;
        Connection conn = this.getConnectionPostgres();
        Statement stmt=null;
        String status=null;
        int valiny=0;
        try
        {
            stmt=conn.createStatement();
            String requete="select nom as nom from employe where id_emp="+id+"";
            preparar = conn.prepareStatement(requete);
            ResultSet rs=preparar.executeQuery();
            while(rs.next())
            {
                status = rs.getString("nom");
            }
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
    public String maka_prenom_employe(int id) throws Exception
    {
        PreparedStatement preparar=null;
        Connection conn = this.getConnectionPostgres();
        Statement stmt=null;
        String status=null;
        try
        {
            stmt=conn.createStatement();
            String requete="select prenoms as prenoms from employe where id_emp="+id+"";
            preparar = conn.prepareStatement(requete);
            ResultSet rs=preparar.executeQuery();
            while(rs.next())
            {
                status = rs.getString("prenoms");
            }
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
    public String maka_matricule_employe(int id) throws Exception
    {
        PreparedStatement preparar=null;
        Connection conn = this.getConnectionPostgres();
        Statement stmt=null;
        String status=null;
        try
        {
            stmt=conn.createStatement();
            String requete="select identifiant as identifiant from employe where id_emp="+id+"";
            preparar = conn.prepareStatement(requete);
            ResultSet rs=preparar.executeQuery();
            while(rs.next())
            {
                status = rs.getString("identifiant");
            }
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
    public int get_jour_by_date(Date debut,Date fin)
    {
        int de=debut.getDate();
        int f=fin.getDate();
        int val=f-de+1;
        return val;
    }
    public int heure_jour(int emploi_temps,int heure)
    {
       return heure/emploi_temps;
    }
    public int jour_heure(int emploi_temps,int jour)
    {
        return jour*emploi_temps;
    }
    
}
