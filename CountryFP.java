package com.collabera.jump.Project1;

import java.util.List;



public interface CountryFP {
	 public Country getCountry(int id);
	   public List<Country> getAllCountries();
	   public boolean updateCountry(Country country);
	   public void deleteCountry(Country country);
	public List<City> getAllCities();
}
