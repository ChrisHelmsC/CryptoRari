package com.cryptoRari.marketData;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.client.RestTemplate;

import com.cryptoRari.entities.OrderBook;
import com.cryptoRari.entities.Product;
import com.cryptoRari.entities.Stats;
import com.cryptoRari.entities.Ticker;
import com.cryptoRari.entities.Trade;
import com.cryptoRari.utilities.*;

public class ProductsService {
	
	String baseURL = Constants.URL; // base URL
	
	RestTemplate restTemplate;
	
	public ProductsService() {
		restTemplate = new RestTemplate();
	}
	
	/**
	 * 
	 * @return list of all currencies and what they can be exchanged with (Product objects)
	 */
	public ArrayList<Product> getProducts() {
		final String URI = Constants.URL +
				Constants.GDAX.MarketPaths.PRODUCTS;
		
		Product[] newProducts = restTemplate.getForObject(URI, Product[].class);
		ArrayList<Product> productList = new ArrayList<>(Arrays.asList(newProducts));
		return productList;
	}
	
	/***********************************************
	 * getOrderBook()
	 * Returns latest orders for a currency
	 * 
	 * @productId - currency code for desired ticker
	 ************************************************/
	public OrderBook getOrderBook(String productId) {
		final String URI = Constants.URL +
				Constants.GDAX.MarketPaths.PRODUCTS  +
				productId +
				Constants.GDAX.MarketPaths.BOOK;
			
		RestTemplate template = new RestTemplate();
		OrderBook orderBook = template.getForObject(URI, OrderBook.class);
		
		return orderBook;
	}
	
	/***********************************************
	 * getTicker()
	 * Returns a ticker for a specific currency
	 * 
	 * @productId - currency code for desired ticker
	 ************************************************/
	public Ticker getTicker(String productId) {

		final String URI = Constants.URL +
					Constants.GDAX.MarketPaths.PRODUCTS  +
					productId +
					Constants.GDAX.MarketPaths.TICKER;
				
		RestTemplate restTemplate = new RestTemplate();
        Ticker ticker = restTemplate.getForObject(URI, Ticker.class);
        
        return ticker;
	}
	
	/***********************************************
	 * getTrades()
	 * Returns a list of the latest trades for a currency
	 * 
	 * @productId - currency code for desired ticker
	 ************************************************/
	public ArrayList<Trade> getTrades(String productId) {
		
		final String URI = Constants.URL +
				Constants.GDAX.MarketPaths.PRODUCTS  +
				productId +
				Constants.GDAX.MarketPaths.TRADES;
		
		RestTemplate template = new RestTemplate();
		Trade[] tradeList = template.getForObject(URI, Trade[].class);
		
		return new ArrayList<>(Arrays.asList(tradeList));
	}
	
	public void getHistoricRates() {
		
		
	}
	
	/***********************************************
	 * getStats()
	 * Returns statistics for a currency
	 * THIS IS ONLY FOR 24 HOUR STATS
	 * 
	 * @productId - currency code for desired ticker
	 ************************************************/
	public Stats getStats(String productId) {
		final String URI = Constants.URL +
				Constants.GDAX.MarketPaths.PRODUCTS  +
				productId +
				Constants.GDAX.MarketPaths.STATS;
		
		RestTemplate template = new RestTemplate();
		Stats stats = template.getForObject(URI, Stats.class);
		
		return stats;
	}
	
	public void getCurrencies() {
		
	}
	
	public void getTime() {
		
	}

}
