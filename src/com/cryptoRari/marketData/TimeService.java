package com.cryptoRari.marketData;

import org.springframework.web.client.RestTemplate;
import com.cryptoRari.entities.GDAXTime;
import com.cryptoRari.utilities.Constants;

public class TimeService {
	
	private RestTemplate restTemplate;
	
	public TimeService() {
		this.restTemplate = new RestTemplate();
	}
	
	/***********************************************
	 * getTime()
	 * 
	 * Returns current GDAX server time in epoch and
	 * ISO860 formats
	 ************************************************/
	public GDAXTime getTime() {
		String URI = Constants.URL +
						Constants.GDAX.MarketPaths.TIME;		
		
		GDAXTime gdaxTime = restTemplate.getForObject(URI, GDAXTime.class);
		return gdaxTime;
	}
}
