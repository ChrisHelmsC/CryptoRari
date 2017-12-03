package com.cryptoRari.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticker {
	private String trade_id;
	private double price;
	private double size;
	private double bid;
	private double ask;
	private double volume;
	private String time;
	
	public Ticker() {};
	
	public String getTrade_id() {
		return trade_id;
	}
	public void setTrade_id(String trade_id) {
		this.trade_id = trade_id;
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
	public double getBid() {
		return bid;
	}
	public void setBid(double bid) {
		this.bid = bid;
	}
	public double getAsk() {
		return ask;
	}
	public void setAsk(double ask) {
		this.ask = ask;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "ID: " + trade_id +
				"\nPrice: " + Double.toString(price) + 
				"\nSize: " + Double.toString(size) +
				"\nBid: " + Double.toString(bid) +
				"\nAsk: " + Double.toString(ask) +
				"\nVolume: " + Double.toString(volume) +
				"\nTime: " + time; 
	}
	
}

