import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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

/*According to the GDAX API, the account based headers are not needed
 * for just getting public market data on currencies. 
 * 
 * Running this test allows us to grab the information for BTC-USD
 * from the server.
 */

public class InformationHandler {
	
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
	
	public Product getProducts(String currency) {
		//RestTemplate restTemplate = new RestTemplate();
		/*
		if(currency.equals("BTC")) {
			URITemplate.setPath(Constants.GDAX.MarketPaths.PRODUCTS);
		}
		URITemplate.build();
		*/
		Product newProduct = restTemplate.getForObject(URITemplate, Product.class);
		return newProduct;
	}

	public static void main(String [] args) {
		RestTemplate restTemplate = new RestTemplate();
        Object tempobj = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Object.class);
        System.out.println(tempobj.toString());
		
	}
}
