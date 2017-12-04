package com.cryptoRari.utilities;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.http.HttpHeaders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HeaderBuilder {
	
	private String accessKey;
	private String timeStamp;
	private String passPhrase;
	private String secret;
	private String body;
	private String path;
	private String method;
	
	public HeaderBuilder (String accessKey, String timeStamp, String passPhrase, String body, String path, String method, String secret) {
		this.accessKey = accessKey;
		this.timeStamp = timeStamp;
		this.passPhrase = passPhrase;
		this.body = body;
		this.path = path;
		this.method = method;
		this.secret = secret;
	}
	
	public HttpHeaders buildHeaders() throws JsonProcessingException {
		//JSON encode body for signature
		ObjectMapper mapper = new ObjectMapper();
		String encodedBody = (body.isEmpty()) ? body : mapper.writeValueAsString(body);
		
		//Concatenate full string
		String full = timeStamp + method + path + encodedBody;
		
		//Hash full string to create signed header
		String signature = hashHmac(full, secret);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add(Constants.GDAX.Headers.CB_ACCESS_SIGN, signature);
		headers.add(Constants.GDAX.Headers.CB_ACCESS_KEY, this.accessKey);
		headers.add(Constants.GDAX.Headers.CB_ACCESS_TIMESTAMP, this.timeStamp);
		headers.add(Constants.GDAX.Headers.CS_ACCESS_PASSPHRASE, this.passPhrase);
		
		return headers;
	}
	
	private String hashHmac(String str, String secret) {
		Mac sha256_HMAC;
		try {
			//Set MAC algorithm
			sha256_HMAC = Mac.getInstance("HmacSHA256");
		
			//Attempt to create mac with secret key
			byte[] bytes = Base64.getDecoder().decode(secret);
			SecretKeySpec secretKey = new SecretKeySpec(bytes, "HmacSHA256");
		
			sha256_HMAC.init(secretKey);
			
			String hash = Base64.getEncoder().encodeToString(sha256_HMAC.doFinal(str.getBytes()));
			//= Base64.encodeToString(sha256_HMAC.doFinal(str.getBytes()), Base64.DEFAULT);
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
}
