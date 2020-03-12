/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns_ca1_2017253;

/**
 *
 * @author Ana Ospitaletche
 *
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//This is my Singletton class
public class Country {
    
    private static Country country = new Country();     //static instance
   
    private Country(){                                  //private constructor
    
    
    
    }
    
   
    public static Country getInstance() {            //public, static method
		return country;
	}
	
   

    
    
    
    
    
    
    enum Continent{

        Asia,
        Europe,
        NorthAmerica,
        Africa,
        Oceania,
        Antarctica,
        SouthAmerica;
  
}




}