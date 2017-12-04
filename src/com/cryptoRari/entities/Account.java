package com.cryptoRari.entities;

public class Account {
	private String id;
	private String currency;
	private double balance;
	private double available;
	private double hold;
	private String profile_id;
	
	public Account() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAvailable() {
		return available;
	}

	public void setAvailable(double available) {
		this.available = available;
	}

	public double getHold() {
		return hold;
	}

	public void setHold(double hold) {
		this.hold = hold;
	}

	public String getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(String profile_id) {
		this.profile_id = profile_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Account other = (Account) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", currency=" + currency + ", balance=" + balance + ", available=" + available
				+ ", hold=" + hold + ", profile_id=" + profile_id + "]";
	}
	
	
}
