 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patterns_ca1_2017253;

/**
 *
 * @author Ana Ospitaletche
 * 
 * USAR BUILDER PATTERN
 * 
 */
public class Country {
    
    private String Code;
    private String Name;
    private float SurfaceArea;
    private String HeadOfState;
    private String Continent;
    
    
    public Country(String Code, String Name, String Continent, float SurfaceArea, String HeadOfState) {
        
        this.Code = Code;
        this.HeadOfState = HeadOfState;
        this.Name = Name;
        this.SurfaceArea = SurfaceArea;
        this.Continent = Continent;
    }
   
    public String getCode(){
    
        return Code;
    
    }
    
    public void setCode(String Code){
    
        this.Code = Code;
    }
    
    public String getName(){
    
        return Name;
    
    }
    
    public void setName(String Name){
    
        this.Name = Name;
    }
    public String getHeadOfState(){
    
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
    
    public String getContinent(){
    
        return Continent;
    }
    
    public void setContinent(String Continent) {
    
    this.Continent = Continent;
    
    }
    
    @Override
	public String toString() {
		return "Code: " + Code + " Name: " + Name + " Continent: " + Continent + " Surface Area: " + SurfaceArea + " Head of State: " + HeadOfState;
	}	

}

    
    
        
