/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns_ca1_2017253;

/**
 *
 * @author Ana Ospitaletche
 */

 import java.util.ArrayList;


//This interface has the methods that will take information from database 

public interface CountryDAO {
    
        public ArrayList<Country> getCountries();
	public Country findCountrybyCode(String Code);
        public ArrayList<Country> findCountrybyName (String Name);
	public boolean saveCountry(Country country);
        

}
