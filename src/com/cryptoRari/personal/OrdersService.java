package com.cryptoRari.personal;

import com.cryptoRari.entities.Orders.AccountOrder;
import com.cryptoRari.utilities.Constants;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import com.cryptoRari.entities.Orders.OrderResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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

	public String cancelOrder(String orderId, String epochTime) {
		String URI = Constants.URL +
				Constants.GDAX.PrivatePaths.ORDERS +
				"/" + orderId;

		//delete request has no body
		String deleteBody = "";

		//Authenticator has replaced header builder, essentially does the same thing, note we are using POST
		authenticator.setMethodAttributes(epochTime,
				deleteBody,
				Constants.GDAX.PrivatePaths.ORDERS + "/" + orderId,
				Constants.HTTP.Methods.DELETE);

		//Create header from authenticator
		HttpHeaders httpHeaders = authenticator.buildHeaders();

		//Create entity using headers
		HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);

		//Exchange our request for the servers response, note that POST is used instead of get
		ResponseEntity<String> response = restTemplate.exchange(URI, HttpMethod.DELETE, entity, String.class);

		//Extract single ID from array
		try {
			String[] idArray = new ObjectMapper().readValue(response.getBody(), String[].class);

			//Return id
			return idArray[0];

		} catch (HttpClientErrorException e) {
			//This will print out the actual server error instead of just "404"
			System.out.print("Erorr:");
			System.out.println(e.getStatusCode());
			System.out.println(e.getResponseBodyAsString());
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<String> cancelAllOrders (String productId, String epochTime) {
		//Get string for canceling orders specific to product
		String params = "";
		if(!productId.isEmpty()) {
			params += "?" +
							Constants.GDAX.Orders.Parameters.PRODUCT_ID +
							"=" +
							productId;
		}

		//Uri with added product param
		String URI = Constants.URL +
				Constants.GDAX.PrivatePaths.ORDERS +
				params
				;

		//Delete request has no body
		String deleteBody = "";

		try {
			//Authenticator has replaced header builder, essentially does the same thing, note we are using POST
			authenticator.setMethodAttributes(epochTime,
					deleteBody,
					Constants.GDAX.PrivatePaths.ORDERS + params,
					Constants.HTTP.Methods.DELETE);

			//Create header from authenticator
			HttpHeaders httpHeaders = authenticator.buildHeaders();

			//Create entity using headers
			HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);

			//Exchange our request for the servers response
			ResponseEntity<String> response = restTemplate.exchange(URI, HttpMethod.DELETE, entity, String.class);
			String[] canceledIds = new ObjectMapper().readValue(response.getBody(), String[].class);

			//Get ids of delete orders from response
			ArrayList<String> cancelIdList = new ArrayList<>(Arrays.asList(canceledIds));

			return cancelIdList;

		} catch (JsonProcessingException e) {
			System.out.println("Could not convert object to JSON");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<OrderResponse> getOrders(ArrayList<String> statuses, String epochTime) {
		//Get statuses for URI
		String statusParams = getStatusAsParams(statuses);

		String URI = Constants.URL +
					Constants.GDAX.PrivatePaths.ORDERS +
					statusParams;

		//Get request has no body
		String getOrdersBody = "";

		//Authenticator has replaced header builder, essentially does the same thing, note we are using POST
		authenticator.setMethodAttributes(epochTime,
				getOrdersBody,
				Constants.GDAX.PrivatePaths.ORDERS + statusParams,
				Constants.HTTP.Methods.GET);

		//Create header from authenticator
		HttpHeaders httpHeaders = authenticator.buildHeaders();

		//Create entity using headers
		HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);

		//Exchange our request for the servers response
		ResponseEntity<String> response = restTemplate.exchange(URI, HttpMethod.GET, entity, String.class);
		String responseBody = response.getBody();

		try {
			//Parse body for OrderResponses
			OrderResponse[] responseArray = new ObjectMapper().readValue(responseBody, OrderResponse[].class);
			ArrayList<OrderResponse> responseList = new ArrayList<>(Arrays.asList(responseArray));

			return responseList;
		} catch (HttpClientErrorException e) {
			//This will print out the actual server error instead of just "404"
			System.out.println(e.getStatusCode());
			System.out.println(e.getResponseBodyAsString());
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	private String getStatusAsParams(ArrayList<String> statuses) {
		if(statuses.isEmpty()) {
			return "";
		}


		String params = "?";
		while(!statuses.isEmpty()) {
			params += "status=" + statuses.remove(0);

			if(!statuses.isEmpty()) {
				params += "&";
			}
		}

		return params;
	}

}
