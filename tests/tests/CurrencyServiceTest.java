package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import com.cryptoRari.entities.Currency;
import org.springframework.web.client.RestTemplate;
import com.cryptoRari.marketData.CurrencyService;

public class CurrencyServiceTest {
	
	private CurrencyService currencyService;
	
	public CurrencyServiceTest() {
		this.currencyService = new CurrencyService();
	}
	
	@Test
	public void testGetCurrencies () {
		ArrayList<Currency> currencies = this.currencyService.getCurrencies();
		
		assertTrue(currencies != null);
		assertTrue(currencies.size() > 0);
	}
}
