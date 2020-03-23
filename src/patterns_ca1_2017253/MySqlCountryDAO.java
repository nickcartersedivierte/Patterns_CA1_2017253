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
        float SurfaceArea = 0;
        String HeadOfState = "";
       
        Country c = null;
        
        try{
            
            while(rs.next()){
                Code =  rs.getString(1);
                Name = rs.getString(2);
                SurfaceArea = rs.getFloat(4);
                HeadOfState = rs.getString(5);
                
                c = new Country(Code, Name, SurfaceArea, HeadOfState);
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
        String query = "select * from country where Code = " + Code + ";";
        Data db = new Data();
        ResultSet rs = db.select(query);
        
        try{
            rs.next();
            
             String Name = rs.getString(2);
             float SurfaceArea = rs.getFloat(4);
             String HeadOfState = rs.getString(5);
             c = new Country(Code, Name, SurfaceArea, HeadOfState);
			
            // CLOSING THE CONNECTION TO THE DATABASE
            db.close();         
       
        }catch (SQLException e){
                e.printStackTrace();
        
        }
        return c;
        }

    @Override
    public Country findCountrybyName(String Name) {
        Country c = null;
        String query =  "SELECT * FROM country WHERE Name = " + Name + ";";
       
        Data db = new Data();
        ResultSet rs = db.select(query);
        
        try{
            rs.next();
            
             String Code = rs.getString(1);
             float SurfaceArea = rs.getFloat(4);
             String HeadOfState = rs.getString(5);
             c = new Country(Code, Name, SurfaceArea, HeadOfState);
			
            // CLOSING THE CONNECTION TO THE DATABASE
            db.close();         
       
        }catch (SQLException e){
                e.printStackTrace();
        
        }
        return c;
        }

    
 
    
    

    @Override
    public  boolean saveCountry(Country country) {
            
            Data db = new Data();
            String Name = country.getName();
            String HeadOfState = country.getHeadOfState();
            float SurfaceArea = country.getSurfaceArea();
            
            String query = "insert into customer (Name, HeadOfState, SurfaceArea) values ('" + Name + "', " + HeadOfState + ", '" + SurfaceArea + "')";
            
            return db.SaveToDb(query);
            
    }
    
    
    
    
}
