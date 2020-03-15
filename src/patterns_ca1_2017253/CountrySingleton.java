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
public class CountrySingleton {
    
    private char Code;
    private char Name;
    private float SurfaceArea;
    private char HeadOfState;
    
    //private constructor
    private CountrySingleton() {
    }
    
    private static CountrySingleton country = new CountrySingleton();     //static instance
    
     public static CountrySingleton getInstance() {            //public, static method
		return country;
	}

     
    public char getCode(){
    
        return Code;
    
    }
    
    public void setCode(char Code){
    
        this.Code = Code;
    }
    
    public char getName(){
    
        return Name;
    
    }
    
    public void setName(char Name){
    
        this.Name = Name;
    }
    public char getHeadfState(){
    
        return HeadOfState;
    
    }
    
    public void setHeadOfState(char HeadOfState){
    
        this.HeadOfState = HeadOfState;
    }
    
    public float getSurfaceArea(){
    
        return SurfaceArea;
    
    }
    
    public void setCode(float SurfaceArea){
    
        this.SurfaceArea = SurfaceArea;
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