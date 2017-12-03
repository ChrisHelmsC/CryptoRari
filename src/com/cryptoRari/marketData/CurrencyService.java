package com.cryptoRari.marketData;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.client.RestTemplate;

import com.cryptoRari.entities.Currency;
import com.cryptoRari.utilities.Constants;

public class CurrencyService {
	
	RestTemplate restTemplate;
	
	public CurrencyService() {
		this.restTemplate = new RestTemplate();
	}
	
	/***********************************************
	 * getCurrencies()
	 * 
	 * Returns list of known currencies
	 ************************************************/
	public ArrayList<Currency> getCurrencies() {
		String URI = Constants.URL +
						Constants.GDAX.MarketPaths.CURRENCIES;
		
		Currency[] currencyArray = this.restTemplate.getForObject(URI, Currency[].class);
		
		return new ArrayList<Currency>(Arrays.asList(currencyArray));
	}
}
