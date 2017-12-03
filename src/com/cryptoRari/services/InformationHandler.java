package com.cryptoRari.services;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.client.RestTemplate;

import com.cryptoRari.entities.OrderBook;
import com.cryptoRari.entities.Product;
import com.cryptoRari.entities.Stats;
import com.cryptoRari.entities.Ticker;
import com.cryptoRari.entities.Trade;
import com.cryptoRari.utilities.Constants;


/*According to the GDAX API, the account based headers are not needed
 * for just getting public market data on currencies. 
 * 
 * Running this test allows us to grab the information for BTC-USD
 * from the server.
 */

public class InformationHandler {
	
	String baseURL = "https://api.gdax.com";
	
	URI URITemplate;
	RestTemplate restTemplate;
	
	public InformationHandler() {
		restTemplate = new RestTemplate();
		/*
		URITemplate = new URIBuilder();
		URITemplate.setScheme(Constants.HTTP.SCHEME);
		URITemplate.setHost(Constants.GDAX.SANDBOX_HOST);
		URITemplate.build();// sandbox for testing
		*/
	}
	
	public ArrayList<Product> getProducts() {
		//RestTemplate restTemplate = new RestTemplate();
		/*
		if(currency.equals("BTC")) {
			URITemplate.setPath(Constants.GDAX.MarketPaths.PRODUCTS);
		}
		URITemplate.build();
		*/
		System.out.println("HERE");
		Product[] newProducts = restTemplate.getForObject(baseURL + "/products", Product[].class);
		System.out.println(newProducts);
		System.out.println("URI being used = " + URITemplate);
		ArrayList<Product> productList = new ArrayList<>(Arrays.asList(newProducts));
		return productList;
	}
	
	/***********************************************
	 * getTicker()
	 * Returns a ticker for a specific currency
	 * 
	 * @productId - currency code for desired ticker
	 ************************************************/
	public Ticker getTicker(String productId) {

		final String URI = Constants.HTTP.SCHEME +
					Constants.GDAX.HOST +
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
		
		final String URI = Constants.HTTP.SCHEME +
				Constants.GDAX.HOST +
				Constants.GDAX.MarketPaths.PRODUCTS  +
				productId +
				Constants.GDAX.MarketPaths.TRADES;
		
		RestTemplate template = new RestTemplate();
		Trade[] tradeList = template.getForObject(URI, Trade[].class);
		
		return new ArrayList<>(Arrays.asList(tradeList));
	}
	
	/***********************************************
	 * getStats()
	 * Returns statistics for a currency
	 * 
	 * @productId - currency code for desired ticker
	 ************************************************/
	public Stats getStats(String productId) {
		final String URI = Constants.HTTP.SCHEME +
				Constants.GDAX.HOST +
				Constants.GDAX.MarketPaths.PRODUCTS  +
				productId +
				Constants.GDAX.MarketPaths.STATS;
		
		RestTemplate template = new RestTemplate();
		Stats stats = template.getForObject(URI, Stats.class);
		
		return stats;
	}
	
	/***********************************************
	 * getOrderBook()
	 * Returns latest orders for a currency
	 * 
	 * @productId - currency code for desired ticker
	 ************************************************/
	public OrderBook getOrderBook(String productId) {
		final String URI = Constants.HTTP.SCHEME +
				Constants.GDAX.HOST +
				Constants.GDAX.MarketPaths.PRODUCTS  +
				productId +
				Constants.GDAX.MarketPaths.BOOK;
			
		RestTemplate template = new RestTemplate();
		OrderBook orderBook = template.getForObject(URI, OrderBook.class);
		
		return orderBook;
	}
}
