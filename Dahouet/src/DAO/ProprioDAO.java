package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ModelUI.ProprioNyf;


public class ProprioDAO 
{
	
	
	public static List<String> getListProprietaire()
	  {  
	    Connection c = Connect.cConnect();
	   
	    List<String> prop = new ArrayList<>();        
	          Statement stm;         
	          String nomprop;         
	    try  {
	     stm = c.createStatement();    
	     String sql = "select Nom_proprietaire from proprietaire ";
	           ResultSet rs = stm.executeQuery(sql);
	           while (rs.next())
	           {
	            nomprop = rs.getString("Nom_proprietaire"); 
	            prop.add(nomprop);
	           }
	           rs.close();      
	    } 
	    catch (SQLException e) 
	    {
	     e.printStackTrace();
	     throw new RuntimeException();
	    }   
	    return prop;
	  }
	
	
	public static void createProprio(ProprioNyf p) 
	{
		 
		 Connection c = Connect.cConnect();
		 PreparedStatement stm;
		try {
			stm = c.prepareStatement("INSERT INTO proprietaire (Num_proprietaire, Num_club, Nom_proprietaire, Coordonnees_proprietaire, Compte_participant) VALUES (?,?,?,?,?)");
			stm.setInt(1, p.getNum_proprietaire());
			stm.setInt(2, p.getNum_club());
			stm.setString(3, p.getNom_proprietaire());
			stm.setString(4, p.getCoordonnees_proprietaire());
			stm.setString(5, p.getCompte_participant());
			
			stm.execute();
			
			stm.close();
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}	
		 
		 
	 }
	
	public static int recupNumProprio(String propri)
	{
		Connection c = Connect.cConnect();
		PreparedStatement stm;

		int num = 0;
		try 
		{
			ResultSet rs = null ;  
			stm = c.prepareStatement("select Num_proprietaire from proprietaire where Nom_proprietaire like " + "'" + propri + "'"); 
			rs = stm.executeQuery(); 
			
			while(rs.next())
			{
				num = rs.getInt(1);
			}
		} 
		catch (SQLException e) 
		{
			throw new RuntimeException();
		}	
		
		return num;
	}
	
	

}
