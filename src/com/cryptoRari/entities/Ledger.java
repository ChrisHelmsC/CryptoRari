package com.cryptoRari.entities;

public class Ledger {
	String id;
	String created_at;
	double amount;
	double balance;
	String type;
	Details details;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Details getDetails() {
		return details;
	}
	public void setDetails(Details details) {
		this.details = details;
	}
	@Override
	public String toString() {
		return "Ledger [id=" + id + ", created_at=" + created_at + ", amount=" + amount + ", balance=" + balance
				+ ", type=" + type + ", details=" + details + "]";
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
		Ledger other = (Ledger) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	public class Details {
		
		public Details() {
			
		}
		
		String order_id;
		String trade_id;
		String product_id;
		
		public String getOrder_id() {
			return order_id;
		}
		public void setOrder_id(String order_id) {
			this.order_id = order_id;
		}
		public String getTrade_id() {
			return trade_id;
		}
		public void setTrade_id(String trade_id) {
			this.trade_id = trade_id;
		}
		public String getProduct_id() {
			return product_id;
		}
		public void setProduct_id(String product_id) {
			this.product_id = product_id;
		}
		@Override
		public String toString() {
			return "Details [order_id=" + order_id + ", trade_id=" + trade_id + ", product_id=" + product_id + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
			result = prime * result + ((product_id == null) ? 0 : product_id.hashCode());
			result = prime * result + ((trade_id == null) ? 0 : trade_id.hashCode());
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
			Details other = (Details) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (order_id == null) {
				if (other.order_id != null)
					return false;
			} else if (!order_id.equals(other.order_id))
				return false;
			if (product_id == null) {
				if (other.product_id != null)
					return false;
			} else if (!product_id.equals(other.product_id))
				return false;
			if (trade_id == null) {
				if (other.trade_id != null)
					return false;
			} else if (!trade_id.equals(other.trade_id))
				return false;
			return true;
		}
		private Ledger getOuterType() {
			return Ledger.this;
		}
	}
}
