package com.cryptoRari.entities;

public class GDAXTime {
	String epoch;
	String ISO;
	
	public GDAXTime() {
		
	}

	public String getEpoch() {
		return epoch;
	}

	public void setEpoch(String epoch) {
		this.epoch = epoch;
	}

	public String getISO() {
		return ISO;
	}

	public void setISO(String iSO) {
		ISO = iSO;
	}

	@Override
	public String toString() {
		return "GDAXTime [epoch=" + epoch + ", ISO=" + ISO + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ISO == null) ? 0 : ISO.hashCode());
		result = prime * result + ((epoch == null) ? 0 : epoch.hashCode());
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
		GDAXTime other = (GDAXTime) obj;
		if (ISO == null) {
			if (other.ISO != null)
				return false;
		} else if (!ISO.equals(other.ISO))
			return false;
		if (epoch == null) {
			if (other.epoch != null)
				return false;
		} else if (!epoch.equals(other.epoch))
			return false;
		return true;
	}
	
	
}
