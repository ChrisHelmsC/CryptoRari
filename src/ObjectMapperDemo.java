import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

//Temporary class for testing

public class ObjectMapperDemo {
	public Product readJsonWithObjectMapper(String responseBody) throws IOException{
		ObjectMapper objectMapper = new ObjectMapper();
		Product product = objectMapper.readValue(responseBody, Product.class);
		return product;
	}
}
