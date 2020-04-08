/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns_ca1_2017253;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ana Ospitaletche
 */
public class MySqlCountryDAO implements CountryDAO {
    
    
        Data db = new Data();

    @Override
    public ArrayList<Country> getCountries() {
            
        ArrayList<Country> countries = new ArrayList<Country>();
        String query = "SELECT * from country";
        
        ResultSet rs = db.select(query);
        String Code = "";
        String Name = "";
        String Continent = "";
        float SurfaceArea = 0;
        String HeadOfState = "";
       
        Country c = null;
        
        try{
            
            while(rs.next()){
                Code =  rs.getString(1);
                Name = rs.getString(2);
                Continent = rs.getString(3);
                SurfaceArea = rs.getFloat(4);
                HeadOfState = rs.getString(5);
                
                c = new Country(Code, Name, Continent, SurfaceArea, HeadOfState);
                countries.add(c);
        }
        }catch (SQLException e){
                e.printStackTrace();
        
        }
        
            return countries;

    }

    
    
    @Override
    public Country findCountrybyCode(String Code) {
        Country c = null;
        String query = "SELECT * FROM country WHERE Code = " + Code + ";";
        ResultSet rs = db.select(query);
        
        try{
            rs.next();
            
             String Name = rs.getString(2);
             String Continent = rs.getString(3);
             float SurfaceArea = rs.getFloat(4);
             String HeadOfState = rs.getString(5);
             c = new Country(Code, Name, Continent, SurfaceArea, HeadOfState);
			
            
       
        }catch (SQLException e){
                e.printStackTrace();
        
        }
        return c;
        }

    @Override
    public ArrayList<Country> findCountrybyName(String Name) {
        
        String Code = "";
        String name = "";
        String Continent = "";
        float SurfaceArea = 0;
        String HeadOfState = "";
        
        ArrayList<Country> countries = new ArrayList<Country>();
        Country d = null;
        
        String query =  "select * from world.country WHERE Name Like '% "+Name+"%';";
       
        Data db = new Data();
        ResultSet rs = db.select(query);
        
        try{
            while(rs.next()){
                Code =  rs.getString(1);
                name = rs.getString(2);
                Continent = rs.getString(3);
                SurfaceArea = rs.getFloat(4);
                HeadOfState = rs.getString(5);
                
                d = new Country(Code, name, Continent, SurfaceArea, HeadOfState);
                countries.add(d);
        }
			
            
        }catch (SQLException e){
                e.printStackTrace();
        
        }
        return countries;
        }

    
 
    
    

    @Override
    public  boolean saveCountry(Country country) {
                
                // FROM THE OBJECT, GETTING THE DATA
		String Name = country.getName();
                String HeadOfState = country.getHeadOfState();
                String Continent = country.getContinent();
                float SurfaceArea = country.getSurfaceArea();
                String Code = country.getCode();
		
		// THIS METHOD IS IN CHARGE OF CREATING THE QUERY
		String query = "INSERT into country (Code, Name, Continent, SurfaceArea, HeadOfState) values ('" + Code + "', '" + Name + "','" + Continent + "', '" + SurfaceArea + "', '" + HeadOfState + "')";
		
		// REQUESTION TO SAVE THE DATA
		boolean result = db.SaveToDb(query);
		
	
		
		return result;
	}
    
            

            
           
        
       
      
        
       }
    
    
    
    
    

