package com.collabera.jump.Project2;

public class Orders {
private int orderNumber;
private String customerName;
private int customerNumber;
private int productCode;
private double salesPrice;
private int orderQuantity;
public Orders() {
}
public Orders(String customerName) {
	super();
	this.customerName = customerName;
}
public Orders(int orderNumber, String customerName, int customerNumber, int productCode, double salesPrice,
		int orderQuantity) {
	super();
	this.orderNumber = orderNumber;
	this.customerName = customerName;
	this.customerNumber = customerNumber;
	this.productCode = productCode;
	this.salesPrice = salesPrice;
	this.orderQuantity = orderQuantity;
}
public int getOrderNumber() {
	return orderNumber;
}
public void setOrderNumber(int orderNumber) {
	this.orderNumber = orderNumber;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public int getCustomerNumber() {
	return customerNumber;
}
public void setCustomerNumber(int customerNumber) {
	this.customerNumber = customerNumber;
}
public int getProductCode() {
	return productCode;
}
public void setProductCode(int productCode) {
	this.productCode = productCode;
}
public double getSalesPrice() {
	return salesPrice;
}
public void setSalesPrice(double salesPrice) {
	this.salesPrice = salesPrice;
}
public int getOrderQuantity() {
	return orderQuantity;
}
public void setOrderQuantity(int orderQuantity) {
	this.orderQuantity = orderQuantity;
}


}
