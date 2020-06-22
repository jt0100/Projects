package com.collabera.jump.Project1;


	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

import com.collabera.jump.DAOExample.ConnectionFactory;

	public class CountryClass implements CountryFP {

		 //list is working as a database
		   List<Country> counList;
		   List<City> cList;

		   public CountryClass(){
			  counList = new ArrayList<Country>();
			  cList = new ArrayList<City>();
			}
		
		   //retrieve list of Students from the database
		   @Override
		     public List <Country> getAllCountries() {
				   Connection con = ConnectionFactory.getConnection();
				    try {
				        Statement stmt = con.createStatement();
				        ResultSet rs = stmt.executeQuery("SELECT *\n" + 
				        		"FROM City\n" + 
				        		"Left  JOIN Country ON Country.city_id=City.city_id\n" + 
				        		"Where City.city_id=3;");
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
		     public List <City> getAllCities() {
				   Connection con = ConnectionFactory.getConnection();
				    try {
				        Statement stmt = con.createStatement();
				        ResultSet rs = stmt.executeQuery("SELECT * FROM City WHERE city_id=3");
				        List<City> counList = new ArrayList<City>();

				        while(rs.next())
				        {
				        	City s = new City();
			                s.setCity_id(rs.getInt("city_id"));
			                s.setname(rs.getString("name") );
			                s.setisCapital(rs.getString("isCapital") );
			             
				            counList.add(s);
				        }
				        
				        return counList;
				    } catch (SQLException ex) {
				        ex.printStackTrace();
				    }
				    return null;
				}

		   @Override
		   public Country getCountry(int id) {
			    Connection con = ConnectionFactory.getConnection();
			        try {
			            Statement stmt = con.createStatement();
			            ResultSet rs = stmt.executeQuery("SELECT * FROM country WHERE country_id=" + id);
			            if(rs.next())
			            {
			            	Country s = new Country();
			            	s.setCountry_id(rs.getInt("country_id"));
			                s.setCountryName(rs.getString("countryname") );
			                s.setPopulation(rs.getString("population") );
			                s.setCity_id(rs.getInt("city_id") );
			            return s;
			            }
			        } catch (SQLException ex) {
		            ex.printStackTrace();
			        }
			    return null;
			}

		   
		   @Override
		     public boolean updateCountry(Country s) {
			    Connection connection = ConnectionFactory.getConnection();
			    try {
			        PreparedStatement ps = connection.prepareStatement("UPDATE country SET countryname=?, population=? WHERE id=?");
			        ps.setString(2, s.getCountryName());
			        ps.setString(3, s.getPopulation());
			        ps.setInt(1, s.getcountry_id());
			      
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
		   public void deleteCountry(Country coun) {
		   }

	

	}




