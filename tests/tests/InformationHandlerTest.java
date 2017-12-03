package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import com.cryptoRari.entities.OrderBook;
import com.cryptoRari.entities.Stats;
import com.cryptoRari.entities.Ticker;
import com.cryptoRari.entities.Trade;
import com.cryptoRari.services.InformationHandler;
import com.cryptoRari.utilities.Constants;

public class InformationHandlerTest {
	
	InformationHandler IH;
	
	public InformationHandlerTest() {
		IH = new InformationHandler();
	}

	@Test
	public void testGetProducts() {
		List productList = new ArrayList();
		productList = IH.getProducts();
		System.out.println(productList);
		
		/*
		 * can also use assertEquals(expected, actual)
		 * it will test to see if expected = actual, they are just variables of any data type
		 */
		assertTrue(productList.size() > 0); //passes if this statement is true can have as many as you want
		assertTrue(productList != null);
	}
	
	
	@Test
	public void testGetTicker() {
		String bitcoinId = Constants.GDAX.ProductIds.BTC_PRODUCT_ID;
		Ticker btcTicker = IH.getTicker(bitcoinId);
		
		String etherumId = Constants.GDAX.ProductIds.ETH_PRODUCT_ID;
		Ticker ethTicker = IH.getTicker(etherumId);
		
		String litecoinId = Constants.GDAX.ProductIds.LTC_PRODUCT_ID;
		Ticker ltcTicker = IH.getTicker(litecoinId);
		
		assertTrue(btcTicker != null);
		assertTrue(ethTicker != null);
		assertTrue(ltcTicker != null);
	}
	
	@Test
	public void testGetTrades() {
		//Only check BTC trades to avoid GDAX request limit
		String bitcoinId = Constants.GDAX.ProductIds.BTC_PRODUCT_ID;
		ArrayList<Trade> btcTrades = IH.getTrades(bitcoinId);
		
		assertTrue(btcTrades != null);
		assertTrue(btcTrades.size() > 0);
	}
	
	@Test
	public void testGetStats() {
		String bitcoinId = Constants.GDAX.ProductIds.BTC_PRODUCT_ID;
		Stats btcStats = IH.getStats(bitcoinId);
		
		String etherumId = Constants.GDAX.ProductIds.ETH_PRODUCT_ID;
		Stats ethStats = IH.getStats(etherumId);
		
		String litecoinId = Constants.GDAX.ProductIds.LTC_PRODUCT_ID;
		Stats ltcStats = IH.getStats(litecoinId);
		
		assertTrue(btcStats != null);
		assertTrue(ethStats != null);
		assertTrue(ltcStats != null);
	}
	
	/*@Test
	public void testGetOrderBook() {
		final String bitcoinId = Constants.GDAX.ProductIds.BTC_PRODUCT_ID;
		OrderBook btcOrders = IH.getOrderBook(bitcoinId);
		
		assertTrue(btcOrders != null);
	}*/

}
