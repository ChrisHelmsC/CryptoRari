package com.cryptoRari.marketData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.cryptoRari.entities.Candle;
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
	
	/**
	 * 
	 * @param productId
	 * @return ArrayList of candles
	 */
	public ArrayList<Candle> getHistoricRates(String productId) {
		final String URI = Constants.URL +
				Constants.GDAX.MarketPaths.PRODUCTS  +
				productId +
				Constants.GDAX.MarketPaths.CANDLES;
		
		System.out.println("URI being used is " + URI);
		Object[] array;
		array = restTemplate.getForObject(URI, Object[].class);
		System.out.println("ARRAY OBJECT = " + array);
		ArrayList<Candle> candleList = new ArrayList<>();
		for(int i = 0; i < 10/*array.length*/; i++) {
			Candle temp = new Candle();
			System.out.println(array[i].toString());
			Double[] doubleArray = (Double[]) array[i];
			System.out.println("tempArray = " + doubleArray);
			//temp.setTime((long) tempArray[0]);
			candleList.add(temp);
		}
//		Candle[] candleArray;
//		candleArray = restTemplate.getForObject(URI, Candle[].class);
//		List<Candle> candleList = new ArrayList<>();
//		candleList = Arrays.asList(candleArray);
		//ArrayList<Candle> candleList = new ArrayList<>(Arrays.asList(restTemplate.getForObject(URI, Candle[].class)));
		//return (ArrayList<Candle>) candleList;
		return candleList;
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

}
