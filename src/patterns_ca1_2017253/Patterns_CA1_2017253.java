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

      
    // This is the main method 
    public static void main(String[] args) {
        // TODO code application logic here
            
         //instance of Client class
        Client client = new Client();
         
        //methods in Client class in charge of displaying the menu and processing the options selected by user
        client.ShowMenu();
        client.OptionSelected();
       
     
    } 
}
