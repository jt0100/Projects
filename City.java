package com.collabera.jump.Project1;


public class City {

	private String name;
	private String isCapital;
	private int city_id;
	
	public City() {
	}
	
	public City(String name, String isCapital) {
		super();
		this.name = name;
		this.isCapital = isCapital;
		}

	public City(String name, String isCapital, int city_id) {
		super();
		this.name = name;
		this.isCapital = isCapital;

		this.city_id=city_id;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getisCapital() {
		return isCapital;
	}

	public void setisCapital(String isCapital) {
		this.isCapital = isCapital;
	}



	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}


	
		


}