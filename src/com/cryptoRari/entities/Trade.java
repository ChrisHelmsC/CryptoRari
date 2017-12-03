package com.cryptoRari.entities;

public class Trade {
	double price;
	String side;
	double size;
	String time;
	String trade_id;
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTrade_id() {
		return trade_id;
	}
	public void setTrade_id(String trade_id) {
		this.trade_id = trade_id;
	}
	
	public String toString() {
		return "Price: " + Double.toString(price) +
				"\nSide: " + side +
				"\nSize: " + Double.toString(size) + 
				"\nTime: " + time + 
				"\nTrade ID: " + trade_id;
	}
}
