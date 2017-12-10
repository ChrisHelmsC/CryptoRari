package com.cryptoRari.personal;

import com.cryptoRari.entities.Orders.AccountOrder;
import com.cryptoRari.utilities.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import com.cryptoRari.entities.Orders.OrderResponse;
import java.io.IOException;

public class OrdersService {
	
	private RestTemplate restTemplate;
	private Authenticator authenticator;
	
	public OrdersService(String apiKey, String passPhrase, String secret) {
		restTemplate = new RestTemplate();
		authenticator = new Authenticator(apiKey, passPhrase, secret);
	}
	
	public OrderResponse postOrder(AccountOrder accountOrder, String epochTime) {
		String URI = Constants.URL +
						Constants.GDAX.PrivatePaths.ORDERS;

		try {
			//Get order object as body
			String orderBody = new ObjectMapper().writeValueAsString(accountOrder);
			System.out.println("Body: " + orderBody);

			//Authenticator has replaced header builder, essentially does the same thing, note we are using POST
			authenticator.setMethodAttributes(epochTime,
												orderBody,
												Constants.GDAX.PrivatePaths.ORDERS,
												Constants.HTTP.Methods.POST);

			//Create header from authenticator
			HttpHeaders httpHeaders = authenticator.buildHeaders();

			//Create entity using headers
			HttpEntity<String> entity = new HttpEntity<String>(orderBody, httpHeaders);

			//Exchange our request for the servers response, note that POST is used instead of get
			ResponseEntity<String> response = restTemplate.exchange(URI, HttpMethod.POST, entity, String.class);

			//Parse response body for order data
			String responseBody = response.getBody();
			System.out.println(responseBody);
			OrderResponse orderResponse= new ObjectMapper().readValue(responseBody, OrderResponse.class);

			//Return list of accounts
			return orderResponse;
		} catch(JsonProcessingException e) {
			System.out.println("Could not convert order to JSON");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error contacting server.");
			e.printStackTrace();
		}  catch (HttpClientErrorException e) {
			//This will print out the actual server error instead of just "404"
			System.out.println(e.getStatusCode());
			System.out.println(e.getResponseBodyAsString());
		}

		return null;
	}
}
