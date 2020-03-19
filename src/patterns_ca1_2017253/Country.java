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
public class Country {
    
     int Code;
     String Name;
     float SurfaceArea;
     String HeadOfState;
    
    //private constructor
    private Country() {
    }
    
    //static instance
    private static Country country = new Country();     
    
    //public, static method
    public static Country getInstance() {           
		return country;
	}

   /*  
    public int getCode(){
    
        return Code;
    
    }
    
    public void setCode(int Code){
    
        this.Code = Code;
    }
    
    public String getName(){
    
        return Name;
    
    }
    
    public void setName(String Name){
    
        this.Name = Name;
    }
    public String getHeadfState(){
    
        return HeadOfState;
    
    }
    
    public void setHeadOfState(String HeadOfState){
    
        this.HeadOfState = HeadOfState;
    }
    
    public float getSurfaceArea(){
    
        return SurfaceArea;
    
    }
    
    public void setCode(float SurfaceArea){
    
        this.SurfaceArea = SurfaceArea;
    }
    */
    
    
        
}