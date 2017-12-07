package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import com.cryptoRari.entities.Candle;
import com.cryptoRari.entities.OrderBook;
import com.cryptoRari.entities.Stats;
import com.cryptoRari.entities.Ticker;
import com.cryptoRari.entities.Trade;
import com.cryptoRari.marketData.ProductsService;
import com.cryptoRari.services.InformationHandler;
import com.cryptoRari.utilities.Constants;

public class ProductsServiceTest {
	
	ProductsService PS;
	
	public ProductsServiceTest() {
		PS = new ProductsService();
	}
	

//	@Test
//	public void testGetProducts() {
//		List productList = new ArrayList();
//		productList = PS.getProducts();
//		System.out.println(productList);
//		
//		/*
//		 * can also use assertEquals(expected, actual)
//		 * it will test to see if expected = actual, they are just variables of any data type
//		 */
//		assertTrue(productList.size() > 0); //passes if this statement is true can have as many as you want
//		assertTrue(productList != null);
//	}
//	
//	
//	@Test
//	public void testGetTicker() {
//		String bitcoinId = Constants.GDAX.ProductIds.BTC_PRODUCT_ID;
//		Ticker btcTicker = PS.getTicker(bitcoinId);
//		
//		String etherumId = Constants.GDAX.ProductIds.ETH_PRODUCT_ID;
//		Ticker ethTicker = PS.getTicker(etherumId);
//		
//		String litecoinId = Constants.GDAX.ProductIds.LTC_PRODUCT_ID;
//		Ticker ltcTicker = PS.getTicker(litecoinId);
//		
//		assertTrue(btcTicker != null);
//		assertTrue(ethTicker != null);
//		assertTrue(ltcTicker != null);
//	}
//	
//	@Test
//	public void testGetTrades() {
//		//Only check BTC trades to avoid GDAX request limit
//		String bitcoinId = Constants.GDAX.ProductIds.BTC_PRODUCT_ID;
//		ArrayList<Trade> btcTrades = PS.getTrades(bitcoinId);
//		
//		assertTrue(btcTrades != null);
//		assertTrue(btcTrades.size() > 0);
//	}
//	
//	@Test
//	public void testGetStats() {
//		String bitcoinId = Constants.GDAX.ProductIds.BTC_PRODUCT_ID;
//		Stats btcStats = PS.getStats(bitcoinId);
//		
//		String etherumId = Constants.GDAX.ProductIds.ETH_PRODUCT_ID;
//		Stats ethStats = PS.getStats(etherumId);
//		
//		String litecoinId = Constants.GDAX.ProductIds.LTC_PRODUCT_ID;
//		Stats ltcStats = PS.getStats(litecoinId);
//		
//		assertTrue(btcStats != null);
//		assertTrue(ethStats != null);
//		assertTrue(ltcStats != null);
//	}
//	
//	/*@Test
//	public void testGetOrderBook() {
//		final String bitcoinId = Constants.GDAX.ProductIds.BTC_PRODUCT_ID;
//		OrderBook btcOrders = PS.getOrderBook(bitcoinId);
//		
//		assertTrue(btcOrders != null);
//	}*/
//	
//	@Test
//	public void testGetHistoricRates() {
//		ArrayList<Candle> historicRates = new ArrayList<>();
//		String productId = Constants.GDAX.ProductIds.BTC_PRODUCT_ID;
//		historicRates = PS.getHistoricRates(productId);
//		
//		System.out.println("Historic Rates = " + historicRates);
//		
//		assertTrue(historicRates != null);
//		assertTrue(historicRates.size() > 0);
//	}
//	
//	
//	@Test
//	public void testGetOrderBookLvl1() {
//		ArrayList<OrderBook> orderBookList = new ArrayList<>();
//		String productId = Constants.GDAX.ProductIds.BTC_PRODUCT_ID;
//		orderBookList = PS.getOrderBookLvl1(productId);
//		
//		System.out.println("Order Book = " + orderBookList);
//		
//		assertTrue(orderBookList != null);
//		assertTrue(orderBookList.size() > 0);
//	}
	
	@Test
	public void testGetOrderBookLvl2() {
		ArrayList<OrderBook> orderBookList = new ArrayList<>();
		String productId = Constants.GDAX.ProductIds.BTC_PRODUCT_ID;
		orderBookList = PS.getOrderBookLvl2(productId);
		
		System.out.println("Order Book = " + orderBookList);
		
		assertTrue(orderBookList != null);
		assertTrue(orderBookList.size() > 0);
	}
	

}
