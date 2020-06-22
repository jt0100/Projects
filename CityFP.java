package com.collabera.jump.Project1;

import java.util.List;



public interface CityFP {
	 public City getCity(int id);
	   public List<City> getAllCities();
	   public boolean updateCity(City city);
	   public void deleteCity(City city);
	public List<Country> getAllCountries();
}
