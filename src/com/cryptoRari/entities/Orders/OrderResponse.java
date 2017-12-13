package com.cryptoRari.entities.Orders;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderResponse {
	String id;
	String price;
	String size;
	String product_id;
	String side;
	String stp;
	String type;
	String time_in_force;
	boolean post_only;
	String created_at;
	String fill_fees;
	String filled_size;
	String executed_value;
	String status;
	String funds;
	boolean settled;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFunds() {
		return funds;
	}

	public void setFunds(String funds) {
		this.funds = funds;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
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

	public String getFill_fees() {
		return fill_fees;
	}

	public void setFill_fees(String fill_fees) {
		this.fill_fees = fill_fees;
	}

	public String getFilled_size() {
		return filled_size;
	}

	public void setFilled_size(String filled_size) {
		this.filled_size = filled_size;
	}

	public String getExecuted_value() {
		return executed_value;
	}

	public void setExecuted_value(String executed_value) {
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		OrderResponse that = (OrderResponse) o;
		return post_only == that.post_only &&
				settled == that.settled &&
				Objects.equals(id, that.id) &&
				Objects.equals(price, that.price) &&
				Objects.equals(size, that.size) &&
				Objects.equals(product_id, that.product_id) &&
				Objects.equals(side, that.side) &&
				Objects.equals(stp, that.stp) &&
				Objects.equals(type, that.type) &&
				Objects.equals(time_in_force, that.time_in_force) &&
				Objects.equals(created_at, that.created_at) &&
				Objects.equals(fill_fees, that.fill_fees) &&
				Objects.equals(filled_size, that.filled_size) &&
				Objects.equals(executed_value, that.executed_value) &&
				Objects.equals(status, that.status);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, price, size, product_id, side, stp, type, time_in_force, post_only, created_at, fill_fees, filled_size, executed_value, status, settled);
	}

	@Override
	public String toString() {
		return "OrderResponse{" +
				"id='" + id + '\'' +
				", price='" + price + '\'' +
				", size='" + size + '\'' +
				", product_id='" + product_id + '\'' +
				", side='" + side + '\'' +
				", stp='" + stp + '\'' +
				", type='" + type + '\'' +
				", time_in_force='" + time_in_force + '\'' +
				", post_only=" + post_only +
				", created_at='" + created_at + '\'' +
				", fill_fees='" + fill_fees + '\'' +
				", filled_size='" + filled_size + '\'' +
				", executed_value='" + executed_value + '\'' +
				", status='" + status + '\'' +
				", settled=" + settled +
				'}';
	}
}
