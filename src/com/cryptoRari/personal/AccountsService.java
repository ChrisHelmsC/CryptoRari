package com.cryptoRari.personal;

import java.util.ArrayList;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.cryptoRari.entities.Account;
import com.cryptoRari.marketData.TimeService;
import com.cryptoRari.utilities.Constants;
import com.cryptoRari.utilities.Environment;
import com.cryptoRari.utilities.HeaderBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;

public class AccountsService {

	private RestTemplate restTemplate;
	
	public AccountsService() {
		this.restTemplate = new RestTemplate();
	}
	
	public String getAccounts(String epochTime) {
		String URI = Constants.URL +
					Constants.GDAX.PrivatePaths.ACCOUNTS;
		
		//Create GDAX headers
		HeaderBuilder headerBuilder = new HeaderBuilder(Environment.API_KEY,
				epochTime,
				Environment.PASSPHRASE,
				"",
				Constants.GDAX.PrivatePaths.ACCOUNTS,
				Constants.HTTP.Methods.GET,
				Environment.SECRET
				);
		try {
			HttpHeaders httpHeaders = headerBuilder.buildHeaders();
			
			//Add headers to request
			HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);
	        ResponseEntity<String> response = restTemplate.exchange(URI, HttpMethod.GET, entity, String.class);
	        return response.toString();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
}
