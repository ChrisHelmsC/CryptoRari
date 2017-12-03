import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.web.client.RestTemplate;
import com.coinbase.exchange.api.accounts.*;
import com.coinbase.exchange.api.entity.Product;
import com.coinbase.exchange.api.products.ProductService;
import com.cryptoRari.entities.Ticker;

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
}
