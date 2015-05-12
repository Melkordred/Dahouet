package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;





public class ClasseDAO 
{
		
	public static List<String> getListClasse(int numserie)
	  {  
	    Connection c = Connect.cConnect();
	   
	    List<String> clas = new ArrayList<>();        
	          Statement stm;         
	          String nomclasse;         
	    try  {
	     stm = c.createStatement();    
	     String sql = "select Nom_classe from classe where Num_serie ="+numserie;
	           ResultSet rs = stm.executeQuery(sql);
	           while (rs.next())
	           {
	            nomclasse = rs.getString("Nom_classe");
	            clas.add(nomclasse);
	           }
	           rs.close();      
	    } 
	    catch (SQLException e) 
	    {
	     e.printStackTrace();
	     throw new RuntimeException();
	    }   
	    return clas;
	  }

}
