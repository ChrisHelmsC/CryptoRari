package com.cryptoRari.personal;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.http.HttpHeaders;

import com.cryptoRari.utilities.Constants;
import com.cryptoRari.utilities.Constants.GDAX;
import com.cryptoRari.utilities.Constants.GDAX.Headers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Authenticator {
	
	private String accessKey;
	private String timeStamp;
	private String passPhrase;
	private String secret;
	private String body;
	private String path;
	private String method;
	
	/***********************************************
	 * Authenticator
	 * 
	 * @accessKey - User's API key from GDAX
	 * @passPhrase - User's GDAX generated API key
	 * @secret - User's GDAX generated secret
	 * @timeStamp - Current timestamp
	 * @body - body of request headers will be built for
	 * @path - URL path of request (not include scheme, host, etc)
	 * @methed - Type of request headers will be built for IN CAPS (Ex: GET, POST, etc)
	 * 
	 ************************************************/
	public Authenticator(String accessKey, String passPhrase, String secret) {
		this.accessKey = accessKey;
		this.passPhrase = passPhrase;
		this.secret = secret;
	}
	
	/************************************************
	 * setMethodAttributes()
	 * 
	 * Sets attributes required for building method headers
	 * 
	 * @timeStamp - Current timestamp
	 * @body - body of request headers will be built for
	 * @path - URL path of request (not include scheme, host, etc)
	 * @method - Type of request headers will be built for IN CAPS (Ex: GET, POST, etc)
	 * 
	 ************************************************/
	public void setMethodAttributes(String timeStamp, String body, String path, String method) {
		this.timeStamp = timeStamp;
		this.body = body;
		this.path = path;
		this.method = method;
	}
	
	/***********************************************
	 * buildHeaders()
	 * 
	 * Returns GDAX required headers based on Authenticator attributes
	 ************************************************/
	public HttpHeaders buildHeaders() {
		
		//Concatenate full string
		String full = timeStamp + method + path + body;
		
		//Hash full string to create signed header
		String signature = getSignature(full, secret);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add(Constants.GDAX.Headers.CB_ACCESS_SIGN, signature);
		headers.add(Constants.GDAX.Headers.CB_ACCESS_KEY, this.accessKey);
		headers.add(Constants.GDAX.Headers.CB_ACCESS_TIMESTAMP, this.timeStamp);
		headers.add(Constants.GDAX.Headers.CS_ACCESS_PASSPHRASE, this.passPhrase);
		
		return headers;
	}
	
	/***********************************************
	 * getSignature()
	 * 
	 * returns a signature string representing the GDAX
	 * required header CB_ACCESS_SIGN
	 * 
	 * @encryptThis - the string that will be encrypted.
	 * 	Should consist of concat(epochTimeStamp, request method, request path, request body)
	 * @secret - secret used to encode message
	 ************************************************/
	private String getSignature(String encryptThis, String secret) {
		Mac sha256_HMAC;
		try {
			//Set MAC algorithm
			sha256_HMAC = Mac.getInstance("HmacSHA256");
		
			//Decode key into bytes, use it to create key
			byte[] bytes = Base64.getDecoder().decode(secret);
			SecretKeySpec secretKey = new SecretKeySpec(bytes, "HmacSHA256");
		
			//Create mac which will use key to encrypt a string
			sha256_HMAC.init(secretKey);
			
			//Encrypt the string, encode in BASE64
			String hash = Base64.getEncoder().encodeToString(sha256_HMAC.doFinal(encryptThis.getBytes()));
						return hash;
		} catch (InvalidKeyException e) {
			System.out.println("Mac cannot be initialzied with the given key");
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e1) {
			System.out.println("Given Mac algorithm does nto exist");
			e1.printStackTrace();
		}
		
		return null;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
}
