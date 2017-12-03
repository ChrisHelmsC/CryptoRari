package com.cryptoRari.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stats {
	private double high;
	private double last;
	private double low;
	private double volume;
	private double volume_30day;
	
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public double getLast() {
		return last;
	}
	public void setLast(double last) {
		this.last = last;
	}
	public double getLow() {
		return low;
	}
	public void setLow(double low) {
		this.low = low;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public double getVolume_30day() {
		return volume_30day;
	}
	public void setVolume_30day(double volume_30day) {
		this.volume_30day = volume_30day;
	}
	
	@Override
	public String toString() {
		return	"High: " + Double.toString(high) +
				"\nLast: " + Double.toString(last) +
				"\nLow: " + Double.toString(low) +
				"\nVolume: " + Double.toString(volume) +
				"\n30 Day Volume: " + Double.toString(volume_30day);
	}
}
