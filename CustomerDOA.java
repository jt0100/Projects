package com.collabera.jump.Project2;

import java.util.List;

public interface CustomerDOA {
	 public Customer getCustomer(int customer_number);
	   public List<Customer> getAllCustomers();
	   public int updateCustomer(Customer customer);
	   public void deleteCustomer(Customer customer);

}
