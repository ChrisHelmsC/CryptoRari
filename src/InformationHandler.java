import java.io.IOException;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.coinbase.exchange.api.accounts.*;

//Receives 200 OK response from google

public class InformationHandler {

	public static void main() {
		//Proof GDAX JAR is working
		Account myAccount = new Account();
		myAccount.getBalance();
		
		//Get time from the GDAX server
		String timeStamp = "";
		try {
			URI timeUri = new URIBuilder()
					.setScheme(Constants.HTTP.SCHEME) 
					.setHost(Constants.GDAX.HOST)
					.setPath(Constants.GDAX.Paths.TIME)
					.build();
			CloseableHttpClient timeClient = HttpClients.createDefault();
			HttpGet httpTimeGet = new HttpGet();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			//Create GDAX URI
			URI uri = new URIBuilder()
					.setScheme(Constants.HTTP.SCHEME)
					.setHost(Constants.GDAX.HOST)
					.setPath(Constants.GDAX.Paths.CURRENCIES)
					.build();
			
			//Create request
			HttpGet httpGet = new HttpGet(uri);
			
			//Set headers
			
			httpGet.setHeader(Constants.GDAX.Headers.CB_ACCESS_KEY, Environment.API_KEY);
			httpGet.setHeader(Constants.GDAX.Headers.CB_ACCESS_TIMESTAMP, );
			httpGet.setHeader(Constants.GDAX.Headers.CS_ACCESS_PASSPHRASE, Environment.PASSPHRASE);
			
			CloseableHttpResponse response1;
			
			//Execute request
			response1 = httpclient.execute(httpGet);
			System.out.println(response1.getStatusLine());
			HttpEntity entity1 = response1.getEntity();
			EntityUtils.consume(entity1);
		response1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
