package com.cryptoRari.entities;

public class OrderResponse {
	String id;
	double price;
	double size;
	String product_id;
	String side;
	String stp;
	String type;
	String time_in_force;
	boolean post_only;
	String created_at;
	double fill_fees;
	double filled_size;
	double executed_value;
	String status;
	boolean settled;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	public String getStp() {
		return stp;
	}
	public void setStp(String stp) {
		this.stp = stp;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTime_in_force() {
		return time_in_force;
	}
	public void setTime_in_force(String time_in_force) {
		this.time_in_force = time_in_force;
	}
	public boolean isPost_only() {
		return post_only;
	}
	public void setPost_only(boolean post_only) {
		this.post_only = post_only;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public double getFill_fees() {
		return fill_fees;
	}
	public void setFill_fees(double fill_fees) {
		this.fill_fees = fill_fees;
	}
	public double getFilled_size() {
		return filled_size;
	}
	public void setFilled_size(double filled_size) {
		this.filled_size = filled_size;
	}
	public double getExecuted_value() {
		return executed_value;
	}
	public void setExecuted_value(double executed_value) {
		this.executed_value = executed_value;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isSettled() {
		return settled;
	}
	public void setSettled(boolean settled) {
		this.settled = settled;
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
		OrderResponse other = (OrderResponse) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OrderResponse [id=" + id + ", price=" + price + ", size=" + size + ", product_id=" + product_id
				+ ", side=" + side + ", stp=" + stp + ", type=" + type + ", time_in_force=" + time_in_force
				+ ", post_only=" + post_only + ", created_at=" + created_at + ", fill_fees=" + fill_fees
				+ ", filled_size=" + filled_size + ", executed_value=" + executed_value + ", status=" + status
				+ ", settled=" + settled + "]";
	}
	
	
}
