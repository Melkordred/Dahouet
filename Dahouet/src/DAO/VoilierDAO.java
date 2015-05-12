package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import ModelUI.Voilier;

public class VoilierDAO 
{
	
	public static void createVoilier(Voilier voil) 
	{
		 
		 Connection c = Connect.cConnect();
		 PreparedStatement stm;
		 
		try 
		{
			stm = c.prepareStatement("INSERT INTO voilier (Num_voile, Num_proprietaire, Nom_classe, Nom_voilier) VALUES (?,?,?,?)");
			stm.setInt(1, voil.getNum_voile());
			stm.setInt(2, voil.getNum_proprietaire());
			stm.setString(3, voil.getNom_classe());
			stm.setString(4, voil.getNom_voilier());
			
			stm.execute ();
			
			stm.close();
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}	
		 
		 
	 }

}
