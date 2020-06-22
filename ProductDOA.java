package com.collabera.jump.Project2;

import java.util.List;

public interface ProductDOA {
	public Product getProduct(int product_code);
	   public List<Product> getAllProducts();
	   public Product updateProduct(Product product);
	   public int deleteProduct(Product product);
}
