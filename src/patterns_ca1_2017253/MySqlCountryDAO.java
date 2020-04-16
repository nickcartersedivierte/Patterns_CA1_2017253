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
    
        Data db = Data.getInstance();

       
      
    //This method prints out a list of all the countries in the database
    @Override
    public ArrayList<Country> getCountries() {
            
        ArrayList<Country> countries = new ArrayList<Country>();
        
        //SQL query
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
                
                //pointing to the Builder in Country class    
                Country.CountryBuilder c1 = new Country.CountryBuilder(Code, Name, Continent).setHeadOfState(HeadOfState).setSurfaceArea(SurfaceArea);
                c = c1.build();
                countries.add(c);
        }
        }catch (SQLException e){
                e.printStackTrace();
        
        }
        
            return countries;

    }

    //This method will find the country by code
    
    @Override
    public ArrayList<Country> findCountrybyCode(String Code) {
        
        Country c = null;
        String query = "SELECT * FROM world.country WHERE Code = '" + Code + "';";  //SQL query
        ResultSet rs = db.select(query);
        ArrayList<Country> countries = new ArrayList<Country>();
        
        try{
            //if the set is empty warn the user that the code is invalid
            if( rs.next()== false){  
                System.out.println("Invalid Code");
            }
            //If the code is correct, print out the results
            else{
                do{
                    String Name = rs.getString(2);
                    String Continent = rs.getString(3);
                    float SurfaceArea = rs.getFloat(4);
                    String HeadOfState = rs.getString(5);
                    
                    //pointing to the Builder in Country class    
                    Country.CountryBuilder c1 = new Country.CountryBuilder(Code, Name, Continent).setHeadOfState(HeadOfState).setSurfaceArea(SurfaceArea);
                    c = c1.build();	
                    countries.add(c);
                    
                }while(rs.next());
            }
            
        }catch (SQLException e){
                e.printStackTrace();
              }     
            
        return countries;
        }

    //This method searches for countries by Name
    @Override
    public ArrayList<Country> findCountrybyName(String Name) {
        
        /*String Code = "";
        String name = "";
        String Continent = "";
        float SurfaceArea = 0;
        String HeadOfState = "";*/
        
        ArrayList<Country> countries = new ArrayList<Country>();
        Country d = null;
        
        /*This is the SQL query. I had to put the OR statement, it was the ONLY WAY it printed to console all countries, 
        otherwise I would get null results, for ocuntries that are in the database*/
        String query =  "SELECT * FROM world.country WHERE Name LIKE '% "+Name+"%' OR Name = '"+Name+"';";
       
        ResultSet rs = db.select(query);
        ArrayList<Country> country = new ArrayList<Country>();
        
         try{
            while(rs.next()){
                String Code =  rs.getString(1);
                Name = rs.getString(2);
                String Continent = rs.getString(3);
                float SurfaceArea = rs.getFloat(4);
                String HeadOfState = rs.getString(5);
                
                
            Country.CountryBuilder c1 = new Country.CountryBuilder(Code, Name, Continent).setHeadOfState(HeadOfState).setSurfaceArea(SurfaceArea);
            d = c1.build();
            countries.add(d);
            }
            
        }catch (SQLException e){
                e.printStackTrace();
                                    
        }
        return countries;
        }
 
    
    //This method saves countries to the Database
    @Override
    public  boolean saveCountry(Country country) {
                
                // FROM THE OBJECT, GETTING THE DATA
		String Name = country.getName();
                String HeadOfState = country.getHeadOfState();
                String Continent = country.getContinent();
                float SurfaceArea = country.getSurfaceArea();
                String Code = country.getCode();
		
		// creating the SQL query
		String query = "INSERT into country (Code, Name, Continent, SurfaceArea, HeadOfState) values ('" + Code + "', '" + Name + "','" + Continent + "', '" + SurfaceArea + "', '" + HeadOfState + "')";
		
		// Saving the data
		boolean result = db.SaveToDb(query);
		
		return result;
	}
     
        
       }
    
    
    
    
    

