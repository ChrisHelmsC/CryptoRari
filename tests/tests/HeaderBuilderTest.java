package tests;

import org.junit.Test;
import org.springframework.http.HttpHeaders;

import com.cryptoRari.marketData.TimeService;
import com.cryptoRari.personal.HeaderBuilder;
import com.cryptoRari.utilities.Constants;
import com.cryptoRari.utilities.Environment;
import com.fasterxml.jackson.core.JsonProcessingException;

public class HeaderBuilderTest {
	
	HeaderBuilder headerBuilder;
	TimeService timeService;
	
	public HeaderBuilderTest() {
		this.timeService = new TimeService();
	}
	
	@Test
	public void buildingOfHeaderTest() {
		this.headerBuilder = new HeaderBuilder(
				Environment.API_KEY,
				timeService.getTime().getEpoch(),
				Environment.PASSPHRASE,
				"",
				Constants.GDAX.PrivatePaths.ACCOUNTS,
				Constants.HTTP.Methods.GET,
				Environment.SECRET
				);
		
		try {
			HttpHeaders header = headerBuilder.buildHeaders();
			System.out.println(header.toString());
		} catch (JsonProcessingException e) {
			System.out.println("Failure");
			e.printStackTrace();
		}
	}

}
