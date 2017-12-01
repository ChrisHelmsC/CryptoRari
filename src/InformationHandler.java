import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.coinbase.exchange.api.accounts.*;

//Receives 200 OK response from google

public class InformationHandler {

	public static void main(String[] args) {
		//Proof GDAX JAR is working
		Account myAccount = new Account();
		myAccount.getBalance();
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://google.com");
		CloseableHttpResponse response1;
		
		//Execute request
		try {
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
