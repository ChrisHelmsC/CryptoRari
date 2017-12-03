package com.cryptoRari.entities;

public class Currency {

	String id;
	String name;
	double min_size;
	
	public Currency() {
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getMin_size() {
		return min_size;
	}
	
	public void setMin_size(double min_size) {
		this.min_size = min_size;
	}
	
	@Override
	public String toString() {
		return "ID: " + id +
				"\nName: " + name +
				"\nMin Size: " + Double.toString(min_size);
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
		Currency other = (Currency) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
