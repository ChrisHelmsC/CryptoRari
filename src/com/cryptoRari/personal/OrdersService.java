package com.cryptoRari.personal;

import org.springframework.web.client.RestTemplate;

import com.cryptoRari.entities.OrderResponse;

public class OrdersService {
	
	private RestTemplate restTemplate;
	private HeaderBuilder headerBuilder;
	
	public OrdersService(String apiKey, String passPhrase, String secret) {
		restTemplate = new RestTemplate();
		headerBuilder = new HeaderBuilder(apiKey, passPhrase, secret);		
	}
	
	public OrderResponse placeOrder() {
		return null;
	}
}
