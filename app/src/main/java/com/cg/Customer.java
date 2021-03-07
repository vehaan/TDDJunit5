package com.cg;

public class Customer {
	private String id;
	private String name;
	private int loyaltyDiscount;
	public Customer(String id, String name, int loyaltyDiscount) {
		super();
		this.id = id;
		this.name = name;
		this.loyaltyDiscount = loyaltyDiscount;
	}
	public Customer() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLoyaltyDiscount() {
		return loyaltyDiscount;
	}
	public void setLoyaltyDiscount(int loyaltyDiscount) {
		this.loyaltyDiscount = loyaltyDiscount;
	}
	
	

}
