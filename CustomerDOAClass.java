package com.collabera.jump.Project2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDOAClass implements CustomerDOA {

	 //list is working as a database
	   List<Customer> cusList;
	   
	   public CustomerDOAClass(){
		  cusList = new ArrayList<Customer>();
		}
	
	   //retrieve list of Students from the database
	   @Override
	     public List <Customer> getAllCustomers() {
			   Connection con = ConnectionFactory.getConnection();
			    try {
			        Statement stmt = con.createStatement();
			        ResultSet rs = stmt.executeQuery("select * \n" + 
			        		"FROM `customer`\n" + 
			        		"Inner JOIN `product`\n" + 
			        		"ON `customer`.customer_number=`product`.product_code;");
			        List<Customer> cusList = new ArrayList<Customer>();

			        while(rs.next())
			        {
		            	Customer c = new Customer();
		                c.setCustomer_number(rs.getInt("customer_number"));
		                c.setCustomer_name(rs.getString("customer_name") );
		                c.setAddress(rs.getString("Address") );
		                c.setCity(rs.getString("City"));
		                c.setCountry(rs.getString("Country") );
			            cusList.add(c);

			        }
			        
			        return cusList;
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    }

			    return null;
			}
	   

	   @Override
	   public Customer getCustomer(int customer_number) {
		    Connection con = ConnectionFactory.getConnection();
		        try {
		            Statement stmt = con.createStatement();
		            ResultSet rs = stmt.executeQuery("SELECT * FROM customer WHERE customer_number=" + customer_number);
		            if(rs.next())
		            {
		            	Customer c = new Customer();
		                c.setCustomer_number(rs.getInt("customer_number"));
		                c.setCustomer_name(rs.getString("customer_name") );
		                c.setAddress(rs.getString("Address") );
		                c.setCity(rs.getString("City"));
		                c.setCountry(rs.getString("Country") );
		            return c;
		            }
		        } catch (SQLException ex) {
	            ex.printStackTrace();
		        }
		    return null;
		}

	   
	   @Override
	     public int updateCustomer(Customer c) {
		    Connection connection = ConnectionFactory.getConnection();
		    try {
		        PreparedStatement ps = connection.prepareStatement("UPDATE customer SET customer_name=?, Address=?, "
		        		+ "City=?, Country=? WHERE customer_number=?");
		        ps.setString(3, c.getCustomer_name());
		        ps.setInt(2, c.getCustomer_number());
		        ps.setString(1, c.getAddress());
		        ps.setString(3, c.getCity());
		        ps.setString(1, c.getCountry());
		        ps.setInt(2, c.getCustomer_number());
				
		        int i = ps.executeUpdate();

		
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
			return 0;
		   
		
		}
	   
	   @Override
	   public void deleteCustomer(Customer cus) {

	   }

}


