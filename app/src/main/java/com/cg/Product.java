package com.cg;

public class Product {
	private String id;
	private int discount;
	private double price;
	public Product(String id, int discount, double price) {
		super();
		this.id = id;
		this.discount = discount;
		this.price = price;
	}
	public Product() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
