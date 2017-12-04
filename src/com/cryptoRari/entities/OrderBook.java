package com.cryptoRari.entities;

import java.util.ArrayList;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class OrderBook {
	
	private double sequence;
	private Bid[] bids;
	private Ask[] asks;
	
	public OrderBook(double sequence, Bid[] bids, Ask[] asks) {
		super();
		this.sequence = sequence;
		this.bids = bids;
		this.asks = asks;
	}
	
	public OrderBook() {
		
	}

	public double getSequence() {
		return sequence;
	}

	public void setSequence(double sequence) {
		this.sequence = sequence;
	}

	public Bid[] getBids() {
		return bids;
	}

	public void setBids(Bid[] bids) {
		this.bids = bids;
	}

	public Ask[] getAsks() {
		return asks;
	}

	public void setAsks(Ask[] asks) {
		this.asks = asks;
	}

	@Override
	public String toString() {
		return "OrderBook [sequence=" + sequence + ", bids=" + Arrays.toString(bids) + ", asks=" + Arrays.toString(asks)
				+ "]";
	}
	
	
	
}
