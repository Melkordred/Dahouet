
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PATRICE FRANCOIS
 */
public  class Connect {

 private static Connection conn =null;

  final static String URL = "jdbc:mysql://localhost/dindhouet?noAccessToProcedureBodies=true";
    /**
     * 
     * @return RunTimeException() if any pb
     */
 public static Connection  cConnect () 
 {
     if (conn==null) {

       try
       {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
 
         // 
        conn=  DriverManager.getConnection(URL,"Secrétaire","dindon");
       }
         catch(SQLException sqlE)
         {
          //TODO Logging
             System.out.println("Sql Erreur " + sqlE.getMessage());
             throw new RuntimeException();
         }
         catch(Exception e)
         {
            e.printStackTrace();
            throw new RuntimeException();
         }
     }
     
     return conn;
     
 }
}