package com.collabera.jump.Project1;


public class Country {

	private String countryname;
	private String population;
	private int country_id;
	private int city_id;
	
	public Country() {
	}
	
	public Country(String countryname, String population) {
		super();
		this.countryname = countryname;
		this.population = population;
		}

	public Country(String firstname, String lastname, int country_id, int city_id) {
		super();
		this.countryname = firstname;
		this.population = lastname;
		this.country_id = country_id;
		this.city_id=city_id;
	}

	public String getCountryName() {
		return countryname;
	}

	public void setCountryName(String countryname) {
		this.countryname = countryname;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public int getcountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}


	
		


}
