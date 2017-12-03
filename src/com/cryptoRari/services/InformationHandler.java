package com.cryptoRari.services;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.client.RestTemplate;

import com.coinbase.exchange.api.accounts.*;
import com.coinbase.exchange.api.products.ProductService;

import entities.Product;

/*According to the GDAX API, the account based headers are not needed
 * for just getting public market data on currencies. 
 * 
 * Running this test allows us to grab the information for BTC-USD
 * from the server.
 */

public class InformationHandler {
	
	String baseURL = "https://api.gdax.com";
	
	URI URITemplate;
	RestTemplate restTemplate;
	
	public InformationHandler() {
		restTemplate = new RestTemplate();
		/*
		URITemplate = new URIBuilder();
		URITemplate.setScheme(Constants.HTTP.SCHEME);
		URITemplate.setHost(Constants.GDAX.SANDBOX_HOST);
		URITemplate.build();// sandbox for testing
		*/
	}
	
	public ArrayList<Product> getProducts() {
		//RestTemplate restTemplate = new RestTemplate();
		/*
		if(currency.equals("BTC")) {
			URITemplate.setPath(Constants.GDAX.MarketPaths.PRODUCTS);
		}
		URITemplate.build();
		*/
		System.out.println("HERE");
		Product[] newProducts = restTemplate.getForObject(baseURL + "/products", Product[].class);
		System.out.println(newProducts);
		System.out.println("URI being used = " + URITemplate);
		ArrayList<Product> productList = new ArrayList<>(Arrays.asList(newProducts));
		return productList;
	}

	public static void main(String [] args) {
		RestTemplate restTemplate = new RestTemplate();
        Object tempobj = restTemplate.getForObject("https://api.gdax.com/products", Object.class);
        System.out.println(tempobj.toString());
		
	}
}
