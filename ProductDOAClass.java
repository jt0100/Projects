package com.collabera.jump.Project2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDOAClass implements ProductDOA{

	 //list is working as a database
	   List<Product> proList;



	   public ProductDOAClass(){
		  proList = new ArrayList<Product>();
	
		}
	
	   //retrieve list of Students from the database
	   @Override
	     public List <Product> getAllProducts() {
			   Connection con = ConnectionFactory.getConnection();
			    try {
			        Statement stmt = con.createStatement();
			        String query= ("select * \n" + 
			        		"FROM customer\n" + 
			        		"LEFT JOIN product\n" + 
			        		"ON customer.customer_number=product.product_code");
			        ResultSet rs = stmt.executeQuery(query);
			        List<Product> proList = new ArrayList<Product>();

			        while(rs.next())
			        {
		            	Product p = new Product();
		                p.setProduct_code(rs.getInt("product_code"));
		                p.setProduct_name(rs.getString("product_name") );
		                p.setPrice(rs.getDouble("price") );
		                p.setQuantity(rs.getInt("quantity"));
		           
			            proList.add(p);
			          
			        }
			        
			        
			        return proList;
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    }
			    return null;
			}
	   

	   @Override
	   public Product getProduct(int product_code) {
		    Connection con = ConnectionFactory.getConnection();
		        try {
		            Statement stmt = con.createStatement();
		            ResultSet rs = stmt.executeQuery("SELECT * FROM product WHERE product_code=" + product_code);
		            if(rs.next())
		            {
		            	Product p = new Product();
		                p.setProduct_code(rs.getInt("product_code"));
		                p.setProduct_name(rs.getString("product_name") );
		                p.setPrice(rs.getDouble("price") );
		                p.setQuantity(rs.getInt("quantity"));
		       
		            return p;
		            }
		        } catch (SQLException ex) {
	            ex.printStackTrace();
		        }
		    return null;
		}

	   
	   @Override
	     public Product updateProduct(Product p) {
		    Connection connection = ConnectionFactory.getConnection();
		    try {
		        PreparedStatement ps = connection.prepareStatement("UPDATE product SET quantity=1990 WHERE product_code=3");
		        ps.setString(3, p.getProduct_name());
		        ps.setDouble(2, p.getPrice());
		        ps.setInt(1, p.getQuantity());
		        ps.setInt(3, p.getProduct_code());
		   
		        int i = ps.executeUpdate();

		  
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		   return p;
		}
	   
	   @Override
	   public int deleteProduct(Product pro) {
		return 0;
	   }

}