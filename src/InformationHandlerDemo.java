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
import com.coinbase.exchange.api.accounts.*;
import com.coinbase.exchange.api.products.ProductService;

/*According to the GDAX API, the account based headers are not needed
 * for just getting public market data on currencies. 
 * 
 * Running this test allows us to grab the information for BTC-USD
 * from the server.
 */

public class InformationHandlerDemo {

	public static void main(String [] args) {
		//Proof GDAX JAR is working
		Account myAccount = new Account();
		myAccount.getBalance();
		
		
		/*Create URI to get price of BTC (Called a product). 
		 * Since this is public market data, the GDAX account
		 *  headers are not required.
		 * 
		 * The URI is https://api.gdax.com/products/BTC-USD/ticker
		 */
			
		try {
			URI btcPriceUri = new URIBuilder()
					.setScheme(Constants.HTTP.SCHEME)
					.setHost(Constants.GDAX.HOST)
					.setPath(Constants.GDAX.MarketPaths.PRODUCTS 
							+ Constants.GDAX.PRODUCT_IDS.BTC_PRODUCT_ID
							+ Constants.GDAX.MarketPaths.TICKER)
					.build();
			System.out.println("The URI being used is: " + btcPriceUri.toString());
			
			//Create request using the URI
			HttpGet httpGet = new HttpGet(btcPriceUri);
			
			//Create client, execute request using client, get response from GDAX
			CloseableHttpClient httpclient = HttpClients.createDefault();
			CloseableHttpResponse response1 = httpclient.execute(httpGet);
			
			//Get Http Entity which contains body and Bitcoin information
			HttpEntity entity = response1.getEntity();
			String body = EntityUtils.toString(entity);
			
			//Print out status line containing pay load
			System.out.println("The server response is: \n" + body);
			
			//Create an object from the response body using Spring Jackson
			ObjectMapperDemo objectMapper = new ObjectMapperDemo();
			Product product = objectMapper.readJsonWithObjectMapper(body);
			
			//Show product was successful
			System.out.print("Product object parsed from JSON: \n" + product.toString());
			
			//Release resources
			EntityUtils.consume(entity);
			response1.close();
			
		} catch (URISyntaxException e) {
			System.out.println("URI had bad syntax and could not be used.");
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			System.out.println("Client protocol error");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error closing the HttpResponse");
			e.printStackTrace();
		}
	}

}
