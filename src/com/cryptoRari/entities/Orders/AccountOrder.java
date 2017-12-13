package com.cryptoRari.entities.Orders;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract  class AccountOrder {
	String client_oid;
	String type;
	String side;
	String product_id;
	String stp;
	boolean overdraft_enabled;
	double funding_amount;

	public String getClient_oid() {
		return client_oid;
	}

	public void setClient_oid(String client_oid) {
		this.client_oid = client_oid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getStp() {
		return stp;
	}

	public void setStp(String stp) {
		this.stp = stp;
	}

	public boolean isOverdraft_enabled() {
		return overdraft_enabled;
	}

	public void setOverdraft_enabled(boolean overdraft_enabled) {
		this.overdraft_enabled = overdraft_enabled;
	}

	public double getFunding_amount() {
		return funding_amount;
	}

	public void setFunding_amount(double funding_amount) {
		this.funding_amount = funding_amount;
	}
}
