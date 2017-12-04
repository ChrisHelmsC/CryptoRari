package com.cryptoRari.entities;

public class Candle {
	
	private long time;
	private double low;
	private double high;
	private double open;
	private double close;
	private double volume;
	public Candle(long time, double low, double high, double open, double close, double volume) {
		super();
		this.time = time;
		this.low = low;
		this.high = high;
		this.open = open;
		this.close = close;
		this.volume = volume;
	}
	
	
	public Candle() {
		
	}
	
	

	public double getOpen() {
		return open;
	}


	public void setOpen(double open) {
		this.open = open;
	}


	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getClose() {
		return close;
	}

	public void setClose(double close) {
		this.close = close;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}
	
	

	@Override
	public String toString() {
		return "Candle [time=" + time + ", low=" + low + ", high=" + high + ", open=" + open + ", close=" + close
				+ ", volume=" + volume + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(close);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(high);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(low);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (time ^ (time >>> 32));
		temp = Double.doubleToLongBits(volume);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Candle other = (Candle) obj;
		if (Double.doubleToLongBits(close) != Double.doubleToLongBits(other.close))
			return false;
		if (Double.doubleToLongBits(high) != Double.doubleToLongBits(other.high))
			return false;
		if (Double.doubleToLongBits(low) != Double.doubleToLongBits(other.low))
			return false;
		if (time != other.time)
			return false;
		if (Double.doubleToLongBits(volume) != Double.doubleToLongBits(other.volume))
			return false;
		return true;
	}
	
	

}
