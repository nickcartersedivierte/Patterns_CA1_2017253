
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
 * This class implements the BUILDER PATTERN
 * 
 */
public class Country {
    
    private String Code;
    private String Name;
    private float SurfaceArea;
    private String HeadOfState;
    private String Continent;
    
    //Private constructor
    private Country(CountryBuilder builder) {
        
        this.Code = builder.Code;
        this.Name = builder.Name;
        this.Continent = builder.Continent;
        this.HeadOfState = builder.HeadOfState;
        this.SurfaceArea = builder.SurfaceArea;
    }
   
    public String getCode(){
    
        return Code;
    
    }
        
    public String getName(){
    
        return Name;
    
    }
    
    
    public String getHeadOfState(){
    
        return HeadOfState;
    
    }
       
    public float getSurfaceArea(){
    
        return SurfaceArea;
    
    }
    
   
    public String getContinent(){
    
        return Continent;
    }
      
    @Override
	public String toString() {
		return "Code: " + Code + " Name: " + Name + " Continent: " + Continent + " Surface Area: " + SurfaceArea + " Head of State: " + HeadOfState;
	}
        
    //inner class: Builder of the outer class Country
    public static class CountryBuilder{
        
            private String Code;
            private String Name;
            private float SurfaceArea;
            private String HeadOfState;
            private String Continent;
            
            public CountryBuilder(String Code,String Name, String Continent ){
            
            this.Code= Code;
            this.Name = Name;
            this.Continent = Continent;
            
            //default values for optional atttributes
            this.HeadOfState = null;         
            this.SurfaceArea = 0;
            }
        
          
        
        public CountryBuilder setHeadOfState (String HeadOfState){
        
        this.HeadOfState= HeadOfState;
        return this;
        } 
        
        public CountryBuilder setSurfaceArea (float SurfaceArea){
        
        this.SurfaceArea= SurfaceArea;
        return this;
        } 
        
        public Country build() {
			return new Country(this);
		}
        }
    
   

}

    
    
        

