package com.collabera.jump.Project1;


	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

import com.collabera.jump.DAOExample.ConnectionFactory;

	public class CityClass implements CityFP {

		 //list is working as a database
		   List<City> cityList;

		   public CityClass(){
			  cityList = new ArrayList<City>();
			}
		
		   //retrieve list of Students from the database
		   @Override
		     public List <City> getAllCities() {
				   Connection con = ConnectionFactory.getConnection();
				    try {
				        Statement stmt = con.createStatement();
				        ResultSet rs = stmt.executeQuery("SELECT * FROM City WHERE isCapital='Y'");
				        List<City> cityList = new ArrayList<City>();

				        while(rs.next())
				        {
				        	City s = new City();
			                s.setCity_id(rs.getInt("city_id"));
			                s.setname(rs.getString("name") );
			                s.setisCapital(rs.getString("isCapital") );
			             
				            cityList.add(s);
				        }
				       
				        return cityList;
				    } catch (SQLException ex) {
				        ex.printStackTrace();
				    }
				    return null;
				}
		   public List <Country> getAllCountries() {
			   Connection con = ConnectionFactory.getConnection();
			    try {
			        Statement stmt = con.createStatement();
			        ResultSet rs = stmt.executeQuery("SELECT *\n" + 
			        		"FROM City\n" + 
			        		"Left  JOIN Country ON Country.city_id=City.city_id\n" + 
			        		"Where City.isCapital=	'Y';");
			        List<Country> counList = new ArrayList<Country>();

			        while(rs.next())
			        {
			        	Country s = new Country();
		                s.setCountry_id(rs.getInt("country_id"));
		                s.setCountryName(rs.getString("countryname") );
		                s.setPopulation(rs.getString("population") );
		                s.setCity_id(rs.getInt("city_id") );
		             
			            counList.add(s);
			        }
			        
			        return counList;
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    }
			    return null;
			}
		   

		   @Override
		   public City getCity(int id) {
			    Connection con = ConnectionFactory.getConnection();
			        try {
			            Statement stmt = con.createStatement();
			            ResultSet rs = stmt.executeQuery("SELECT * FROM City WHERE City_id=" + id);
			            if(rs.next())
			            {
			            	City s = new City();
			            	s.setCity_id(rs.getInt("city_id"));
			                s.setname(rs.getString("name") );
			                s.setisCapital(rs.getString("isCapital") );
			            
			            return s;
			            }
			        } catch (SQLException ex) {
		            ex.printStackTrace();
			        }
			    return null;
			}

		   
		   @Override
		     public boolean updateCity(City s) {
			    Connection connection = ConnectionFactory.getConnection();
			    try {
			        PreparedStatement ps = connection.prepareStatement("UPDATE City SET name=?, isCapital=? WHERE id=?");
			        ps.setString(2, s.getname());
			        ps.setString(3, s.getisCapital());
			        ps.setInt(1, s.getCity_id());
			      
			        int i = ps.executeUpdate();

			      if(i == 1) {
			    	  return true;
			      }
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    }
			   
			    return false;
			}
		   
		   @Override
		   public void deleteCity(City city) {
		   }

	

	}




