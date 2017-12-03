package com.cryptoRari.entities;

public class Bid {
	
	private double price;
	private double size;
	private int numorders;
	
	public Bid() {
		
	}
	public Bid(double price, double size, int numorders) {
		super();
		this.price = price;
		this.size = size;
		this.numorders = numorders;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public int getNumorders() {
		return numorders;
	}
	public void setNumorders(int numorders) {
		this.numorders = numorders;
	}
	@Override
	public String toString() {
		return "Bid [price=" + price + ", size=" + size + ", numorders=" + numorders + "]";
	}
	

}
