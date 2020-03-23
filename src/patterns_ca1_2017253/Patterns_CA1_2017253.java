/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns_ca1_2017253;

import java.util.ArrayList;

/**
 *
 * @author Ana Ospitaletche
 */
public class Patterns_CA1_2017253 {

      
    
    public static void main(String[] args) {
        // TODO code application logic here
            
          
                //instance class client
    
     CountryDAO dao = new MySqlCountryDAO();
     
     ArrayList<Country> countries = dao.getCountries();
     System.out.println(countries);
     
    /*Country c = dao.findCountrybyCode("000");
    System.out.println(c);*/
     
     
     Country coun = dao.findCountrybyName("Norway");
     System.out.println(coun);
    
     
     
     
    }
    
    
    
}
