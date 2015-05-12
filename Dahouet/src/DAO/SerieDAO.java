package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import DAO.Connect;



public class SerieDAO 
{
	
	
	
	public static List<String> getListSerie()
	  {  
	    Connection c = Connect.cConnect();
	   
	    List<String> seri = new ArrayList<>();        
	          Statement stm;         
	          String nomserie;         
	    try  {
	     stm = c.createStatement();    
	     String sql = "select Nom_serie from serie";
	           ResultSet rs = stm.executeQuery(sql);
	           while (rs.next())
	           {
	        	   nomserie = rs.getString("Nom_serie");
	        	   seri.add(nomserie);
	           }
	           rs.close();      
	    } 
	    catch (SQLException e) 
	    {
	     e.printStackTrace();
	     throw new RuntimeException();
	    }   
	    return seri;
	  }
	
}

