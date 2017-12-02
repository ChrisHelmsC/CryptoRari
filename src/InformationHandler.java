import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.web.client.RestTemplate;
import com.coinbase.exchange.api.accounts.*;
import com.coinbase.exchange.api.products.ProductService;

import entities.Ticker;

public class InformationHandler {

	public static void main(String [] args) {		
		String bitcoinId = Constants.GDAX.ProductIds.BTC_PRODUCT_ID;
		System.out.print(getTicker(bitcoinId).toString());
	}
	
	public static Ticker getTicker(String productId) {
		String URI = Constants.HTTP.SCHEME +
					Constants.GDAX.HOST +
					Constants.GDAX.MarketPaths.PRODUCTS  +
					productId +
					Constants.GDAX.MarketPaths.TICKER;
				
		RestTemplate restTemplate = new RestTemplate();
        Ticker ticker = restTemplate.getForObject(URI, Ticker.class);
        
        return ticker;
	}
}
