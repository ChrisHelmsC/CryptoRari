package tests.personal;

import static org.junit.Assert.assertTrue;

import com.cryptoRari.personal.Authenticator;
import org.junit.Test;
import org.springframework.http.HttpHeaders;

import com.cryptoRari.marketData.TimeService;
import com.cryptoRari.utilities.Constants;
import com.cryptoRari.utilities.Environment;
import com.fasterxml.jackson.core.JsonProcessingException;

public class AuthenticatorTest {
	
	Authenticator authenticator;
	TimeService timeService;
	
	public AuthenticatorTest() {
		this.timeService = new TimeService();
	}
	
	@Test
	public void buildingOfHeaderTest() {
		this.authenticator = new Authenticator(
				Environment.API_KEY,
				Environment.PASSPHRASE,
				Environment.SECRET
				);
		
		authenticator.setMethodAttributes(timeService.getTime().getEpoch(),
										"",
										Constants.GDAX.PrivatePaths.ACCOUNTS,
										Constants.HTTP.Methods.GET);
		

		HttpHeaders header = authenticator.buildHeaders();
		assertTrue(header != null);
		System.out.println(header.toString());
	}
}
