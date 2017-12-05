package com.cryptoRari.personal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.cryptoRari.entities.Account;
import com.cryptoRari.marketData.TimeService;
import com.cryptoRari.utilities.Constants;
import com.cryptoRari.utilities.Environment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AccountsService {

	private RestTemplate restTemplate;
	
	public AccountsService() {
		this.restTemplate = new RestTemplate();
	}
	
	/***********************************************
	 * getAccounts()
	 * Returns a list of accounts for current user
	 * 
	 * @epochTime - current epoch time
	 * @apiKey - users GDAX API key
	 * @passPhrase - users generated GDAX passPhrase
	 * @secret - users GDAX secret key
	 ************************************************/
	public ArrayList<Account> getAccounts(String epochTime, String apiKey, String passPhrase, String secret) {
		String URI = Constants.URL +
					Constants.GDAX.PrivatePaths.ACCOUNTS;
		
		//Create strings native to this type of request
		String accountsMethod = Constants.HTTP.Methods.GET;
		String accountsPath = Constants.GDAX.PrivatePaths.ACCOUNTS;
		String accountsBody = "";
		
		//Create HeaderBuilder with request info
		HeaderBuilder headerBuilder = new HeaderBuilder(
				apiKey,
				passPhrase,
				secret,
				epochTime,
				accountsBody,
				accountsPath,
				accountsMethod
				);
		
		try {
			//Build headers to add to request
			HttpHeaders httpHeaders = headerBuilder.buildHeaders();
			
			//Create entity using headers
			HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);
			
			//Exchange our request for the servers response
	        ResponseEntity<String> response = restTemplate.exchange(URI, HttpMethod.GET, entity, String.class);
	        
	        //Parse response body for account array data
	        String responseBody = response.getBody();
	        Account[] accountsArray = new ObjectMapper().readValue(responseBody, Account[].class);
	        ArrayList<Account> accountList = new ArrayList<Account>(Arrays.asList(accountsArray));
	        
	        //Return list of accounts
	        return accountList;
	        
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Could not parse request body for accounts data.");
			e.printStackTrace();
		}
		
		return null;
	}
}
