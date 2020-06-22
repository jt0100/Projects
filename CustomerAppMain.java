package com.collabera.jump.Project2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.collabera.jump.DAOExample.ConnectionFactory;

public class CustomerAppMain {

	public static void main(String[] args) {
		
		CustomerDOAClass CUSDOA = new CustomerDOAClass();
		ProductDOAClass ProDOA = new ProductDOAClass();
		  

 		
 		
		Connection con = ConnectionFactory.getConnection();
		   Statement stmt = null;      
 	try {
 		
 		
 		 stmt = con.createStatement();
 	    String sql = "select * \n" + 
 	    		"FROM `customer`\n" + 
 	    		"Inner JOIN `product`\n" + 
 	    		"ON `customer`.customer_number=`product`.product_code;";
 	    ResultSet rs = stmt.executeQuery(sql);

 	    while(rs.next()){
 	 	   int number  = rs.getInt("customer_number");
 	       String name = rs.getString("customer_name");
 	       String address = rs.getString("Address");
 	       String city = rs.getString("City");
 	       String Country = rs.getString("Country");
 	       int code = rs.getInt("product_code");
 	       String Pname = rs.getString("product_name");
 	       Double price = rs.getDouble("price");
 	       int quantity = rs.getInt("quantity");
 	 	

	         System.out.println("Customer: [Number : "+number+", Name : "+name 
   		 + "   , Address : "+address + "   , City : "+city+"   , Country : "+Country+"Product: [Code : "+code+", Product Name : "+Pname 
	        		 + "   , Price : "+price + "   , Quantity : "+quantity+" ]");
 	    	
 	    	
 	    	
 	    }
 	    
 	 	 rs.close();


 	
 	}
	        	
	     	     

 	
	      //print all Students
	 catch(SQLException se){
	    //Handle errors for JDBC
	    se.printStackTrace();
	 }catch(Exception e){
	    //Handle errors for Class.forName
	    e.printStackTrace();
	 }finally{
	    //finally block used to close resources
	    try{
	       if(stmt!=null)
	          con.close();
	    }catch(SQLException se){
	    }// do nothing
	    try{
	       if(con!=null)
	          con.close();
	    }catch(SQLException se){
	       se.printStackTrace();
	    }//end finally try
	 }//end try
		     System.out.println("\n");

	    	 System.out.println("Deleted Product :");
	}

}
