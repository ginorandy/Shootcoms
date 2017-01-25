import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
//import java.util.Date;
import java.sql.Date;
import java.util.Set;

/**
 *
 * @author Randy
 */
public class Fonction {
    Connection conexion;
    public void Fonction()
    {
        
    }
    public int getNextsequence(String nomseq) throws SQLException
    {
        //PreparedStatement preparar=null;
        connexion connection=new connexion();
        connection.connect();
        this.conexion=connection.getConnexion();
        Statement stmt=this.conexion.createStatement();
        
        int sequ=0;
        try{
            String seq="select nextval('"+nomseq+"')";
            //preparar=this.conexion.prepareStatement(seq);
            this.conexion = connection.getConnexion();
            
            ResultSet sequence = stmt.executeQuery(seq);
            sequence.next();

            sequ = sequence.getInt(1);

            this.conexion.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return sequ;
    }
    public int getLastsequence(String nomseq)
    {
        String seq="select currval('"+nomseq+"')";
        int sequ=0;
        
        try{
            connexion connection=new connexion();
            connection.connect();
            this.conexion = connection.getConnexion();
            Statement stmt=this.conexion.createStatement();
            ResultSet sequence = stmt.executeQuery(seq);
            sequence.next();

            sequ = sequence.getInt(1);

            stmt.close();
            this.conexion.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return sequ;
    }
    /*public void insert_medecins(Medecins m)
    {
        PreparedStatement preparar=null;
        connexion connection=new connexion();
        connection.connect();
        this.conexion=connection.getConnexion();
        /*int va=0;
        va = getNextsequence("employesmedecins_id_emploie_seq");
        try
        {
            String requete="insert into \"employesmedecins\"(id_emploie,nomemploie,sexee,date_naisse,mariagee,adressee,email,contact,id_occupations) values(?,?,?,?,?,?,?,?);";
            preparar=this.conexion.prepareStatement(requete);
            //preparar.setInt(1,va);
            preparar.setString(1,m.getNomemploie());
            preparar.setString(2,m.getSexee());
            preparar.setString(3,m.getDate_naisse());
            preparar.setString(4,m.getMariagee());
            preparar.setString(5,m.getAdressee());
            preparar.setString(6,m.getEmail());
            preparar.setString(7,m.getContact());
            preparar.setInt(8,m.getId_occupations());
            preparar.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void insert_poste(Medecins m)
    {
        PreparedStatement preparar=null;
        connexion connection=new connexion();
        connection.connect();
        this.conexion=connection.getConnexion();
        try
        {
            String requete="insert into \"employesmedecins\"(id_emploie,nomemploie,sexee,date_naisse,mariagee,adressee,email,contact,id_occupations) values(?,?,?,?,?,?,?,?,?);";
            preparar=this.conexion.prepareStatement(requete);
            preparar.setInt(1,m.getId_emploie());
            preparar.setString(2,m.getNomemploie());
            preparar.setString(3,m.getSexee());
            preparar.setString(4,m.getDate_naisse());
            preparar.setString(5,m.getMariagee());
            preparar.setString(6,m.getAdressee());
            preparar.setString(7,m.getEmail());
            preparar.setString(8,m.getContact());
            preparar.setInt(9,m.getId_occupations());
            preparar.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }*/
    public int select(Utilisateur m)
    {
        PreparedStatement preparar=null;
        connexion connection=new connexion();
        connection.connect();
        Statement stmt=null;
        this.conexion=connection.getConnexion();
        int status=0;
        try
        {   stmt=this.conexion.createStatement();
            String requete="select * from \"admin\" where nom=? AND pass=?";
            preparar=this.conexion.prepareStatement(requete);
            preparar.setString(1,m.getNom());
            preparar.setString(2,m.getPass());
            ResultSet rs=preparar.executeQuery();  
            while(rs.next())
            {
                status=rs.getInt("id_admin");
                System.out.println(status);
            }
            this.conexion.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
    public int getTableSize(String table,String nom,String sexe,String dateN,String mar,String adresse,String mail,String contact) throws ClassNotFoundException, SQLException
    {
        PreparedStatement preparar=null;
        connexion connection=new connexion();
        connection.connect();
        Statement stmt=null;
        this.conexion=connection.getConnexion();
        int status=0;
        Integer i;
        try
        {   stmt=this.conexion.createStatement();
            String requete="SELECT Count(*) FROM "+table+" where nomemploie ILIKE '%"+nom+"%' and sexee ILIKE '%"+sexe+"%' and date_naisse ILIKE '%"+dateN+"%' and mariagee ILIKE '%"+mar+"%' and adressee ILIKE '%"+adresse+"%' and email ILIKE '%"+mail+"%' and contact ILIKE '%"+contact+"%'";
            preparar=this.conexion.prepareStatement(requete);
            ResultSet rs=preparar.executeQuery();  
            while(rs.next())
            {
                i=Integer.parseInt(rs.getString(1));
                status=i;
            }
            this.conexion.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
    public int getTaille(String table,int id) throws ClassNotFoundException, SQLException
    {
        PreparedStatement preparar=null;
        connexion connection=new connexion();
        connection.connect();
        Statement stmt=null;
        this.conexion=connection.getConnexion();
        int status=0;
        Integer i;
        try
        {   stmt=this.conexion.createStatement();
            String requete="SELECT Count(*) FROM "+table+" where id_emploie = "+id+"";
            preparar=this.conexion.prepareStatement(requete);
            ResultSet rs=preparar.executeQuery();  
            while(rs.next())
            {
                i=Integer.parseInt(rs.getString(1));
                status=i;
            }
            this.conexion.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
    public int getTaille2(String table,int id) throws ClassNotFoundException, SQLException
    {
        PreparedStatement preparar=null;
        connexion connection=new connexion();
        connection.connect();
        Statement stmt=null;
        this.conexion=connection.getConnexion();
        int status=0;
        Integer i;
        try
        {   stmt=this.conexion.createStatement();
            String requete="SELECT Count(*) FROM "+table+" where id_patient = "+id+"";
            preparar=this.conexion.prepareStatement(requete);
            ResultSet rs=preparar.executeQuery();  
            while(rs.next())
            {
                i=Integer.parseInt(rs.getString(1));
                status=i;
            }
            this.conexion.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
    public int tailleTable(String table) throws ClassNotFoundException, SQLException
    {
        PreparedStatement preparar=null;
        connexion connection=new connexion();
        connection.connect();
        Statement stmt=null;
        this.conexion=connection.getConnexion();
        int status=0;
        Integer i;
        try
        {   stmt=this.conexion.createStatement();
            String requete="SELECT Count(*) FROM "+table;
            preparar=this.conexion.prepareStatement(requete);
            ResultSet rs=preparar.executeQuery();  
            while(rs.next())
            {
                i=Integer.parseInt(rs.getString(1));
                status=i;
            }
            this.conexion.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
    public Poste[] getPoste() throws ClassNotFoundException, SQLException
    {
        connexion connection=new connexion();
        connection.connect();
        
        this.conexion=connection.getConnexion();
        Statement stmt=this.conexion.createStatement();
        int taille=this.tailleTable("occupations");
        Poste[] reponse=new Poste[taille];
        for(int j=0;j<taille;j++)
        {
            reponse[j]=new Poste();
        }
        try
        {   
            String requete="select * from occupations";
            ResultSet rs=stmt.executeQuery(requete);
            int i=0;
            while(rs.next())
            {
                reponse[i].setId_occupations(rs.getInt(1));
                reponse[i].setOccupation(rs.getString(2));
                i++;
            }
            this.conexion.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //System.out.print(reponse[0].getOccupation());
        return reponse;
    }
    public Medecins[] getm() throws ClassNotFoundException, SQLException
    {
        connexion connection=new connexion();
        connection.connect();
        
        this.conexion=connection.getConnexion();
        Statement stmt=this.conexion.createStatement();
        int taille=this.tailleTable("employesmedecins");
        Medecins[] reponse=new Medecins[taille];
        for(int j=0;j<taille;j++)
        {
            reponse[j]=new Medecins();
        }
        try
        {   
            String requete="select * from employesmedecins";
            ResultSet rs=stmt.executeQuery(requete);
            int i=0;
            while(rs.next())
            {
                reponse[i].setId_emploie(rs.getInt(1));
                reponse[i].setNomemploie(rs.getString(2));
                i++;
            }
            this.conexion.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //System.out.print(reponse[0].getOccupation());
        return reponse;
    }
    public Categories[] getcategorie() throws ClassNotFoundException, SQLException
    {
        connexion connection=new connexion();
        connection.connect();
        
        this.conexion=connection.getConnexion();
        Statement stmt=this.conexion.createStatement();
        int taille=this.tailleTable("categories");
        Categories[] reponse=new Categories[taille];
        for(int j=0;j<taille;j++)
        {
            reponse[j]=new Categories();
        }
        try
        {   
            String requete="select * from categories";
            ResultSet rs=stmt.executeQuery(requete);
            int i=0;
            while(rs.next())
            {
                reponse[i].setId_cat(rs.getInt(1));
                reponse[i].setCategories(rs.getString(2));
                i++;
            }
            this.conexion.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return reponse;
    }
    public Medecins[] recherche(String nom,String sexe,String dateN,String mar,String adresse,String mail,String contact) throws SQLException, ClassNotFoundException
    {
        connexion connection=new connexion();
        connection.connect();
        
        this.conexion=connection.getConnexion();
        Statement stmt=this.conexion.createStatement();
        
        int taille=this.getTableSize("employesmedecins",nom,sexe,dateN,mar,adresse,mail,contact);
        Medecins[] reponse=new Medecins[taille];
        try
        {
            String requete="select * from employesmedecins where nomemploie ILIKE '%"+nom+"%' and sexee ILIKE '%"+sexe+"%' and date_naisse ILIKE '%"+dateN+"%' and mariagee ILIKE '%"+mar+"%' and adressee ILIKE '%"+adresse+"%' and email ILIKE '%"+mail+"%' and contact ILIKE '%"+contact+"%'";
            System.out.println(requete);
            ResultSet rs=stmt.executeQuery(requete);
            int i=0;
            while(rs.next())
            {
                reponse[i]=new Medecins();
                reponse[i]=new Medecins(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9));
                
                System.out.println(reponse[i].getNomemploie());
                i++;
            }
            this.conexion.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return reponse;
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
    public void insert_employe(String nom,String sexe,String nais,String mart,String adresse,String email,String contact,int occup) throws SQLException
    {
        PreparedStatement preparar=null;
        connexion connection=new connexion();
        connection.connect();
        this.conexion=connection.getConnexion();
        String requete="insert into \"employesmedecins\" values(nextval('employesmedecins_id_emploie_seq'),'"+nom+"','"+sexe+"','"+nais+"','"+mart+"','"+adresse+"','"+email+"','"+contact+"',"+occup+")";
        preparar=this.conexion.prepareStatement(requete);
        preparar.executeUpdate();
    }
    public void insert_poste(String designation) throws SQLException
    {
        PreparedStatement preparar=null;
        connexion connection=new connexion();
        connection.connect();
        this.conexion=connection.getConnexion();
        String requete="insert into \"occupations\" values(nextval('occupations_id_occupations_seq'),'"+designation+"')";
        preparar=this.conexion.prepareStatement(requete);
        preparar.executeUpdate();
    }
    public Medecins[] modif_supp(int id_medec) throws SQLException, ClassNotFoundException
    {
        connexion connection=new connexion();
        connection.connect();
        
        this.conexion=connection.getConnexion();
        Statement stmt=this.conexion.createStatement();
        
        int taille=this.getTaille("employesmedecins",id_medec);
        Medecins[] reponse=new Medecins[taille];
        try
        {
            String requete="select * from employesmedecins where id_emploie = "+id_medec+"";
            System.out.println(requete);
            ResultSet rs=stmt.executeQuery(requete);
            int i=0;
            while(rs.next())
            {
                reponse[i]=new Medecins();
                reponse[i]=new Medecins(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9));
                
                System.out.println(reponse[i].getNomemploie());
                i++;
            }
            this.conexion.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return reponse;
    }
    public Patients[] modif(int id_patient) throws SQLException, ClassNotFoundException
    {
        connexion connection=new connexion();
        connection.connect();
        
        this.conexion=connection.getConnexion();
        Statement stmt=this.conexion.createStatement();
        
        int taille=this.getTaille2("patient",id_patient);
        Patients[] reponse=new Patients[taille];
        try
        {
            String requete="select * from patient where id_patient = "+id_patient+"";
            System.out.println(requete);
            ResultSet rs=stmt.executeQuery(requete);
            int i=0;
            while(rs.next())
            {
                reponse[i]=new Patients();
                reponse[i]=new Patients(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8));
                
                //System.out.println(reponse[i].getNomemploie());
                i++;
            }
            this.conexion.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return reponse;
    }
    public void modifier(int id,String nom,String sexe,String date_naiss,String mariage,String adresse,String email,String contact,int poste) throws SQLException
    {
        PreparedStatement preparar=null;
        connexion connection=new connexion();
        connection.connect();
        this.conexion=connection.getConnexion();
        String requete="update \"employesmedecins\" set nomemploie = '"+nom+"' , sexee = '"+sexe+"' , date_naisse='"+date_naiss+"' , mariagee='"+mariage+"' , adressee='"+adresse+"' , email='"+email+"' , contact='"+contact+"' , id_occupations='"+poste+"' where id_emploie= '"+id+"'";
        preparar=this.conexion.prepareStatement(requete);
        preparar.executeUpdate();
    }
    public void modifier_patient(int id_medec,int id_p) throws SQLException
    {
        PreparedStatement preparar=null;
        connexion connection=new connexion();
        connection.connect();
        this.conexion=connection.getConnexion();
        String requete="update \"patient\" set id_traitant = "+id_medec+" where id_patient= "+id_p+"";
        preparar=this.conexion.prepareStatement(requete);
        preparar.executeUpdate();
    }
    public String sexe_contraire(String s)
    {
        if(s.equals("Femme"))
        {
            return "Homme";
        }
        else if(s.equals("Homme"))
        {
            return "Femme";
        }
        return "";
    }
    public void supprimer(int id) throws SQLException
    {
        PreparedStatement preparar=null;
        connexion connection=new connexion();
        connection.connect();
        this.conexion=connection.getConnexion();
        String requete="delete from \"employesmedecins\" where id_emploie= '"+id+"'";
        preparar=this.conexion.prepareStatement(requete);
        preparar.executeUpdate();
    }
    public void insert_articles(Articles a) throws SQLException
    {
        PreparedStatement preparar=null;
        connexion connection=new connexion();
        connection.connect();
        this.conexion=connection.getConnexion();
        try
        {
            String requete="insert into \"article\" values(nextval('article_id_article_seq'),'"+a.getNom()+"',"+a.getId_categorie()+");";
            preparar=this.conexion.prepareStatement(requete);
            preparar.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void insert_prixa(PrixA actuel)
    {
        PreparedStatement preparar=null;
        connexion connection=new connexion();
        connection.connect();
        this.conexion=connection.getConnexion();
        try
        {
            String requete="insert into \"prix_actuel_article\" values(nextval('pix_actuel_article_id_actuel_seq'),"+actuel.getPrix()+",'"+actuel.getDate_p()+"',"+actuel.getId_article()+");";
            preparar=this.conexion.prepareStatement(requete);
            preparar.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void insert_prix(PrixH prix)
    {
        PreparedStatement preparar=null;
        connexion connection=new connexion();
        connection.connect();
        this.conexion=connection.getConnexion();
        try
        {
            String requete="insert into \"historique_prix\" values(nextval('historique_prix_id_historique_seq'),"+prix.getPrix()+",'"+prix.getDate_h()+"',"+prix.getId_article()+");";
            preparar=this.conexion.prepareStatement(requete);
            preparar.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void insert_facture_fille(Facture_fille ff)
    {
        PreparedStatement preparar=null;
        connexion connection=new connexion();
        connection.connect();
        this.conexion=connection.getConnexion();
        try
        {
            String requete="insert into \"facture_fille\" values(nextval('facture_fille_id_ff_seq'),"+ff.getQuantite()+","+ff.getPrix()+","+ff.getId_article()+","+ff.getId_fm()+");";
            preparar=this.conexion.prepareStatement(requete);
            preparar.executeUpdate();
            System.out.println(ff.getId_ff()+"inseré");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void insert_facture_mere(Facture_mere fm)
    {
        PreparedStatement preparar=null;
        connexion connection=new connexion();
        connection.connect();
        this.conexion=connection.getConnexion();
        try
        {
            String requete="insert into \"facture_mere\" values(nextval('facture_mere_id_fm_seq'),"+fm.getTva()+","+fm.getRemise()+",'"+fm.getDate_now()+"',"+fm.getId_patient()+","+fm.getMontant()+");";
            preparar=this.conexion.prepareStatement(requete);
            preparar.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public int getTableSize2(String table,String nom) throws ClassNotFoundException, SQLException
    {
        PreparedStatement preparar=null;
        connexion connection=new connexion();
        connection.connect();
        Statement stmt=null;
        this.conexion=connection.getConnexion();
        int status=0;
        Integer i;
        try
        {   stmt=this.conexion.createStatement();
            String requete="SELECT Count(*) FROM "+table+" where nom_prenom ILIKE '%"+nom+"%'";
            preparar=this.conexion.prepareStatement(requete);
            ResultSet rs=preparar.executeQuery();  
            while(rs.next())
            {
                i=Integer.parseInt(rs.getString(1));
                status=i;
            }
            this.conexion.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
    public int getTableSize3(String table,String nom,int categ) throws ClassNotFoundException, SQLException
    {
        PreparedStatement preparar=null;
        connexion connection=new connexion();
        connection.connect();
        Statement stmt=null;
        this.conexion=connection.getConnexion();
        int status=0;
        Integer i;
        try
        {   stmt=this.conexion.createStatement();
            String requete="SELECT Count(*) FROM "+table+" where designation ILIKE '%"+nom+"%' and id_categorie ='"+categ+"'";
            preparar=this.conexion.prepareStatement(requete);
            ResultSet rs=preparar.executeQuery();  
            while(rs.next())
            {
                i=Integer.parseInt(rs.getString(1));
                status=i;
            }
            this.conexion.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
    public Patients[] recherchep(String nom) throws SQLException, ClassNotFoundException
    {
        connexion connection=new connexion();
        connection.connect();
        
        this.conexion=connection.getConnexion();
        Statement stmt=this.conexion.createStatement();
        
        int taille=this.getTableSize2("patient",nom);
        Patients[] reponse=new Patients[taille];
        /*for(int j=0;j<taille;j++)
        {
            reponse[j]=new Patients();
        }*/
        try
        {
            String requete="select * from patient where nom_prenom ILIKE '%"+nom+"%'";
            System.out.println(requete);
            ResultSet rs=stmt.executeQuery(requete);
            int i=0;
            while(rs.next())
            {
                reponse[i]=new Patients();
                reponse[i]=new Patients(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8));
                
                System.out.println(reponse[i].getDate_n());
                i++;
            }
            this.conexion.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return reponse;
    }
    public Articles[] recherchea(String nom,int categ) throws SQLException, ClassNotFoundException
    {
        connexion connection=new connexion();
        connection.connect();
        
        this.conexion=connection.getConnexion();
        Statement stmt=this.conexion.createStatement();
        
        int taille=this.getTableSize3("article",nom,categ);
        Articles[] reponse=new Articles[taille];
        /*for(int j=0;j<taille;j++)
        {
            reponse[j]=new Patients();
        }*/
        try
        {
            String requete="select * from article where designation ILIKE '%"+nom+"%' and id_categorie ='"+categ+"'";
            System.out.println(requete);
            ResultSet rs=stmt.executeQuery(requete);
            int i=0;
            while(rs.next())
            {
                reponse[i]=new Articles();
                reponse[i]=new Articles(rs.getInt(1),rs.getString(2),rs.getInt(3));
                i++;
            }
            this.conexion.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return reponse;
    }
    public Medecins[] traitants() throws ClassNotFoundException, SQLException
    {
        connexion connection=new connexion();
        connection.connect();
        
        this.conexion=connection.getConnexion();
        Statement stmt=this.conexion.createStatement();
        int taille=this.tailleTable("employesmedecins");
        Medecins[] reponse=new Medecins[taille];
        for(int j=0;j<taille;j++)
        {
            reponse[j]=new Medecins();
        }
        try
        {   
            String requete="select * from employesmedecins";
            ResultSet rs=stmt.executeQuery(requete);
            int i=0;
            while(rs.next())
            {
                reponse[i].setId_emploie(rs.getInt(1));
                reponse[i].setNomemploie(rs.getString(2));
                i++;
            }
            this.conexion.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return reponse;
    }
    public PrixA[] now(int id) throws ClassNotFoundException, SQLException
    {
        connexion connection=new connexion();
        connection.connect();
        
        this.conexion=connection.getConnexion();
        Statement stmt=this.conexion.createStatement();
        int taille=this.tailleTable("prix_actuel_article");
        PrixA[] reponse=new PrixA[taille];
        for(int j=0;j<taille;j++)
        {
            reponse[j]=new PrixA();
        }
        try
        {   
            String requete="select * from prix_actuel_article where id_article='"+id+"'";
            ResultSet rs=stmt.executeQuery(requete);
            int i=0;
            while(rs.next())
            {
                reponse[i].setId_actuel(rs.getInt(1));
                reponse[i].setPrix(rs.getDouble(2));
                reponse[i].setDate_p(rs.getDate(3));
                reponse[i].setId_article(rs.getInt(4));
                i++;
            }
            this.conexion.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return reponse;
    }
    public Consultation[] patient(int id) throws ClassNotFoundException, SQLException
    {
        connexion connection=new connexion();
        connection.connect();
        
        this.conexion=connection.getConnexion();
        Statement stmt=this.conexion.createStatement();
        int taille=this.tailleTable("consultation");
        Consultation[] reponse=new Consultation[taille];
        for(int j=0;j<taille;j++)
        {
            reponse[j]=new Consultation();
        }
        try
        {   
            String requete="select * from consultation where id_patient='"+id+"'";
            ResultSet rs=stmt.executeQuery(requete);
            int i=0;
            while(rs.next())
            {
                reponse[i].setId_consultation(rs.getInt(1));
                reponse[i].setId_patient(rs.getInt(2));
                reponse[i].setDesignation(rs.getString(3));
                reponse[i].setPrix(rs.getDouble(4));
                reponse[i].setDate_cons(rs.getDate(5));
                i++;
            }
            this.conexion.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return reponse;
    }
    public void insert_consultation(Consultation cc)
    {
        PreparedStatement preparar=null;
        connexion connection=new connexion();
        connection.connect();
        this.conexion=connection.getConnexion();
        try
        {
            String requete="insert into \"consultation\" values(nextval('consultation_id_consultation_seq'),"+cc.getId_patient()+",'"+cc.getDesignation()+"',"+cc.getPrix()+",'"+cc.getDate_cons()+"');";
            preparar=this.conexion.prepareStatement(requete);
            preparar.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void insert_paiement(Paiement cc)
    {
        PreparedStatement preparar=null;
        connexion connection=new connexion();
        connection.connect();
        this.conexion=connection.getConnexion();
        try
        {
            String requete="insert into \"paiement\" values(nextval('paiement_id_paiement_seq'),"+cc.getId_fm()+","+cc.getId_patient()+",'"+cc.getMode_paie()+"',"+cc.getPaye()+","+cc.getNon_paye()+",'"+cc.getFin_paie()+"');";
            preparar=this.conexion.prepareStatement(requete);
            preparar.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    
}
