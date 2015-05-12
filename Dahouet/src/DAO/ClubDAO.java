package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClubDAO 
{
	
	public static int recupNumClub(String club)
	{
		Connection c = Connect.cConnect();
		PreparedStatement stm;

		int num = 0;
		try 
		{
			ResultSet rs = null ;  
			stm = c.prepareStatement("select Num_club from club where Nom_club like " + "'" + club + "'"); 
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
	
	
	public static List<String> getListClub()
	  {  
	    Connection c = Connect.cConnect();
	   
	    List<String> clb = new ArrayList<>();        
	          Statement stm;         
	          String nomclub;         
	    try  {
	     stm = c.createStatement();    
	     String sql = "select Nom_club from club";
	           ResultSet rs = stm.executeQuery(sql);
	           while (rs.next())
	           {
	            nomclub = rs.getString("Nom_club"); 
	            clb.add(nomclub);
	           }
	           rs.close();      
	    } 
	    catch (SQLException e) 
	    {
	     e.printStackTrace();
	     throw new RuntimeException();
	    }   
	    return clb;
	  }

}
