package com.collabera.jump.Project2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.collabera.jump.DAOExample.ConnectionFactory;

public class CustApp3 {

	public static void main(String[] args) {
		
		CustomerDOAClass CUSDOA = new CustomerDOAClass();
		ProductDOAClass ProDOA = new ProductDOAClass();
 
 		
 		
		Connection con = ConnectionFactory.getConnection();
		   Statement stmt = null;      
 	try {
 		
 		
 		 stmt = con.createStatement();
	    	 String sql = "delete from `order` WHERE `productCode`=1";

 	    stmt.executeUpdate(sql);

 	

 	 	   

 	 	    // Now you can extract all the records
 	 	    // to see the updated records
 	 	    sql = "select * \n" + 
 	 	    		"FROM `order`" ;
	 	    ResultSet rs = stmt.executeQuery(sql);

 	 	   while(rs.next()){
 	 		 int number  = rs.getInt("orderNumber");
 	        String name = rs.getString("customerName");
 	        int Cnumber = rs.getInt("customerNumber");
 	        int Pcode = rs.getInt("productCode");
 	        Double price = rs.getDouble("salesPrice");
 	        int quantity = rs.getInt("orderQuantity");

 	        //Display values
 	        System.out.print("Order Number: " + number+" ");
 	        System.out.print(", Name: " + name+" ");
 	        System.out.print(", Custumer Number: " + Cnumber+" ");
 	        System.out.print(", Code: " + Pcode+" ");
 	        System.out.print(", Price: " + price+" ");
 	        System.out.println(", Quantity: " + quantity);
 	    	
 	    	
 	    	
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
