package com.collabera.jump.Project2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrdersDOAClass implements OrdersDOA {

	 //list is working as a database
	   List<Orders> orList;
	   
	   public OrdersDOAClass(){
		  orList = new ArrayList<Orders>();
		}
	
	   //retrieve list of Students from the database
	   @Override
	     public List <Orders> getAllOrders() {
			   Connection con = ConnectionFactory.getConnection();
			    try {
			        Statement stmt = con.createStatement();
			        ResultSet rs = stmt.executeQuery("select * FROM `order`");
			        List<Orders> orList = new ArrayList<Orders>();

			        while(rs.next())
			        {
		            	Orders o = new Orders();
		                o.setOrderNumber(rs.getInt("orderNumber"));
		                o.setCustomerName(rs.getString("customerName") );
		                o.setCustomerNumber(rs.getInt("customerNumber") );
		                o.setProductCode(rs.getInt("productCode"));
		                o.setSalesPrice(rs.getDouble("salesPrice"));
		                o.setOrderQuantity(rs.getInt("orderQuantity"));
		           
			            orList.add(o);
			        }
			        
			        return orList;
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    }
			    return null;
			}
	   

	   @Override
	   public Orders getOrders(int orderNumber) {
		    Connection con = ConnectionFactory.getConnection();
		        try {
		            Statement stmt = con.createStatement();
		            ResultSet rs = stmt.executeQuery("SELECT * FROM order WHERE orderNumber=" + orderNumber);
		            if(rs.next())
		            {
		            	Orders o = new Orders();
		            	o.setOrderNumber(rs.getInt("orderNumber"));
		                o.setCustomerName(rs.getString("customerName") );
		                o.setCustomerNumber(rs.getInt("customerNumber") );
		                o.setProductCode(rs.getInt("productCode"));
		                o.setSalesPrice(rs.getDouble("salesPrice"));
		                o.setOrderQuantity(rs.getInt("orderQuantity"));
		            
		            return o;
		            }
		        } catch (SQLException ex) {
	            ex.printStackTrace();
		        }
		    return null;
		}

	   
	   @Override
	     public boolean updateOrder(Orders p) {
		    Connection connection = ConnectionFactory.getConnection();
		    try {
		        PreparedStatement ps = connection.prepareStatement("UPDATE order SET customerName=?, customerNumber=?, "
		        		+ "productCode=?, salesPrice=?, orderQuantity=?  WHERE orderNumber=?");
		        ps.setString(3, p.getCustomerName());
		        ps.setInt(2, p.getCustomerNumber());
		        ps.setInt(1, p.getProductCode());
		        ps.setDouble(3, p.getSalesPrice());
		        ps.setInt(1,p.getOrderQuantity());
		        ps.setInt(2,p.getOrderNumber());

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
	   public int deleteOrder(Orders or) {
		    Connection connection = ConnectionFactory.getConnection();
		    try {
				Statement stmt = connection.createStatement();
			    String sql = "delete from `order` WHERE `productCode`=142";
			    stmt.executeUpdate(sql);
			    
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
return 0;
	   }

}


