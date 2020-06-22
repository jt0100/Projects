package com.collabera.jump.Project1;



public class WorldMain {

	public static void main(String[] args) {
		  CountryFP Country = new CountryClass();
		  CountryFP City = new CountryClass();
		CityFP Country1 = new CityClass();
		CityFP City1 = new CityClass();
	      //print all Students
	     for (Country c : Country.getAllCountries()) {
	         System.out.println("Country [Id : "+c.getcountry_id()+",  Name : "+c.getCountryName() 
	        		 + "   , Population : "+c.getPopulation() + " , City Id: " +c.getCity_id()+" ]");
	         
	      }
	     for (City a:City.getAllCities()) {
        	 System.out.println("City: [Name : "+a.getname() 
    		 + "   , Is Capital : "+a.getisCapital() + " , CityID: " +a.getCity_id()+" ]\n");
         }
	     for (Country c : Country1.getAllCountries()) {
	         System.out.println("Country [Id : "+c.getcountry_id()+",  Name : "+c.getCountryName() 
	        		 + "   , Population : "+c.getPopulation() + " , City Id: " +c.getCity_id()+" ]");
	         
	      }
	     for (City a:City1.getAllCities()) {
        	 System.out.println("\nCity: [Name : "+a.getname() 
    		 + "   , Is Capital : "+a.getisCapital() + " , CityID: " +a.getCity_id()+" ]");
         }
	    
	}
	}

