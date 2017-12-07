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
import com.cryptoRari.entities.Hold;
import com.cryptoRari.entities.Ledger;
import com.cryptoRari.marketData.TimeService;
import com.cryptoRari.utilities.Constants;
import com.cryptoRari.utilities.Environment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AccountsService {

	private HeaderBuilder headerBuilder;
	private RestTemplate restTemplate;
	
	public AccountsService(String apiKey, String passPhrase, String secret) {
		this.headerBuilder = new HeaderBuilder(apiKey, passPhrase, secret);
		this.restTemplate = new RestTemplate();
	}
	
	/***********************************************
	 * getAccounts()
	 * Returns a list of accounts for current user
	 * 
	 * @epochTime - current epoch time
	 ************************************************/
	public ArrayList<Account> getAccounts(String epochTime) {
		String URI = Constants.URL +
					Constants.GDAX.PrivatePaths.ACCOUNTS;
		
		//Get requests have no body
		String accountsBody = "";
		
		//Setup headerBuilder method attributes
		headerBuilder.setMethodAttributes(epochTime, 
										accountsBody, 
										Constants.GDAX.PrivatePaths.ACCOUNTS, 
										Constants.HTTP.Methods.GET);
		
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
	
	/***********************************************
	 * getAccountHistory()
	 * Returns a list of accounts for current user
	 * 
	 * @accountId - account ID to get history for
	 * @epochTime - current epoch time
	 ************************************************/
	public ArrayList<Ledger> getAccountHistory(String accountId, String epochTime) {
		String URI = Constants.URL +
					Constants.GDAX.PrivatePaths.ACCOUNTS +
					"/" + accountId +
					Constants.GDAX.PrivatePaths.ACCOUNT_HISTORY;
		
		//Create native strings
		String accountHistoryBody = "";
		String accountHistoryPath = Constants.GDAX.PrivatePaths.ACCOUNTS +
									"/" + accountId +
									Constants.GDAX.PrivatePaths.ACCOUNT_HISTORY;
		
		headerBuilder.setMethodAttributes(epochTime,
											accountHistoryBody,
											accountHistoryPath, 
											Constants.HTTP.Methods.GET);
		
		try {
			//Build headers to add to request
			HttpHeaders httpHeaders = headerBuilder.buildHeaders();
			
			//Create entity using headers
			HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);
			
			//Exchange our request for the servers response
	        ResponseEntity<String> response = restTemplate.exchange(URI, HttpMethod.GET, entity, String.class);
	        
	        //Parse response body for Ledger array data
	        String responseBody = response.getBody();
	        Ledger[] ledgerArray = new ObjectMapper().readValue(responseBody, Ledger[].class);
	        ArrayList<Ledger> ledgerList = new ArrayList<Ledger>(Arrays.asList(ledgerArray));
	        
	        //Return list of accounts
	        return ledgerList;
	        
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Could not parse request body for ledger data.");
			e.printStackTrace();
		}
		
		return null;
	}
	
	/***********************************************
	 * getHolds()
	 * Returns a list of holds for a specific account
	 * 
	 * @accountId - account ID to get history for
	 * @epochTime - current epoch time
	 ************************************************/
	public ArrayList<Hold> getHolds(String accountId, String epochTime) {
		String URI = Constants.URL +
				Constants.GDAX.PrivatePaths.ACCOUNTS +
				"/" + accountId +
				Constants.GDAX.PrivatePaths.HOLDS;
		
		//Create native strings
		String holdsBody = "";
		String holdsPath = Constants.GDAX.PrivatePaths.ACCOUNTS +
							"/" + accountId +
							Constants.GDAX.PrivatePaths.HOLDS;
		
		headerBuilder.setMethodAttributes(epochTime, 
										holdsBody, 
										holdsPath, 
										Constants.HTTP.Methods.GET);
		
		try {
			//Build headers to add to request
			HttpHeaders httpHeaders = headerBuilder.buildHeaders();
			
			//Create entity using headers
			HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);
			
			//Exchange our request for the servers response
	        ResponseEntity<String> response = restTemplate.exchange(URI, HttpMethod.GET, entity, String.class);
	        
	        //Parse response body for hold array data
	        String responseBody = response.getBody();
	        Hold[] holdsArray = new ObjectMapper().readValue(responseBody, Hold[].class);
	        ArrayList<Hold> holdList = new ArrayList<Hold>(Arrays.asList(holdsArray));
	        
	        //Return list of accounts
	        return holdList;
	        
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Could not parse request body for hold data.");
			e.printStackTrace();
		}
		
		return null;
	}
}
