package com.cryptoRari.marketData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.cryptoRari.entities.Ask;
import com.cryptoRari.entities.Bid;
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
		final String URI = Constants.HTTP.SCHEME +
				Constants.GDAX.HOST +
				Constants.GDAX.MarketPaths.PRODUCTS;
		
		Product[] newProducts = restTemplate.getForObject(URI, Product[].class);
		ArrayList<Product> productList = new ArrayList<>(Arrays.asList(newProducts));
		return productList;
	}
	
	/***********************************************
	 * getOrderBookLvl1()
	 * Returns latest orders for a currency only the closest asks and bids
	 * 
	 * @productId - currency code for desired ticker
	 ************************************************/
	public ArrayList<OrderBook> getOrderBookLvl1(String productId) {
		final String URI = Constants.HTTP.SCHEME +
				Constants.GDAX.HOST +
				Constants.GDAX.MarketPaths.PRODUCTS  +
				productId +
				Constants.GDAX.MarketPaths.BOOKLVL1;
		
			
		System.out.println("URI being used is " + URI);
		
		Object orderBookObject = restTemplate.getForObject(URI, Object.class);
		
		System.out.println("orderBookObject = " + orderBookObject);
		
		String objectString = orderBookObject.toString();
		
		String[] stringArray = objectString.substring(1, objectString.length() - 1).split(",");
		
		String sequence = stringArray[0];
		sequence = sequence.substring(9, sequence.length());
		System.out.println("sequence = " + sequence);
		
		String bidPrice = stringArray[1].toString();
		bidPrice = bidPrice.substring(8, bidPrice.length());
		System.out.println("bidPrice = " + bidPrice);
		
		String bidSize = stringArray[2].toString();
		System.out.println("bidSize = " + bidSize);
		
		String bidNumOrders = stringArray[3].toString();
		bidNumOrders = bidNumOrders.substring(1,  bidNumOrders.length() - 2);
		System.out.println("bidNumOrders = " + bidNumOrders);
		
		String askPrice = stringArray[4].toString();
		askPrice = askPrice.substring(8, askPrice.length());
		System.out.println("askPrice = " + askPrice);
		
		String askSize = stringArray[5].toString();
		System.out.println("askSize = " + askSize);
		
		String askNumOrders = stringArray[6].toString();
		askNumOrders = askNumOrders.substring(1,  askNumOrders.length() - 2);
		System.out.println("askNumOrders = " + askNumOrders);
		
		OrderBook tempOrderBook = new OrderBook();
		tempOrderBook.setSequence(Double.parseDouble(sequence));
		
		Bid tempBid = new Bid(Double.parseDouble(bidPrice),
								Double.parseDouble(bidSize),
								Integer.parseInt(bidNumOrders));
		
		Bid[] tempBidArray = new Bid[1];
		tempBidArray[0] = tempBid;
		tempOrderBook.setBids(tempBidArray);
		
		Ask tempAsk = new Ask(Double.parseDouble(askPrice),
								Double.parseDouble(askSize),
								Integer.parseInt(askNumOrders));
		Ask[] tempAskArray = new Ask[1];
		tempAskArray[0] = tempAsk;
		tempOrderBook.setAsks(tempAskArray);
		
		ArrayList<OrderBook> orderBookList = new ArrayList<>();
		orderBookList.add(tempOrderBook);
		
		return orderBookList;
		
		
		
	}
	
	/***********************************************
	 * getOrderBookLvl2()
	 * Returns nearest 50 asks and bids
	 * 
	 * @productId - currency code for desired ticker
	 ************************************************/
	public ArrayList<OrderBook> getOrderBookLvl2(String productId) {
		final String URI = Constants.HTTP.SCHEME +
				Constants.GDAX.HOST +
				Constants.GDAX.MarketPaths.PRODUCTS  +
				productId +
				Constants.GDAX.MarketPaths.BOOKLVL2;
		
			
		System.out.println("URI being used is " + URI);
		
		Object orderBookObject = restTemplate.getForObject(URI, Object.class);
		
		System.out.println("orderBookObject = " + orderBookObject);
		
		String objectString = orderBookObject.toString();
		
		String[] stringArray = objectString.substring(1, objectString.length() - 1).split(",");
		
		String sequence = stringArray[0];
		sequence = sequence.substring(9, sequence.length());
		System.out.println("sequence = " + sequence);
		
		for(int i = 1; i < stringArray.length; i++) {
			System.out.println("stringArray[" + i + "] = " + stringArray[i]);
		
			int selector = i%3;
			
		switch(selector) {
		case 0:  
		}
			 
		}
		
		
		/*
		
		String bidPrice = stringArray[1].toString();
		bidPrice = bidPrice.substring(8, bidPrice.length());
		System.out.println("bidPrice = " + bidPrice);
		
		String bidSize = stringArray[2].toString();
		System.out.println("bidSize = " + bidSize);
		
		String bidNumOrders = stringArray[3].toString();
		bidNumOrders = bidNumOrders.substring(1,  bidNumOrders.length() - 2);
		System.out.println("bidNumOrders = " + bidNumOrders);
		
		String askPrice = stringArray[4].toString();
		askPrice = askPrice.substring(8, askPrice.length());
		System.out.println("askPrice = " + askPrice);
		
		String askSize = stringArray[5].toString();
		System.out.println("askSize = " + askSize);
		
		String askNumOrders = stringArray[6].toString();
		askNumOrders = askNumOrders.substring(1,  askNumOrders.length() - 2);
		System.out.println("askNumOrders = " + askNumOrders);
		
		OrderBook tempOrderBook = new OrderBook();
		tempOrderBook.setSequence(Double.parseDouble(sequence));
		
		Bid tempBid = new Bid(Double.parseDouble(bidPrice),
								Double.parseDouble(bidSize),
								Integer.parseInt(bidNumOrders));
		
		Bid[] tempBidArray = new Bid[1];
		tempBidArray[0] = tempBid;
		tempOrderBook.setBids(tempBidArray);
		
		Ask tempAsk = new Ask(Double.parseDouble(askPrice),
								Double.parseDouble(askSize),
								Integer.parseInt(askNumOrders));
		Ask[] tempAskArray = new Ask[1];
		tempAskArray[0] = tempAsk;
		tempOrderBook.setAsks(tempAskArray);
		
		ArrayList<OrderBook> orderBookList = new ArrayList<>();
		orderBookList.add(tempOrderBook);
		
		return orderBookList;
		*/
		
		return null;
	
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
	
	/**
	 * 
	 * @param productId
	 * @return ArrayList of candles
	 * 
	 * I think this method is currently returning one too many candles, one empty one
	 */
	public ArrayList<Candle> getHistoricRates(String productId) {
		final String URI = Constants.HTTP.SCHEME +
				Constants.GDAX.HOST +
				Constants.GDAX.MarketPaths.PRODUCTS  +
				productId +
				Constants.GDAX.MarketPaths.CANDLES;
		
		System.out.println("URI being used is " + URI);
		
		Object[] array;
		array = restTemplate.getForObject(URI, Object[].class);
		System.out.println("ARRAY OBJECT = " + array);
		ArrayList<Candle> candleList = new ArrayList<>();
		
		for(int i = 0; i < array.length; i++) {
			Candle temp = new Candle();
			
			String arrayString = array[i].toString();
			//System.out.println("arrayString = " + arrayString);
			String[] stringArray = ((String) array[i].toString().subSequence(1, arrayString.length() - 1)).split(",");
			
			temp.setTime(Long.parseLong(stringArray[0]));
			temp.setLow(Double.parseDouble(stringArray[1]));
			temp.setHigh(Double.parseDouble(stringArray[2]));
			temp.setOpen(Double.parseDouble(stringArray[3]));
			temp.setClose(Double.parseDouble(stringArray[4]));
			temp.setVolume(Double.parseDouble(stringArray[5]));
			
			candleList.add(temp);	
		}
		System.out.println("candleList size = " + candleList.size());
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
		final String URI = Constants.HTTP.SCHEME +
				Constants.GDAX.HOST +
				Constants.GDAX.MarketPaths.PRODUCTS  +
				productId +
				Constants.GDAX.MarketPaths.STATS;
		
		RestTemplate template = new RestTemplate();
		Stats stats = template.getForObject(URI, Stats.class);
		
		return stats;
	}

}
