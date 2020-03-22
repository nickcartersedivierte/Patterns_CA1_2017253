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


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CountryDAO {
    
                
     
     
    
       
        //this method will be to search a country by Code
        //it should display Name of the country, head of state and Area
        public Country getCountry (int Code) throws SQLException{
            
            Country c = Country.getInstance(); 
            
            try {
                String query = "select Name, Continent, HeadOfState, SurfaceArea from country where Code="+Code;
                
                c.Code = Code;
                Class.forName ("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://52.50.23.197:3306/world", "cctstudent", "Pass1234!");
                Statement st = con.createStatement();
                ResultSet result = st.executeQuery(query);
                result.next();
                String name = result.getString(2);
                c.Name = name;
                return c; 
            
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            }    
            
             return null;            
           
        }
    
    }




