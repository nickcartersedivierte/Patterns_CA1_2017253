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
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Platform.exit;

public class Client {

//constructor
Client(){
        
    ShowMenu();
    OptionSelected();
    
    
}      
 
 CountryDAO dao = new MySqlCountryDAO();
  BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
  String answer = "";   
 
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
    
//this method lists all the countries in the database
public void List(){

            ArrayList<Country> countries = dao.getCountries();
            System.out.println(countries);
      
}

//this method finds countries by code
public void findByCode(){
         
            try{
                System.out.println("Please enter the country Code: ");
                answer = input.readLine();
                ArrayList<Country> countries= dao.findCountrybyCode(answer);
                System.out.println(countries);
            
            }catch(IOException e){
               e.printStackTrace();
            
            } 
        
}


//this method finds countries by name
public void findByName(){
    
            try{
                 System.out.println("Please enter the country Name: ");
                 answer = input.readLine();
                 ArrayList<Country> countries = dao.findCountrybyName(answer);
                 System.out.println(countries);
    
                
             }catch(IOException e){
               e.printStackTrace();
            
            }
            }

//this method saves a new country to the database
public void SaveNewCountry(){
    
    CountryDAO db = new MySqlCountryDAO();
    ArrayList<Country> countries = dao.getCountries();
        
            try{
    
                System.out.println("Please provide the following information: ");
    
                System.out.println("Code of the Country: ");
                String Code = input.readLine();
    
                System.out.println("Name of the Country: ");
                String Name = input.readLine();
    
                System.out.println("Continet of the Country: ");
                String Continent = input.readLine();
    
                System.out.println("Head Of State of the Country: ");
                String HeadOfState = input.readLine();
    
      
                System.out.println("Surface Area of the Country: ");
                float SurfaceArea = 0;
                String Surf = String.valueOf(SurfaceArea);
                Surf = input.readLine();
        
                Country.CountryBuilder builder = new Country.CountryBuilder(Code, Name, Continent).setHeadOfState(HeadOfState).setSurfaceArea(SurfaceArea);
                Country c1 = builder.build();	
                countries.add(c1);
		
                // ADDING THE NEW COUNTRY TO THE DATABASE
                System.out.println(db.saveCountry(c1));
    
                System.out.println("Success!");
                backToMenu(); 
    
        }catch(IOException e){
               e.printStackTrace();
            
            }	
}


//method to allow user to choose if to exit or going back to the Menu
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
                    System.exit(0);
                }
                
                //validate user input
                if(!input.equals("Y")& !input.equals("N")){  
                
                    System.out.println("Please enter a valid option. Y or N only");
                }

            }catch(Exception e){System.out.println("error");}
       }while(valid == false);
}
}