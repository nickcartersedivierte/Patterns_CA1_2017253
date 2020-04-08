/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns_ca1_2017253;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Ana Ospitaletche
 * 
 *  
 * Singleton
 * 
 */

//This class will connect to the database
public class Data {
        
        private String db = "jdbc:mysql://52.50.23.197:3306/world";
	private String un = "cctstudent";
	private String pw = "Pass1234!";
        
        private Statement stmt;
        private  Connection conn;
        private ResultSet rs = null;
        
        //private single instance
        private static Data instance = new Data();
   
        //priate constructor
        private Data() {
        
        	
		try{
			// Get a connection to the database
			conn = DriverManager.getConnection( db, un, pw ) ;

			// Get a statement from the connection
			 stmt = conn.createStatement();	
		}
		catch( SQLException se ){
			System.out.println( "SQL Exception:" ) ;

			// Loop through the SQL Exceptions
			while( se != null ){
				System.out.println( "State  : " + se.getSQLState()  ) ;
				System.out.println( "Message: " + se.getMessage()   ) ;
				System.out.println( "Error  : " + se.getErrorCode() ) ;

				se = se.getNextException() ;
			}
		}
		catch( Exception e ){
			System.out.println( e ) ;
		}
	}
   
     //Singleton getter of the Data instance   
    public static Data getInstance() {
		return instance;
	}
   
    public ResultSet select(String query) {
		try {
			 rs = stmt.executeQuery( query ) ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
    
    
    //This method saves data to the database
    
   public boolean SaveToDb(String query){
    
        try {
            stmt.execute(query);  //this method
            return true;
            
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
                        return false;	
                    }   
    }
   
    //This method closes the connection to the database
    public void close() {
		try {
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

    
