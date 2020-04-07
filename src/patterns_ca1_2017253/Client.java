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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {

//constructor
Client(){
        
    ShowMenu();
    OptionSelected();
    
    
}      
 
 CountryDAO dao = new MySqlCountryDAO();
     
 
// this method displays menu and prompts user to choose action to perform
public void ShowMenu(){                      
    
      
    System.out.println("Choose one of the Following: ");
    
    System.out.println("1- List all countries");
    System.out.println("2 -Find country by country code");
    System.out.println("3- Find country by name");
    System.out.println("4- Save new country to database");
    System.out.println("Enter your Answer (1 to 4): ");

         
}

//This method gets user choice and validates input
public void OptionSelected(){                   

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    String answer = "";
    
    try{                                            //this block validates that the user entered  correct option
        boolean correct = false;                    //from the menu (an int from 1 to 4)
                                                    //if the input is incorrect it prompts the user to select a vaid option
        do{
            answer = input.readLine();
            if(answer.matches("[1-4]+")){
                correct = true;
            
            }else{
            
                correct = false;
                System.out.println("Please choose a valid Menu option");
                   }
        }
        while(correct==false);
        }
    catch(Exception e){System.out.println("error");}
    
    if(answer.equals("1")){
        
      List();
      backToMenu();
    }
    else if(answer.equals("2")){
               
        findByCode();
        backToMenu();
    
    }
    else if(answer.equals("3")){
    
        findByName();
        backToMenu();
    
    }
    else if(answer.equals("4")){
    
        SaveNewCountry();
        backToMenu();
    
    }


}
    
    //this method lists all countries in database
public void List(){

ArrayList<Country> countries = dao.getCountries();
System.out.println(countries);
    
 backToMenu();    
}

//this method find countries by code
public void findByCode(){
    
    
        System.out.println("Please enter the country Code: ");
        
        Country c = dao.findCountrybyCode("000");
        System.out.println(c);
        
        
    
}

//this method finds countries by name
public void findByName(){
    
    System.out.println("Please enter the country Name: ");
        
        Country d = dao.findCountrybyName("alibaba");
        System.out.println(d);
    
    backToMenu();}

//this method saves new country to database
public void SaveNewCountry(){
    
    CountryDAO db = new MySqlCountryDAO();
    ArrayList<Country> countries = dao.getCountries();
    
    System.out.println("Please provide the following information: Code, Name, Continent, Surface Area, Head of state ");
    
    Country newCountry = new Country("6a6", "Mordor", "Asia", 12444, "Sauron");
		
    countries.add(newCountry);
		
 // ADDING THE NEW CUSTOMER INTO THE DATABASE
  System.out.println(db.saveCountry(newCountry));		
		  
    backToMenu();
}


//method to allow user chosing if to exit or do another thing in program
public void backToMenu(){
        System.out.println("Back to Menu? Y/N ");
       boolean valid = false;
       do {    
            try{  
	          
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
                String input = br.readLine();
                input = input.toUpperCase();
                valid = input.equals("Y") || input.equals("N");
                
                //If user wants to go back to Menu take them back
                if(input.equals("Y")){
                    
                   ShowMenu();      
                   OptionSelected();
                }
                
                //If input is N, user wants to exit program
                else if(input.equals("N")){ 
                    System.out.println("You have exited the program");
                
                }

            }catch(Exception e){System.out.println("error");}
       }while(valid == false);

}
    
    
   

}