package com.cryptoRari.entities;

public class Ask {
	
	private double price;
	private double size;
	private int numorders;
	
	public Ask() {
		
	}
	public Ask(double price, double size, int numorders) {
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
		return "Ask [price=" + price + ", size=" + size + ", numorders=" + numorders + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numorders;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(size);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ask other = (Ask) obj;
		if (numorders != other.numorders)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (Double.doubleToLongBits(size) != Double.doubleToLongBits(other.size))
			return false;
		return true;
	}
	
	

}
