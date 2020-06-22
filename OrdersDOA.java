package com.collabera.jump.Project2;

import java.util.List;

public interface OrdersDOA {
	public Orders getOrders(int orderNumber);
	   public List<Orders> getAllOrders();
	   public boolean updateOrder(Orders orders);
	   public int deleteOrder(Orders orders);
}
