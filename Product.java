package com.collabera.jump.Project2;

public class Product {
	private int product_code;
	private String product_name;
	private double price;
	private int quantity;
	public  Product() {
		
	}
	public Product(String product_name) {
		super();
		this.product_name = product_name;
	}
	public Product(int product_code, String product_name, double price, int quantity) {
		super();
		this.product_code = product_code;
		this.product_name = product_name;
		this.price = price;
		this.quantity = quantity;
	}
	public int getProduct_code() {
		return product_code;
	}
	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
