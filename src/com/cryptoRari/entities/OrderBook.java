package com.cryptoRari.entities;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderBook {
	public static final String BID_ORDER = "BID";
	public static final String ASK_ORDER = "ASK";
	private Order asks;
	private Order bids;
	private String sequence;
	
	public Order getAsks() {
		return asks;
	}

	public void setAsks(ArrayList<Double> values) {
		this.asks = new Order(values);
		this.asks.setOrderType(ASK_ORDER);
	}

	public Order getBids() {
		return bids;
	}

	public void setBids(ArrayList<Double> values) {
		this.bids = new Order(values);
		this.bids.setOrderType(BID_ORDER);
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	private class Order {
		private String orderType;
		private double price;
		private double size;
		private double numOrders;
		
		public Order(ArrayList<Double> values) {
			this.price = (double) values.get(0); 
			this.size = (double) values.get(1);
			this.numOrders = (double) values.get(2);
		}

		public String getOrderType() {
			return orderType;
		}

		public void setOrderType(String orderType) {
			this.orderType = orderType;
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

		public double getNumOrders() {
			return numOrders;
		}

		public void setNumOrders(double numOrders) {
			this.numOrders = numOrders;
		}
		
		@Override
		public String toString() {
			return "Order Type: " + orderType +
					"\nPrice: " + Double.toString(price) +
					"\nSize: " + Double.toString(size) +
					"\n Num Orders: " + Double.toString(numOrders);
		}
	}

	@Override
	public String toString() {
		return asks.toString() +
				"\n" +
				bids.toString() +
				"\nSequence: " + sequence;
	}
}
